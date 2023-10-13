package com.rany.uic.infra.convertor;

import com.rany.uic.common.dto.isv.IsvDTO;
import com.rany.uic.domain.aggregate.Isv;
import com.rany.uic.infra.po.IsvPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:27
 * @email 18668485565163.com
 */
@Mapper(componentModel = "spring")
public interface IsvDataConvertor extends BaseConvertor<Isv, IsvPO> {


    /**
     * 聚合根转PO
     *
     * @param isv
     * @return
     */
    @Mapping(source = "id.id", target = "id")
    @Mapping(source = "name.name", target = "name")
    @Mapping(source = "name.shortName", target = "shortName")
    @Mapping(source = "emailAddress.email", target = "email")
    @Mapping(source = "phone.phone", target = "phone")
    @Override
    IsvPO sourceToTarget(Isv isv);

    /**
     * PO转聚合根
     *
     * @param isvPO
     * @return
     */

    @Override
    @Mappings({
            @Mapping(source = "id", target = "id.id"),
            @Mapping(source = "name", target = "name.name"),
            @Mapping(source = "shortName", target = "name.shortName"),
            @Mapping(source = "email", target = "emailAddress.email"),
            @Mapping(source = "phone", target = "phone.phone")
    })
    Isv targetToSource(IsvPO isvPO);


    /**
     * 聚合根转DTO
     *
     * @param isv
     * @return
     */
    @Mappings({
            @Mapping(target = "id", source = "id.id"),
            @Mapping(target = "name", source = "name.name"),
            @Mapping(target = "shortName", source = "name.shortName"),
            @Mapping(target = "email", source = "emailAddress.email"),
            @Mapping(target = "phone", source = "phone.phone")
    })
    IsvDTO sourceToDTO(Isv isv);
}
