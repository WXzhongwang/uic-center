package com.rany.uic;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cake.framework.mybatis.ParamLimitInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * UIC Application
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2021/11/3 10:40 下午
 * @email 18668485565@163.com
 */
@EnableDubbo
@EnableTransactionManagement
@SpringBootApplication
@EnableAutoConfiguration(exclude = {ParamLimitInterceptor.class})
@MapperScan(basePackages = {"com.rany.uic.domain.dao", "com.rany.uic.infra.mapper"})
@ComponentScan({"com.rany.uic.domain", "com.rany.uic.infra", "com.rany.uic.service"})
public class UicApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UicApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UicApplication.class);
    }
}