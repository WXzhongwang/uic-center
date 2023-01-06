package com.rany.uic.domain.dao;

import com.rany.uic.domain.po.AccountPO;
import com.rany.uic.domain.po.SafeStrategyPO;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/7 22:07
 * @email 18668485565163.com
 */
public interface SafeStrategyDao extends BaseMapper<AccountPO> {

    /**
     * 根据登录名查询登录策略信息
     *
     * @param authCode
     * @param loginStrategy
     * @return
     */
    SafeStrategyPO findAccountByAuthCode(@Param("authCode") String authCode, @Param("loginStrategy") String loginStrategy);
}
