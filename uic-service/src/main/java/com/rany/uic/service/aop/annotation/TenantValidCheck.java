package com.rany.uic.service.aop.annotation;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/31 10:28
 * @email 18668485565163.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface TenantValidCheck {

    /**
     * 跳过检查
     *
     * @return
     */
    boolean ignore() default false;

    /**
     * el表达式
     *
     * @return
     */
    String expression() default "";
}
