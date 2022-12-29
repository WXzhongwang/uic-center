package com.rany.uic.domain.repository.impl;

import com.rany.uic.dao.mapper.TenantPOMapper;
import com.rany.uic.dao.po.TenantPO;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.convertor.TenantDataConvertor;
import com.rany.uic.domain.dao.TenantDao;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.repository.TenantRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:18
 * @email 18668485565163.com
 */
@AllArgsConstructor
@Slf4j
@Service
public class TenantRepositoryImpl implements TenantRepository {

    private final TenantPOMapper tenantPOMapper;
    private final TenantDao tenantDao;
    private final TenantDataConvertor tenantDataConvertor;

    @Override
    public Tenant find(@NotNull TenantId accountId) {

        return null;
    }

    @Override
    public void remove(@NotNull Tenant tenant) {
    }

    @SneakyThrows
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@NotNull Tenant tenant) {
        tenantDao.save(tenant);
    }

    @Override
    public TenantPO selectByShortName(String shortName) {
        return tenantDao.selectByShortName(shortName);
    }

    @Override
    public Integer selectTenantCountByIsvId(IsvId isvId) {
        return tenantDao.selectTenantCountByIsvId(isvId.getId());
    }
}
