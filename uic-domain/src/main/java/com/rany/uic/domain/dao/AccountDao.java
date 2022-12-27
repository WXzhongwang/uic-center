package com.rany.uic.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rany.uic.dao.po.AccountPO;
import com.rany.uic.domain.aggregate.Account;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/7 22:07
 * @email 18668485565163.com
 */
public interface AccountDao extends BaseMapper<AccountPO> {

    int save(Account acocount);
}
