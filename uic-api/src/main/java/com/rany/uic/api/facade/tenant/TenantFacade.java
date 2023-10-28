package com.rany.uic.api.facade.tenant;

import com.cake.framework.common.response.ListResult;
import com.cake.framework.common.response.PageResult;
import com.cake.framework.common.response.PojoResult;
import com.rany.uic.api.command.tenant.*;
import com.rany.uic.api.query.tenant.TenantBasicQuery;
import com.rany.uic.api.query.tenant.TenantPageQuery;
import com.rany.uic.api.query.tenant.TenantQuery;
import com.rany.uic.common.dto.tenant.TenantDTO;

/**
 * 租户管理
 *
 * @author zhongshengwang
 * @description 租户管理
 * @date 2022/11/15 22:21
 * @email 18668485565163.com
 */
public interface TenantFacade {


    /**
     * 创建租户
     *
     * @param createTenantCommand
     * @return
     */
    PojoResult<Boolean> createTenant(CreateTenantCommand createTenantCommand);

    /**
     * 更新租户
     *
     * @param modifyTenantCommand
     * @return
     */
    PojoResult<Boolean> modifyTenant(ModifyTenantCommand modifyTenantCommand);

    /**
     * 租户禁用
     *
     * @param disableTenantCommand
     * @return
     */
    PojoResult<Boolean> disableTenant(DisableTenantCommand disableTenantCommand);

    /**
     * 启用租户
     *
     * @param enableTenantCommand
     * @return
     */
    PojoResult<Boolean> enableTenant(EnableTenantCommand enableTenantCommand);

    /**
     * 启用租户
     *
     * @param deleteTenantCommand
     * @return
     */
    PojoResult<Boolean> deleteTenant(DeleteTenantCommand deleteTenantCommand);


    /**
     * 查询单个租户信息
     *
     * @param tenantBasicQuery
     * @return
     */
    PojoResult<TenantDTO> getTenant(TenantBasicQuery tenantBasicQuery);


    /**
     * 查询指定isv全部租户信息
     *
     * @param tenantQuery
     * @return
     */
    ListResult<TenantDTO> findTenants(TenantQuery tenantQuery);

    /**
     * 分页查询租户信息
     *
     * @param tenantPageQuery
     * @return
     */
    PageResult<TenantDTO> pageTenants(TenantPageQuery tenantPageQuery);
}
