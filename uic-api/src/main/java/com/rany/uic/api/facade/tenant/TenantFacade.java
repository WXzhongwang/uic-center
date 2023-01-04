package com.rany.uic.api.facade.tenant;

import cn.hutool.db.PageResult;
import com.rany.uic.api.command.tenant.*;
import com.rany.uic.api.query.tenant.TenantBasicQuery;
import com.rany.uic.api.query.tenant.TenantPageQuery;
import com.rany.uic.api.query.tenant.TenantQuery;
import com.rany.uic.common.base.Result;
import com.rany.uic.common.dto.tenant.TenantDTO;

import java.util.List;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
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
    Result<Boolean> createTenant(CreateTenantCommand createTenantCommand);

    /**
     * 更新租户
     *
     * @param modifyTenantCommand
     * @return
     */
    Result<Boolean> modifyTenant(ModifyTenantCommand modifyTenantCommand);

    /**
     * 租户禁用
     *
     * @param disableTenantCommand
     * @return
     */
    Result<Boolean> disableTenant(DisableTenantCommand disableTenantCommand);

    /**
     * 启用租户
     *
     * @param enableTenantCommand
     * @return
     */
    Result<Boolean> enableTenant(EnableTenantCommand enableTenantCommand);

    /**
     * 启用租户
     *
     * @param deleteTenantCommand
     * @return
     */
    Result<Boolean> deleteTenant(DeleteTenantCommand deleteTenantCommand);


    /**
     * 查询单个租户信息
     *
     * @param tenantBasicQuery
     * @return
     */
    Result<TenantDTO> findTenant(TenantBasicQuery tenantBasicQuery);


    /**
     * 查询指定isv全部租户信息
     *
     * @param tenantQuery
     * @return
     */
    Result<List<TenantDTO>> findTenants(TenantQuery tenantQuery);

    /**
     * 分页查询租户信息
     *
     * @param tenantPageQuery
     * @return
     */
    Result<PageResult<TenantDTO>> pageTenants(TenantPageQuery tenantPageQuery);
}
