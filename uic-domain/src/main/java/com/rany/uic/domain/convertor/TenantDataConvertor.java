package com.rany.uic.domain.convertor;

import com.rany.uic.common.dto.tenant.TenantDTO;
import com.rany.uic.dao.po.TenantPO;
import com.rany.uic.domain.aggregate.Tenant;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

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
    @Override
    TenantPO sourceToTarget(Tenant tenant);


    /**
     * 聚合根转PO
     *
     * @param tenantPO
     * @return
     */
    @Mapping(target = "id.id", source = "id")
    @Mapping(target = "isvId.id", source = "isvId")
    @Mapping(target = "tenantName.name", source = "name")
    @Mapping(target = "tenantName.shortName", source = "shortName")
    @Mapping(target = "emailAddress.email", source = "email")
    @Mapping(target = "source.source", source = "source")
    @Mapping(target = "phone.phone", source = "phone")
    @Override
    Tenant targetToSource(TenantPO tenantPO);


    /**
     * 聚合根转DTO
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
    TenantDTO sourceToDTO(Tenant tenant);


    /**
     * 多对象聚合根转DTO
     *
     * @param sources
     * @return
     */
    @InheritConfiguration(name = "sourceToDTO")
    List<TenantDTO> sourceToDTO(List<Tenant> sources);
}
