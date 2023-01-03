package com.rany.uic.domain.repository;

import com.cake.framework.ddd.repository.Repository;
import com.rany.uic.common.dto.tenant.TenantDTO;
import com.rany.uic.dao.po.TenantPO;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.pk.IsvId;
import com.rany.uic.domain.pk.TenantId;

import java.util.List;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:19
 * @email 18668485565163.com
 */

public interface TenantRepository extends Repository<Tenant, TenantId> {

    /**
     * 获取租户简称
     *
     * @param shortName
     * @return
     */
    TenantPO selectByShortName(String shortName);

    /**
     * 获取租户数量
     *
     * @param isvId
     * @return
     */
    Integer selectTenantCountByIsvId(IsvId isvId);


    /**
     * 更新租户信息
     *
     * @param tenant
     * @return
     */
    Boolean updateTenant(Tenant tenant);


    /**
     * 查询列表
     *
     * @param tenant
     * @return
     */
    List<TenantDTO> findTenants(Tenant tenant);
}
