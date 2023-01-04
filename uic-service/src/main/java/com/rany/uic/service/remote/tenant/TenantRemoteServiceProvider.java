package com.rany.uic.service.remote.tenant;

import cn.hutool.db.PageResult;
import com.alibaba.dubbo.config.annotation.Service;
import com.rany.uic.api.command.tenant.*;
import com.rany.uic.api.facade.tenant.TenantFacade;
import com.rany.uic.api.query.tenant.TenantBasicQuery;
import com.rany.uic.api.query.tenant.TenantPageQuery;
import com.rany.uic.api.query.tenant.TenantQuery;
import com.rany.uic.common.base.Result;
import com.rany.uic.common.dto.tenant.TenantDTO;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.exception.BusinessException;
import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Isv;
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

import java.util.List;
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
    public Result<Boolean> createTenant(CreateTenantCommand createTenantCommand) {
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
        return Result.succeed();
    }

    @Override
    @TenantValidCheck(expression = "#modifyTenantCommand.tenantId")
    public Result<Boolean> modifyTenant(ModifyTenantCommand modifyTenantCommand) {
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
        return Result.succeed();
    }

    @Override
    public Result<Boolean> disableTenant(DisableTenantCommand disableTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(disableTenantCommand.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
        }
        tenant.disabled();
        tenantDomainService.update(tenant);
        return Result.succeed();
    }

    @Override
    public Result<Boolean> enableTenant(EnableTenantCommand enableTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(enableTenantCommand.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
        }
        tenant.enable();
        tenantDomainService.update(tenant);
        return Result.succeed();
    }

    @Override
    public Result<Boolean> deleteTenant(DeleteTenantCommand deleteTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(deleteTenantCommand.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        tenant.delete();
        tenantDomainService.update(tenant);
        return Result.succeed();
    }

    @Override
    public Result<TenantDTO> findTenant(TenantBasicQuery tenantBasicQuery) {
        Tenant tenant = tenantDomainService.findById(new TenantId(tenantBasicQuery.getTenantId()));
        if (Objects.isNull(tenant)) {
            throw new BusinessException(BusinessErrorMessage.TENANT_NOT_FOUND);
        }
        if (StringUtils.equals(tenant.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
            throw new BusinessException(BusinessErrorMessage.TENANT_DELETED);
        }
        TenantDTO isvDTO = tenantDataConvertor.sourceToDTO(tenant);
        return Result.succeed(isvDTO);
    }

    @Override
    public Result<List<TenantDTO>> findTenants(TenantQuery tenantQuery) {
        if (Objects.nonNull(tenantQuery.getIsvId())) {
            Isv isv = isvDomainService.findById(new IsvId(tenantQuery.getIsvId()));
            if (Objects.isNull(isv)) {
                throw new BusinessException(BusinessErrorMessage.ISV_NOT_FOUND);
            }
            if (StringUtils.equals(isv.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DELETED);
            }
            if (StringUtils.equals(isv.getStatus(), CommonStatusEnum.DISABLED.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DISABLED);
            }
        }
        Tenant tenant = new Tenant();
        tenant.setTenantName(new TenantName(tenantQuery.getName(), tenantQuery.getName()));
        return Result.succeed(tenantDomainService.selectTenants(tenant));
    }

    @Override
    public Result<PageResult<TenantDTO>> pageTenants(TenantPageQuery tenantPageQuery) {
        if (Objects.nonNull(tenantPageQuery.getIsvId())) {
            Isv isv = isvDomainService.findById(new IsvId(tenantPageQuery.getIsvId()));
            if (Objects.isNull(isv)) {
                throw new BusinessException(BusinessErrorMessage.ISV_NOT_FOUND);
            }
            if (StringUtils.equals(isv.getIsDeleted(), DeleteStatusEnum.YES.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DELETED);
            }
            if (StringUtils.equals(isv.getStatus(), CommonStatusEnum.DISABLED.getValue())) {
                throw new BusinessException(BusinessErrorMessage.ISV_DISABLED);
            }
        }
        return null;
    }
}
