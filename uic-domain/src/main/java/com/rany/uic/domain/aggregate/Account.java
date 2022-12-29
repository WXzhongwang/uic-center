package com.rany.uic.domain.aggregate;

import com.cake.framework.common.base.BaseAggregateRoot;
import com.cake.framework.common.base.IAggregate;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.event.AccountCreatedEvent;
import com.rany.uic.domain.pk.AccountId;
import lombok.*;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Account extends BaseAggregateRoot implements IAggregate<AccountId> {
    private AccountId id;
    /**
     * 用户名称
     */
    private AccountName accountName;

    public Boolean save() {
        this.registerEvent(new AccountCreatedEvent(this, new Date()));
        return Boolean.TRUE;
    }
}
