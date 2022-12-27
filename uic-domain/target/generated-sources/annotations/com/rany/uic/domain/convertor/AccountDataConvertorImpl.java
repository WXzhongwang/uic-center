package com.rany.uic.domain.convertor;

import com.rany.uic.dao.po.AccountPO;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.pk.AccountId;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-26T20:39:27+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
@Component
public class AccountDataConvertorImpl implements AccountDataConvertor {

    @Override
    public AccountPO toAccountPO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountPO accountPO = new AccountPO();

        accountPO.setAccountName( accountAccountNameName( account ) );
        accountPO.setId( accountIdId( account ) );
        accountPO.setGmtCreate( account.getGmtCreate() );
        accountPO.setGmtModified( account.getGmtModified() );

        return accountPO;
    }

    private String accountAccountNameName(Account account) {
        if ( account == null ) {
            return null;
        }
        AccountName accountName = account.getAccountName();
        if ( accountName == null ) {
            return null;
        }
        String name = accountName.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long accountIdId(Account account) {
        if ( account == null ) {
            return null;
        }
        AccountId id = account.getId();
        if ( id == null ) {
            return null;
        }
        Long id1 = id.getId();
        if ( id1 == null ) {
            return null;
        }
        return id1;
    }
}
