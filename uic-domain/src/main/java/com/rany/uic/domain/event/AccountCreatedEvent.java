package com.rany.uic.domain.event;

import com.cake.framework.common.event.DomainEvent;
import com.rany.uic.domain.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/1 22:26
 * @email 18668485565163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountCreatedEvent extends DomainEvent {

    private Account account;
    private Date eventTime;

    public AccountCreatedEvent(Account account, Date eventTime) {
        this.account = account;
        this.eventTime = eventTime;
    }
}
