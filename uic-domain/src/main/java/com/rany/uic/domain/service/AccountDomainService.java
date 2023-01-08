package com.rany.uic.domain.service;

import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/1 22:36
 * @email 18668485565163.com
 */
@Slf4j
@Component
public class AccountDomainService {

    @Resource
    private AccountRepository accountRepository;
    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    public Boolean save(Account account) {
        accountRepository.save(account);
        return Boolean.TRUE;
    }

    public Boolean update(Account account) {
        accountRepository.update(account);
        return Boolean.TRUE;
    }

    public Account findById(AccountId accountId) {
        return accountRepository.find(accountId);
    }

    public Account findAccountByLoginName(String loginName) {
        return accountRepository.findAccountByLoginName(loginName);
    }

    public Boolean saveSafeStrategy(Account account) {
        return accountRepository.saveSafeStrategy(account);
    }

    public Boolean updateSafeStrategy(Account account) {
        return accountRepository.updateSafeStrategy(account);
    }
}
