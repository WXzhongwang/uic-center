package com.rany.uic.service.remote.tenant;

import cn.hutool.core.util.BooleanUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.cake.framework.common.response.ListResult;
import com.cake.framework.common.response.Page;
import com.cake.framework.common.response.PageResult;
import com.cake.framework.common.response.PojoResult;
import com.rany.uic.api.command.tenant.*;
import com.rany.uic.api.facade.tenant.TenantFacade;
import com.rany.uic.api.query.tenant.TenantBasicQuery;
import com.rany.uic.api.query.tenant.TenantPageQuery;
import com.rany.uic.api.query.tenant.TenantQuery;
import com.rany.uic.common.dto.tenant.TenantDTO;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.exception.BusinessException;
import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.common.params.TenantPageSearchParam;
import com.rany.uic.common.params.TenantSearchParam;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.convertor.TenantDataConvertor;
import com.rany.uic.domain.dp.EmailAddress;
import com.rany.uic.domain.dp.Phone;
import com.rany.uic.domain.dp.TenantName;
import com.rany.uic.domain.dp.TenantSource;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.service.IsvDomainService;
import com.rany.uic.domain.service.TenantDomainService;
import com.rany.uic.service.aop.annotation.IsvValidCheck;
import com.rany.uic.service.aop.annotation.TenantValidCheck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/29 21:10
 * @email 18668485565163.com
 */
@Slf4j
@Service
@AllArgsConstructor
public class TenantRemoteServiceProvider implements TenantFacade {

    private final TenantDomainService tenantDomainService;
    private final IsvDomainService isvDomainService;
    private final TenantDataConvertor tenantDataConvertor;
    private final SnowflakeIdWorker snowflakeIdWorker;

    @Override
    @IsvValidCheck(expression = "#createTenantCommand.isvId")
    public PojoResult<Boolean> createTenant(CreateTenantCommand createTenantCommand) {
        Tenant tenant = new Tenant(new TenantId(snowflakeIdWorker.nextId()),
                new IsvId(createTenantCommand.getIsvId()),
                new TenantName(createTenantCommand.getName(), createTenantCommand.getShortName()),
                new EmailAddress(createTenantCommand.getEmail()),
                new TenantSource(createTenantCommand.getSource()),
                new Phone(createTenantCommand.getPhone()),
                createTenantCommand.getAddress(),
                CommonStatusEnum.ENABLE.getValue()
        );
        tenant.setIsDeleted(DeleteStatusEnum.NO.getValue());
        tenant.save(createTenantCommand.getInitialAccount());
        tenantDomainService.save(tenant);
        return PojoResult.succeed();
    }

    @Override
    @TenantValidCheck(expression = "#modifyTenantCommand.tenantId")
    public PojoResult<Boolean> modifyTenant(ModifyTenantCommand modifyTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(modifyTenantCommand.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
        }
        tenant.setTenantName(new TenantName(modifyTenantCommand.getName(), tenant.getTenantName().getShortName()));
        tenant.setEmailAddress(new EmailAddress(modifyTenantCommand.getEmail()));
        tenant.setPhone(new Phone(modifyTenantCommand.getPhone()));
        tenant.setAddress(modifyTenantCommand.getAddress());
        tenantDomainService.update(tenant);
        return PojoResult.succeed();
    }

    @Override
    public PojoResult<Boolean> disableTenant(DisableTenantCommand disableTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(disableTenantCommand.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
        }
        tenant.disabled();
        tenantDomainService.update(tenant);
        return PojoResult.succeed();
    }

    @Override
    public PojoResult<Boolean> enableTenant(EnableTenantCommand enableTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(enableTenantCommand.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
        }
        tenant.enable();
        tenantDomainService.update(tenant);
        return PojoResult.succeed();
    }

    @Override
    public PojoResult<Boolean> deleteTenant(DeleteTenantCommand deleteTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(deleteTenantCommand.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        tenant.delete();
        tenantDomainService.update(tenant);
        return PojoResult.succeed();
    }

    @Override
    public PojoResult<TenantDTO> getTenant(TenantBasicQuery tenantBasicQuery) {
        Tenant tenant = tenantDomainService.findById(new TenantId(tenantBasicQuery.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
        }
        TenantDTO isvDTO = tenantDataConvertor.sourceToDTO(tenant);
        return PojoResult.succeed(isvDTO);
    }

    @Override
    @IsvValidCheck(expression = "tenantQuery.isvId")
    public ListResult<TenantDTO> findTenants(TenantQuery tenantQuery) {
        TenantSearchParam searchParam = new TenantSearchParam();
        if (Objects.nonNull(tenantQuery.getIsvId())) {
            searchParam.setIsvId(tenantQuery.getIsvId());
        }
        if (StringUtils.isNotEmpty(tenantQuery.getName())) {
            searchParam.setName(searchParam.getName());
        }
        if (BooleanUtil.isTrue(tenantQuery.getExcludeDeleted())) {
            searchParam.setIsDeleted(DeleteStatusEnum.NO.getValue());
        }
        if (BooleanUtil.isTrue(tenantQuery.getExcludeDisabled())) {
            searchParam.setStatus(CommonStatusEnum.ENABLE.getValue());
        }
        return ListResult.succeed(tenantDomainService.selectTenants(searchParam));
    }

    @Override
    @IsvValidCheck(expression = "tenantPageQuery.isvId")
    public PageResult<TenantDTO> pageTenants(TenantPageQuery tenantPageQuery) {
        TenantPageSearchParam pageSearchParam = new TenantPageSearchParam();
        pageSearchParam.setPageNo(tenantPageQuery.getPageNo());
        pageSearchParam.setPageSize(tenantPageQuery.getPageSize());
        if (Objects.nonNull(tenantPageQuery.getIsvId())) {
            pageSearchParam.setIsvId(tenantPageQuery.getIsvId());
        }
        if (StringUtils.isNotEmpty(tenantPageQuery.getName())) {
            pageSearchParam.setName(tenantPageQuery.getName());
        }
        if (BooleanUtil.isTrue(tenantPageQuery.getExcludeDeleted())) {
            pageSearchParam.setIsDeleted(DeleteStatusEnum.NO.getValue());
        }
        if (BooleanUtil.isTrue(tenantPageQuery.getExcludeDisabled())) {
            pageSearchParam.setStatus(CommonStatusEnum.ENABLE.getValue());
        }
        Page<TenantDTO> page = tenantDomainService.pageTenants(pageSearchParam);
        return PageResult.succeed(page);
    }
}
