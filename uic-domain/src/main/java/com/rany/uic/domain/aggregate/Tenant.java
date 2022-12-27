package com.rany.uic.domain.aggregate;

import com.cake.framework.common.base.BaseAggregateRoot;
import com.cake.framework.common.base.IAggregate;
import com.rany.uic.domain.dp.TenantName;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.service.TenantDomainService;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Account 聚合根
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:11
 * @email 18668485565163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Tenant extends BaseAggregateRoot implements IAggregate<TenantId> {

    private TenantDomainService tenantDomainService;
    private TenantId id;
    /**
     * 租户名称名称
     */
    private TenantName tenantName;

    public Tenant(TenantDomainService tenantDomainService, TenantId id, TenantName tenantName) {
        this.tenantDomainService = tenantDomainService;
        this.id = id;
        this.tenantName = tenantName;
    }

    public Boolean save() {
        return true;
    }

    public Boolean freeze() {
        return true;
    }

    public Boolean delete() {
        return true;
    }
}
