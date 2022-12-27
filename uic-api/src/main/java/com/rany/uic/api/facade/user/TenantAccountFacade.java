package com.rany.uic.api.facade.user;

import com.rany.uic.api.command.account.CreateTenantAccountCommand;
import com.rany.uic.api.dto.Result;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 20:39
 * @email 18668485565163.com
 */
public interface TenantAccountFacade {


    /**
     * 创建租户账号
     *
     * @param createTenantAccountCommand
     * @return
     */
    Result<Boolean> createTenantAccount(CreateTenantAccountCommand createTenantAccountCommand);
}
