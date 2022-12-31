package com.rany.uic.service.remote.tenant;

import com.alibaba.dubbo.config.annotation.Service;
import com.rany.uic.api.command.tenant.CreateTenantCommand;
import com.rany.uic.api.command.tenant.DisableTenantCommand;
import com.rany.uic.api.command.tenant.EnableTenantCommand;
import com.rany.uic.api.command.tenant.ModifyTenantCommand;
import com.rany.uic.api.dto.Result;
import com.rany.uic.api.facade.tenant.TenantFacade;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.dp.EmailAddress;
import com.rany.uic.domain.dp.Phone;
import com.rany.uic.domain.dp.TenantName;
import com.rany.uic.domain.dp.TenantSource;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.service.TenantDomainService;
import com.rany.uic.service.aop.annotation.IsvValidCheck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
    public Result<Boolean> modifyTenant(ModifyTenantCommand modifyTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(modifyTenantCommand.getTenantId()));
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
        tenant.setStatus(CommonStatusEnum.DISABLED.getValue());
        tenantDomainService.update(tenant);
        return Result.succeed();
    }

    @Override
    public Result<Boolean> enableTenant(EnableTenantCommand enableTenantCommand) {
        Tenant tenant = tenantDomainService.findById(new TenantId(enableTenantCommand.getTenantId()));
        tenant.setStatus(CommonStatusEnum.ENABLE.getValue());
        tenantDomainService.update(tenant);
        return Result.succeed();
    }
}
