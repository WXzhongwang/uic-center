package com.rany.uic.domain.repository.impl;

import com.rany.uic.dao.mapper.TenantPOMapper;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.convertor.AccountDataConvertor;
import com.rany.uic.domain.dao.AccountDao;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:18
 * @email 18668485565163.com
 */
@AllArgsConstructor
@Slf4j
@Service
public class TenantRepositoryImpl implements AccountRepository {

    private final TenantPOMapper tenantPOMapper;
    private final AccountDao accountDao;
    private final AccountDataConvertor accountDataConvertor;

    @Override
    public Account find(@NotNull AccountId accountId) {

        return null;
    }

    @Override
    public void remove(@NotNull Account account) {
    }

    @SneakyThrows
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@NotNull Account account) {
        accountDao.save(account);
    }
}
