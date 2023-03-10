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
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

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
public class IsvValidCheckAop extends BaseChecker {

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
            log.info("??????isv???????????????");
            return joinPoint.proceed();
        }

        // ?????????????????????key???????????????value????????????
        LinkedHashMap<String, Object> params = resolveParams(joinPoint);
        // ???????????????
        StandardEvaluationContext context = new StandardEvaluationContext();
        if (params.size() == 1) {
            // ?????????????????????????????????????????????????????????????????????????????????????????? #root.id ??????????????????id
            params.forEach((k, v) -> context.setRootObject(v));
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }

        String result = resolveValue(check.expression(), context);
        log.info("EL?????????????????????: {}", result);
        if (result == null || result.isEmpty()) {
            throw new BusinessException(BusinessErrorMessage.ISV_CHECK_NOT_PASS);
        }
        try {
            Long isvId = Long.parseLong(result);
            Isv isv = domainService.findById(new IsvId(isvId));
            if (Objects.isNull(isv)) {
                throw new BusinessException(BusinessErrorMessage.ISV_NOT_FOUND);
            }
            if (StringUtils.equals(isv.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DELETED);
            }
            if (StringUtils.equals(isv.getStatus(), CommonStatusEnum.DISABLED.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DISABLED);
            }
        } catch (Exception exception) {
            log.error("?????????????????????:{}", exception.getMessage(), exception);
            throw new BusinessException(BusinessErrorMessage.ISV_CHECK_NOT_PASS);
        }
        return joinPoint.proceed();
    }


}
