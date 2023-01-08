package com.rany.uic.api.facade.account;

import com.cake.framework.common.response.ListResult;
import com.cake.framework.common.response.PageResult;
import com.cake.framework.common.response.PojoResult;
import com.rany.uic.api.command.account.*;
import com.rany.uic.api.query.account.AccountBasicQuery;
import com.rany.uic.api.query.account.AccountPageQuery;
import com.rany.uic.api.query.account.AccountQuery;
import com.rany.uic.common.dto.account.AccountDTO;

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
    PojoResult<Long> createAccount(CreateAccountCommand createAccountCommand);

    /**
     * 获取账号信息
     *
     * @param accountBasicQuery
     * @return
     */
    PojoResult<AccountDTO> getAccount(AccountBasicQuery accountBasicQuery);

    /**
     * 账号禁用
     *
     * @param disableAccountCommand
     * @return
     */
    PojoResult<Boolean> disableAccount(DisableAccountCommand disableAccountCommand);

    /**
     * 启用账号
     *
     * @param enableAccountCommand
     * @return
     */
    PojoResult<Boolean> enableAccount(EnableAccountCommand enableAccountCommand);

    /**
     * 删除账户
     *
     * @param deleteAccountCommand
     * @return
     */
    PojoResult<Boolean> deleteAccount(DeleteAccountCommand deleteAccountCommand);

    /**
     * 更新账号基本信息
     *
     * @param modifyAccountCommand
     * @return
     */
    PojoResult<Boolean> modifyAccount(ModifyAccountCommand modifyAccountCommand);

    /**
     * 创建登录策略
     *
     * @param createSafeStrategyCommand
     * @return
     */
    PojoResult<Boolean> createSafeStrategy(CreateSafeStrategyCommand createSafeStrategyCommand);

    /**
     * 更新登录策略
     *
     * @param updateSafeStrategyCommand
     * @return
     */
    PojoResult<Boolean> updateSafeStrategy(UpdateSafeStrategyCommand updateSafeStrategyCommand);


    /**
     * 分页查询账号
     *
     * @param accountQuery
     * @return
     */
    ListResult<AccountDTO> findAccounts(AccountQuery accountQuery);

    /**
     * 查询账号
     *
     * @param accountPageQuery
     * @return
     */
    PageResult<AccountDTO> pageAccounts(AccountPageQuery accountPageQuery);

}
