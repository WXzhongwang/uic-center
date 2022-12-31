package com.rany.uic.service.aop;

import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.exception.BusinessException;
import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.domain.aggregate.Isv;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.service.IsvDomainService;
import com.rany.uic.service.aop.annotation.IsvValidCheck;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 10:26
 * @email 18668485565163.com
 */
@Slf4j
@Aspect
@Component
@EnableAspectJAutoProxy
public class IsvValidCheckAop {

    private static final String SPRING_EL_FLAG = "#";
    private static final ExpressionParser PARSER = new SpelExpressionParser();
    @Resource
    private IsvDomainService domainService;

    @Pointcut("@annotation(com.rany.uic.service.aop.annotation.IsvValidCheck)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object check(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        IsvValidCheck check = method.getAnnotation(IsvValidCheck.class);
        if (check.ignore()) {
            log.info("跳过isv有效性检查");
            return joinPoint.proceed();
        }

        // 获取方法入参，key为参数名，value为参数值
        LinkedHashMap<String, Object> params = resolveParams(joinPoint);
        // 求值上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        if (params.size() == 1) {
            // 当参数只有一个时，设置根对象，例如入参为对象，则此时可以使用 #root.id 来获取对象的id
            params.forEach((k, v) -> context.setRootObject(v));
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }

        String result = resolveValue(check.expression(), context);
        log.info("EL表达式解析结果: {}", result);
        if (result == null || result.isEmpty()) {
            throw new BusinessException(BusinessErrorMessage.ISV_CHECK_NOT_PASS);
        }
        try {
            Long isvId = Long.parseLong(result);
            Isv isv = domainService.find(new IsvId(isvId));
            if (StringUtils.equals(isv.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DELETED);
            }
            if (StringUtils.equals(isv.getStatus(), CommonStatusEnum.DISABLED.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DELETED);
            }
        } catch (Exception exception) {
            log.error("检查有效性失败:{}", exception.getMessage(), exception);
            throw new BusinessException(BusinessErrorMessage.ISV_CHECK_NOT_PASS);
        }
        return joinPoint.proceed();
    }

    private LinkedHashMap<String, Object> resolveParams(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] arguments = joinPoint.getArgs();
        String[] paramNames = getParameterNames(method);

        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        for (int i = 0; i < arguments.length; i++) {
            params.put(paramNames[i], arguments[i]);
        }
        return params;
    }

    private String[] getParameterNames(Method method) {
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        return parameterNameDiscoverer.getParameterNames(method);
    }

    private String resolveValue(String exp, EvaluationContext context) {
        String value;
        // 如果包含#字符，则使用SpringEL表达式进行解析
        if (exp.contains(SPRING_EL_FLAG)) {
            value = resolveValueByExpression(exp, context);
        } else {
            // 否则不处理
            value = exp;
        }
        return value;
    }

    private String resolveValueByExpression(String spELString, EvaluationContext context) {
        Expression expression = PARSER.parseExpression(spELString);
        return expression.getValue(context, String.class);
    }

}
