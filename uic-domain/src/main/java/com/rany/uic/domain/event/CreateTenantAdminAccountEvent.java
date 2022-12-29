package com.rany.uic.domain.event;

import com.cake.framework.common.event.DomainEvent;
import com.rany.uic.domain.aggregate.Tenant;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 初始化创建租户首个账号
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/29 21:40
 * @email 18668485565163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CreateTenantAdminAccountEvent extends DomainEvent {

    private Tenant tenant;

    private Date eventTime;

    public CreateTenantAdminAccountEvent(Tenant tenant, Date eventTime) {
        this.tenant = tenant;
        this.eventTime = eventTime;
    }
}
