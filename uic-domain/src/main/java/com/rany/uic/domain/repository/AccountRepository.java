package com.rany.uic.domain.repository;

import com.cake.framework.ddd.repository.Repository;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.pk.AccountId;

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
     * @param account
     * @return
     */
    int update(Account account);

}
