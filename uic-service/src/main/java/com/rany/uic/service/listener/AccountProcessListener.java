package com.rany.uic.service.listener;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.rany.uic.common.enums.AccountTypeEnum;
import com.rany.uic.common.enums.CommonStatusEnum;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.common.enums.LoginSafeStrategyEnum;
import com.rany.uic.common.util.AccountUtil;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.dp.TenantName;
import com.rany.uic.domain.entity.SafeStrategy;
import com.rany.uic.domain.event.AccountCreatedEvent;
import com.rany.uic.domain.event.CreateTenantAdminAccountEvent;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.pk.TenantId;
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
    @Resource
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
        Long tenantId = tenant.getId().getId();
        SafeStrategy safeStrategy = new SafeStrategy();
        safeStrategy.setLoginStrategy(LoginSafeStrategyEnum.BASIC_AUTH.name());
        safeStrategy.setAuthCode(AccountUtil.buildDefaultAccountLoginName(tenantName.getShortName()));
        String pwd = AccountUtil.buildRandomAccountLoginPwd();
        safeStrategy.setAuthValue(AccountUtil.md5(pwd));
        Account account = new Account(new AccountId(snowflakeIdWorker.nextId()),
                new TenantId(tenantId),
                new AccountName(AccountUtil.buildDefaultAccountChineseName(tenantName.getShortName())),
                Lists.newArrayList(safeStrategy));
        account.setPhone(tenant.getPhone());
        account.setEmailAddress(tenant.getEmailAddress());
        account.setIsAdmin(true);
        account.setStatus(CommonStatusEnum.ENABLE.getValue());
        account.setIsDeleted(DeleteStatusEnum.NO.getValue());
        account.setAccountType(AccountTypeEnum.BASIC.name());
        account.setGmtCreate(DateUtil.date());
        account.setGmtModified(DateUtil.date());
        accountDomainService.save(account);
    }
}
