package com.rany.uic.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rany.uic.dao.po.TenantPO;
import com.rany.uic.domain.aggregate.Tenant;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/7 22:07
 * @email 18668485565163.com
 */
public interface TenantDao extends BaseMapper<TenantPO> {

    /**
     * 保存
     *
     * @param tenant
     * @return
     */
    int save(Tenant tenant);

    /**
     * 根据简称查询租户
     *
     * @param shortName
     * @return
     */
    TenantPO selectByShortName(@Param("name") String shortName);


    /**
     * isv下租户数量
     *
     * @param isvId
     * @return
     */
    Integer selectTenantCountByIsvId(@Param("isvId") Long isvId);
}
