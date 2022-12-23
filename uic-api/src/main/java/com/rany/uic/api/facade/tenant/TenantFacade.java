package com.rany.uic.api.facade.tenant;

import com.rany.uic.api.command.tenant.CreateTenantCommand;
import com.rany.uic.api.dto.Result;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:21
 * @email 18668485565163.com
 */
public interface TenantFacade {


    /**
     * 创建租户
     *
     * @param createTenantCommand
     * @return
     */
    Result<Boolean> createTenant(CreateTenantCommand createTenantCommand);
}
