package com.rany.uic.domain.dao;

import com.rany.uic.infra.po.AccountPO;
import com.rany.uic.infra.po.SafeStrategyPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


    /**
     * 根据账号获取登录策略
     *
     * @param accountId
     * @return
     */
    List<SafeStrategyPO> selectStrategiesByAccountId(@Param("accountId") Long accountId);
}
