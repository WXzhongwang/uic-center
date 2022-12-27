package com.rany.uic.domain.repository;

import com.cake.framework.ddd.repository.Repository;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.pk.TenantId;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:19
 * @email 18668485565163.com
 */

public interface TenantRepository extends Repository<Tenant, TenantId> {
}
