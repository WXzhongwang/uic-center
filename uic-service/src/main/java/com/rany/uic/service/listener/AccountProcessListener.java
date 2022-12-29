package com.rany.uic.service.listener;

import com.rany.uic.common.Constants;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.dp.TenantName;
import com.rany.uic.domain.event.AccountCreatedEvent;
import com.rany.uic.domain.event.CreateTenantAdminAccountEvent;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.service.AccountDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/1 22:32
 * @email 18668485565163.com
 */
@Slf4j
@Component
public class AccountProcessListener {

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;
    private AccountDomainService accountDomainService;


    @TransactionalEventListener
    public void handleAccountCreateEvent(AccountCreatedEvent createdEvent) {
        String name = Thread.currentThread().getName();
        String value = MDC.get("__TRACE_ID__");
        if (StringUtils.isEmpty(value)) {
            log.error("missing context");
        }
        log.info("threadName: " + name + ", event:" + createdEvent.toString());
    }


    /**
     * 创建租户首个管理员账号
     *
     * @param event
     */
    @TransactionalEventListener
    public void handleCreateTenantAdminAccountEvent(CreateTenantAdminAccountEvent event) {
        Tenant tenant = event.getTenant();
        TenantName tenantName = tenant.getTenantName();
        Account account = new Account(new AccountId(snowflakeIdWorker.nextId()),
                new AccountName(String.format(Constants.INITIAL_TENANT_ADMIN_NAME, tenantName.getShortName())));
    }
}
