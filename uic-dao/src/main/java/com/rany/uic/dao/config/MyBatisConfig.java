package com.rany.uic.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2021/11/3 11:26 下午
 * @email 18668485565@163.com
 */
@Configuration
@MapperScan(basePackages = {"com.rany.uic.dao"})
public class MyBatisConfig {

}
