package com.rany.uic.api.facade.account;

import com.rany.uic.api.command.account.*;
import com.rany.uic.api.dto.Result;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 20:39
 * @email 18668485565163.com
 */
public interface AccountFacade {


    /**
     * 创建租户账号
     *
     * @param createAccountCommand
     * @return
     */
    Result<Boolean> createAccount(CreateAccountCommand createAccountCommand);

    /**
     * 账号禁用
     *
     * @param disableAccountCommand
     * @return
     */
    Result<Boolean> disableAccount(DisableAccountCommand disableAccountCommand);

    /**
     * 更新账号基本信息
     *
     * @param modifyAccountCommand
     * @return
     */
    Result<Boolean> modifyAccount(ModifyAccountCommand modifyAccountCommand);

    /**
     * 创建登录策略
     *
     * @param createSafeStrategyCommand
     * @return
     */
    Result<Boolean> createSafeStrategy(CreateSafeStrategyCommand createSafeStrategyCommand);

    /**
     * 更新登录策略
     *
     * @param updateSafeStrategyCommand
     * @return
     */
    Result<Boolean> updateSafeStrategy(UpdateSafeStrategyCommand updateSafeStrategyCommand);


}
