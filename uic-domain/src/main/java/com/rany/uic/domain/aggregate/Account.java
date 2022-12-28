package com.rany.uic.domain.aggregate;

import com.cake.framework.common.base.BaseAggregateRoot;
import com.cake.framework.common.base.IAggregate;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.event.AccountCreatedEvent;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.service.AccountDomainService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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
public class Account extends BaseAggregateRoot implements IAggregate<AccountId> {

    private AccountDomainService accountDomainService;
    private AccountId id;
    /**
     * 用户名称
     */
    private AccountName accountName;

    public Account(AccountDomainService accountDomainService, AccountId id, AccountName accountName) {
        this.accountDomainService = accountDomainService;
        this.id = id;
        this.accountName = accountName;
    }

    public Boolean save() {
        this.registerEvent(new AccountCreatedEvent(this, new Date()));
        return accountDomainService.save(this);
    }

    public Boolean freeze() {
        return true;
    }

    public Boolean delete() {
        return true;
    }
}
