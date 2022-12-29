package com.rany.uic.domain.convertor;

import com.rany.uic.dao.po.TenantPO;
import com.rany.uic.domain.aggregate.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:27
 * @email 18668485565163.com
 */
@Mapper(componentModel = "spring")
public interface TenantDataConvertor extends BaseConvertor<Tenant, TenantPO> {


    /**
     * 聚合根转PO
     *
     * @param tenant
     * @return
     */
    @Mapping(source = "id.id", target = "id")
    @Mapping(source = "isvId.id", target = "isvId")
    @Mapping(source = "tenantName.name", target = "name")
    @Mapping(source = "tenantName.shortName", target = "shortName")
    @Mapping(source = "emailAddress.email", target = "email")
    @Mapping(source = "source.source", target = "source")
    @Mapping(source = "phone.phone", target = "phone")
    @Mapping(source = "deleted", target = "deleted")
    @Override
    TenantPO sourceToTarget(Tenant tenant);
}
