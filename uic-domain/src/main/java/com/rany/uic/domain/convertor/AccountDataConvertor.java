package com.rany.uic.domain.convertor;

import com.rany.uic.dao.po.AccountPO;
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
public interface AccountDataConvertor {


    /**
     * 聚合根转PO
     *
     * @param account
     * @return
     */
    @Mapping(source = "id.id", target = "id")
    @Mapping(source = "accountName.name", target = "accountName")
    AccountPO toAccountPO(Account account);
}
