package com.rany.uic.domain.repository.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rany.uic.common.dto.tenant.TenantDTO;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.dao.mapper.TenantPOMapper;
import com.rany.uic.dao.po.TenantPO;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.convertor.TenantDataConvertor;
import com.rany.uic.domain.dao.TenantDao;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.repository.TenantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

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
        TenantPO tenantPO = tenantPOMapper.selectByPrimaryKey(accountId.getId());
        return tenantDataConvertor.targetToSource(tenantPO);
    }

    @Override
    public void remove(@NotNull Tenant tenant) {
        TenantId tenantId = tenant.getId();
        TenantPO tenantPO = tenantPOMapper.selectByPrimaryKey(tenantId.getId());
        tenantPO.setIsDeleted(DeleteStatusEnum.YES.getValue());
        tenantPO.setGmtModified(DateUtil.date());
        tenantPOMapper.updateByPrimaryKeySelective(tenantPO);
    }

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

    @Override
    public Boolean updateTenant(Tenant tenant) {
        TenantPO tenantPO = tenantDataConvertor.sourceToTarget(tenant);
        tenantPO.setGmtModified(DateUtil.date());
        tenantPOMapper.updateByPrimaryKeySelective(tenantPO);
        return Boolean.TRUE;
    }

    @Override
    public List<TenantDTO> findTenants(Tenant tenant) {
        LambdaQueryWrapper<TenantPO> queryWrapper = new LambdaQueryWrapper<TenantPO>().orderByDesc(TenantPO::getGmtModified,
                TenantPO::getGmtCreate);
        if (tenant.getIsvId() != null) {
            queryWrapper.eq(TenantPO::getIsvId, tenant.getIsvId());
        }
        if (tenant.getTenantName() != null) {
            queryWrapper.like(TenantPO::getName, tenant.getTenantName().getName());
        }
        if (StringUtils.isNotEmpty(tenant.getIsDeleted())) {
            queryWrapper.eq(TenantPO::getIsDeleted, tenant.getIsDeleted());
        }
        if (StringUtils.isNotEmpty(tenant.getStatus())) {
            queryWrapper.eq(TenantPO::getStatus, tenant.getStatus());
        }
        if (tenant.getEmailAddress() != null && StringUtils.isNotEmpty(tenant.getEmailAddress().getEmail())) {
            queryWrapper.eq(TenantPO::getEmail, tenant.getEmailAddress().getEmail());
        }
        if (tenant.getPhone() != null && StringUtils.isNotEmpty(tenant.getPhone().getPhone())) {
            queryWrapper.eq(TenantPO::getPhone, tenant.getPhone().getPhone());
        }
        if (tenant.getSource() != null && StringUtils.isNotEmpty(tenant.getSource().getSource())) {
            queryWrapper.eq(TenantPO::getSource, tenant.getSource().getSource());
        }
        List<TenantPO> tenantPOS = tenantDao.selectList(queryWrapper);
        return tenantDataConvertor.targetToDTO(tenantPOS);
    }
}
