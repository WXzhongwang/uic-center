package com.rany.uic.service.listener;

import com.rany.uic.domain.event.AccountCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

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


    @TransactionalEventListener
    public void handleAccountCreateEvent(AccountCreatedEvent createdEvent) {
        String name = Thread.currentThread().getName();
        String value = MDC.get("__TRACE_ID__");
        if (StringUtils.isEmpty(value)) {
            log.error("missing context");
        }
        log.info("threadName: " + name + ", event:" + createdEvent.toString());
    }
}
