package com.rany.uic.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 11:40
 * @email 18668485565163.com
 */
public abstract class BaseChecker {
    private static final String SPRING_EL_FLAG = "#";
    private static final ExpressionParser PARSER = new SpelExpressionParser();

    protected LinkedHashMap<String, Object> resolveParams(JoinPoint joinPoint) {
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
    
    protected String resolveValue(String exp, EvaluationContext context) {
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

    private String[] getParameterNames(Method method) {
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        return parameterNameDiscoverer.getParameterNames(method);
    }


    private String resolveValueByExpression(String spELString, EvaluationContext context) {
        Expression expression = PARSER.parseExpression(spELString);
        return expression.getValue(context, String.class);
    }
}
