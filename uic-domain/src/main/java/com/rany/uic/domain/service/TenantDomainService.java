package com.rany.uic.domain.service;

import com.cake.framework.common.response.Page;
import com.rany.uic.common.dto.tenant.TenantDTO;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.exception.BusinessException;
import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.common.params.TenantPageSearchParam;
import com.rany.uic.common.params.TenantSearchParam;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Isv;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.repository.AccountRepository;
import com.rany.uic.domain.repository.IsvRepository;
import com.rany.uic.domain.repository.TenantRepository;
import com.rany.uic.infra.po.TenantPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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
    private IsvRepository isvRepository;

    @Resource
    private AccountRepository accountRepository;
    @Resource
    private TenantRepository tenantRepository;

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    public Boolean save(Tenant tenant) {
        Isv isv = isvRepository.find(tenant.getIsvId());
        if (Objects.isNull(isv) || StringUtils.equals(isv.getIsDeleted(), DeleteStatusEnum.YES.getValue())
                || StringUtils.equals(isv.getStatus(), CommonStatusEnum.DISABLED.getValue())) {
            throw new BusinessException(BusinessErrorMessage.ISV_INVALID);
        }
        TenantPO tenantPO = tenantRepository.selectByShortName(tenant.getTenantName().getShortName());
        if (Objects.nonNull(tenantPO)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_SHORT_NAME_EXISTED);
        }
        Integer tenantsCount = tenantRepository.selectTenantCountByIsvId(isv.getId());
        if (isv.getMaxTenants() <= tenantsCount) {
            throw new BusinessException(BusinessErrorMessage.TENANT_OVER_MAX_SIZE);
        }
        tenantRepository.save(tenant);
        return Boolean.TRUE;
    }

    public Tenant findById(TenantId tenantId) {
        return tenantRepository.find(tenantId);
    }

    public Boolean update(Tenant tenant) {
        return tenantRepository.updateTenant(tenant);
    }

    public List<TenantDTO> selectTenants(TenantSearchParam searchParam) {
        return tenantRepository.findTenants(searchParam);
    }

    public Page<TenantDTO> pageTenants(TenantPageSearchParam pageSearchParam) {
        return tenantRepository.pageTenants(pageSearchParam);
    }
}
