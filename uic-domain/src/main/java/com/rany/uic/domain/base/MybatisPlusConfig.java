package com.rany.uic.domain.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/7 22:52
 * @email 18668485565163.com
 */
@Configuration
@MapperScan("com.rany.uic.domain.dao")
public class MybatisPlusConfig {
}
