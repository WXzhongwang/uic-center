package com.rany.uic.domain.base;

import com.rany.uic.common.util.SnowflakeIdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 21:21
 * @email 18668485565163.com
 */
@Configuration
@MapperScan("com.rany.uic.domain.dao")
public class Config {

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        Random random = new Random(10);
        int workId = random.nextInt(10);
        return new SnowflakeIdWorker(workId, 1);
    }
}
