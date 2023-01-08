package com.rany.uic.domain.repository;

import com.cake.framework.common.response.Page;
import com.cake.framework.ddd.repository.Repository;
import com.rany.uic.common.dto.account.AccountDTO;
import com.rany.uic.common.params.AccountPageSearchParam;
import com.rany.uic.common.params.AccountSearchParam;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.pk.AccountId;

import java.util.List;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:19
 * @email 18668485565163.com
 */

public interface AccountRepository extends Repository<Account, AccountId> {

    /**
     * 根据登录账号查找用户
     *
     * @param loginName
     * @return
     */
    Account findAccountByLoginName(String loginName);

    /**
     * 账号更新
     *
     * @param account
     * @return
     */
    int update(Account account);


    /**
     * 保存登录方式
     *
     * @param account
     * @return
     */
    Boolean saveSafeStrategy(Account account);

    /**
     * 保存登录方式
     *
     * @param account
     * @return
     */
    Boolean updateSafeStrategy(Account account);


    /**
     * 查询列表
     *
     * @param accountSearchParam
     * @return
     */
    List<AccountDTO> findAccounts(AccountSearchParam accountSearchParam);


    /**
     * 分页查询账号
     *
     * @param accountPageSearchParam
     * @return
     */
    Page<AccountDTO> pageAccounts(AccountPageSearchParam accountPageSearchParam);

}
