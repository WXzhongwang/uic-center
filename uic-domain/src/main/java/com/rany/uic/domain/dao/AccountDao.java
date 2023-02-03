package com.rany.uic.domain.dao;

import com.rany.uic.common.params.AccountPageSearchParam;
import com.rany.uic.common.params.AccountSearchParam;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.infra.po.AccountPO;

import java.util.List;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/7 22:07
 * @email 18668485565163.com
 */
public interface AccountDao extends BaseMapper<AccountPO> {

    /**
     * 保存
     *
     * @param acocount
     * @return
     */
    int save(Account acocount);

    /**
     * 更新
     *
     * @param account
     * @return
     */
    int update(Account account);


    /**
     * 查询列表
     *
     * @param tenant
     * @return
     */
    List<AccountPO> selectList(AccountSearchParam tenant);

    /**
     * 分页查询
     *
     * @param searchParam
     * @return
     */
    List<AccountPO> selectPage(AccountPageSearchParam searchParam);
}
