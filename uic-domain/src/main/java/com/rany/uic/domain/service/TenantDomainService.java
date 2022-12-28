package com.rany.uic.domain.service;

import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.repository.AccountRepository;
import com.rany.uic.domain.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/1 22:36
 * @email 18668485565163.com
 */
@Slf4j
@Component
public class TenantDomainService {

    @Resource
    private AccountRepository accountRepository;
    @Resource
    private TenantRepository tenantRepository;
    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    public Boolean save(Tenant tenant) {
        tenantRepository.save(tenant);
        return Boolean.TRUE;
    }
}
