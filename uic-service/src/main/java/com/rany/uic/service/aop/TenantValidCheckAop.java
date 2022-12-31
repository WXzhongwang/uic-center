package com.rany.uic.service.aop;

import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.exception.BusinessException;
import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.service.TenantDomainService;
import com.rany.uic.service.aop.annotation.TenantValidCheck;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
public class TenantValidCheckAop extends BaseChecker {
    @Resource
    private TenantDomainService tenantDomainService;

    @Pointcut("@annotation(com.rany.uic.service.aop.annotation.TenantValidCheck)")
    public void pointcut() {

    }
    
    @Around("pointcut()")
    public Object check(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        TenantValidCheck check = method.getAnnotation(TenantValidCheck.class);
        if (check.ignore()) {
            log.info("跳过租户有效性检查");
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
            throw new BusinessException(BusinessErrorMessage.TENANT_CHECK_NOT_PASS);
        }
        try {
            Long tenantId = Long.parseLong(result);
            Tenant tenant = tenantDomainService.findById(new TenantId(tenantId));
            if (Objects.isNull(tenant)) {
                throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
            }
            if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
                throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
            }
            if (StringUtils.equals(tenant.getStatus(), CommonStatusEnum.DISABLED.getValue())) {
                throw new BusinessException(BusinessErrorMessage.TENANT_DISABLED);
            }
        } catch (Exception exception) {
            log.error("检查有效性失败:{}", exception.getMessage(), exception);
            throw new BusinessException(BusinessErrorMessage.TENANT_CHECK_NOT_PASS);
        }
        return joinPoint.proceed();
    }
}
