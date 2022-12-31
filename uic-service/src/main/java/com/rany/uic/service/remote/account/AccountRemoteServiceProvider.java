package com.rany.uic.service.remote.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.rany.uic.api.command.account.*;
import com.rany.uic.api.facade.account.AccountFacade;
import com.rany.uic.common.base.Result;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.service.AccountDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/30 23:25
 * @email 18668485565163.com
 */

@Slf4j
@Service
@AllArgsConstructor
public class AccountRemoteServiceProvider implements AccountFacade {

    private final AccountDomainService accountDomainService;
    private final SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public Result<Boolean> createAccount(CreateAccountCommand createAccountCommand) {
        return null;
    }

    @Override
    public Result<Boolean> disableAccount(DisableAccountCommand disableAccountCommand) {
        return null;
    }

    @Override
    public Result<Boolean> modifyAccount(ModifyAccountCommand modifyAccountCommand) {
        return null;
    }

    @Override
    public Result<Boolean> createSafeStrategy(CreateSafeStrategyCommand createSafeStrategyCommand) {
        return null;
    }

    @Override
    public Result<Boolean> updateSafeStrategy(UpdateSafeStrategyCommand updateSafeStrategyCommand) {
        return null;
    }
}
