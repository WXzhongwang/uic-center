package com.rany.uic.domain.page;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.rany.uic.common.base.BasePageQuery;
import com.rany.uic.domain.page.annotation.PagingQuery;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/1/3 22:18
 * @email 18668485565163.com
 */
@Aspect
@Slf4j
@Component
public class PageAop {

    @Before("@annotation(pagingQuery)")
    public void pagingQuery(JoinPoint joinPoint, PagingQuery pagingQuery) {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        log.info("method enter the paging aop: {}, args:{}", methodName, JSON.toJSONString(args));
        if (args == null || args.length == 0) {
            return;
        }
        Object arg = args[0];
        if (!(arg instanceof BasePageQuery)) {
            log.warn("{}必须是PageQuery的子类", methodName);
            return;
        }
        BasePageQuery basePageQuery = (BasePageQuery) arg;
        try {
            Integer pageNo = basePageQuery.getPageNo();
            Integer pageSize = basePageQuery.getPageNo();
            log.info("{}分页执行参数 pageNo:{}, pageSize:{}", methodName, pageNo, pageSize);
            if (pageNo != null && pageNo > 0 && pageSize != null && pageSize > 0) {
                PageHelper.startPage(pageNo, pageSize, true);
            }
        } catch (Throwable e) {
            log.error("PageAop execute error", e);
            PageHelper.clearPage();
        }
    }
}
