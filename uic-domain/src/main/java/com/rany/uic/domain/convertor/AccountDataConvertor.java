package com.rany.uic.domain.convertor;

import com.rany.uic.domain.po.AccountPO;
import com.rany.uic.domain.aggregate.Account;
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
public interface AccountDataConvertor extends BaseConvertor<Account, AccountPO> {


    /**
     * 聚合根转PO
     *
     * @param account
     * @return
     */
    @Mapping(source = "id.id", target = "id")
    @Mapping(source = "accountName.name", target = "accountName")
    @Mapping(source = "tenantId.id", target = "tenantId")
    @Mapping(source = "emailAddress.email", target = "email")
    @Mapping(source = "phone.phone", target = "phone")
    @Mapping(source = "headImage.img", target = "headImage")
    @Override
    AccountPO sourceToTarget(Account account);


    /**
     * 聚合根转PO
     *
     * @param accountPO
     * @return
     */
    @Mapping(target = "id.id", source = "id")
    @Mapping(target = "accountName.name", source = "accountName")
    @Mapping(target = "tenantId.id", source = "tenantId")
    @Mapping(target = "emailAddress.email", source = "email")
    @Mapping(target = "phone.phone", source = "phone")
    @Mapping(target = "headImage.img", source = "headImage")
    @Override
    Account targetToSource(AccountPO accountPO);
}
