package com.rany.uic.service.remote.tenant;

import com.alibaba.dubbo.config.annotation.Service;
import com.rany.uic.api.command.tenant.CreateTenantCommand;
import com.rany.uic.api.dto.Result;
import com.rany.uic.api.facade.tenant.TenantFacade;
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
    public Result<Boolean> createTenant(CreateTenantCommand createTenantCommand) {
        Tenant tenant = new Tenant(new TenantId(snowflakeIdWorker.nextId()),
                new IsvId(createTenantCommand.getIsvId()),
                new TenantName(createTenantCommand.getName(), createTenantCommand.getShortName()),
                new EmailAddress(createTenantCommand.getEmail()),
                new TenantSource(createTenantCommand.getSource()),
                new Phone(createTenantCommand.getPhone())
        );
        tenant.setIsDeleted(DeleteStatusEnum.NO.getValue());
        tenant.save(createTenantCommand.getInitialAccount());
        tenantDomainService.save(tenant);
        return Result.succeed();
    }
}
