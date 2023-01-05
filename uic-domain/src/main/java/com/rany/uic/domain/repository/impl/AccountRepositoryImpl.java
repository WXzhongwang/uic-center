package com.rany.uic.domain.repository.impl;

import cn.hutool.core.date.DateUtil;
import com.rany.uic.common.enums.DeleteStatusEnum;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.convertor.AccountDataConvertor;
import com.rany.uic.domain.convertor.SafeStrategyConvertor;
import com.rany.uic.domain.dao.AccountDao;
import com.rany.uic.domain.dao.mapper.AccountPOMapper;
import com.rany.uic.domain.dao.mapper.SafeStrategyPOMapper;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.po.SafeStrategyPO;
import com.rany.uic.domain.repository.AccountRepository;
import com.rany.uic.domain.value.SafeStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

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
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountPOMapper accountMapper;
    private final SafeStrategyPOMapper safeStrategyPOMapper;
    private final AccountDao accountDao;
    private final AccountDataConvertor accountDataConvertor;
    private final SafeStrategyConvertor safeStrategyConvertor;

    @Override
    public Account find(@NotNull AccountId accountId) {

        return null;
    }

    @Override
    public void remove(@NotNull Account account) {
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@NotNull Account account) {
        Long accountId = account.getId().getId();
        accountDao.save(account);
        List<SafeStrategy> safeStrategies = account.getSafeStrategies();
        if (CollectionUtils.isNotEmpty(safeStrategies)) {
            for (SafeStrategy safeStrategy : safeStrategies) {
                safeStrategy.setAccountId(accountId);
                safeStrategy.setIsDeleted(DeleteStatusEnum.NO.getValue());
                safeStrategy.setGmtCreate(DateUtil.date());
                safeStrategy.setGmtModified(DateUtil.date());
                SafeStrategyPO strategy = safeStrategyConvertor.sourceToTarget(safeStrategy);
                safeStrategyPOMapper.insertSelective(strategy);
            }
        }
    }
}
