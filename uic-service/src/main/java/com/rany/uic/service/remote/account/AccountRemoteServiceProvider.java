package com.rany.uic.service.remote.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.cake.framework.common.response.PojoResult;
import com.rany.uic.api.command.account.*;
import com.rany.uic.api.query.account.AccountBasicQuery;
import com.rany.uic.common.dto.account.AccountDTO;
import com.rany.uic.common.enums.AccountTypeEnum;
import com.rany.uic.common.enums.LoginSafeStrategyEnum;
import com.rany.uic.api.facade.account.AccountFacade;
import com.rany.uic.common.exception.BusinessException;
import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.common.exception.enums.CommonReturnCode;
import com.rany.uic.common.util.AccountUtil;
import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.aggregate.Tenant;
import com.rany.uic.domain.convertor.AccountDataConvertor;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.dp.EmailAddress;
import com.rany.uic.domain.dp.HeadImage;
import com.rany.uic.domain.dp.Phone;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.pk.TenantId;
import com.rany.uic.domain.service.AccountDomainService;
import com.rany.uic.domain.service.TenantDomainService;
import com.rany.uic.domain.value.SafeStrategy;
import com.rany.uic.service.aop.annotation.TenantValidCheck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/30 23:25
 * @email 18668485565163.com
 */

@Slf4j
@Service
@AllArgsConstructor
public class AccountRemoteServiceProvider implements AccountFacade {

    private final AccountDomainService accountDomainService;
    private final TenantDomainService tenantDomainService;
    private final AccountDataConvertor accountDataConvertor;
    private final SnowflakeIdWorker snowflakeIdWorker;

    @Override
    @TenantValidCheck(expression = "#createAccountCommand.tenantId")
    public PojoResult<Long> createAccount(CreateAccountCommand createAccountCommand) {
        List<SafeStrategy> strategyList = new ArrayList<>();
        Account account = new Account(new AccountId(snowflakeIdWorker.nextId()),
                new TenantId(createAccountCommand.getTenantId()),
                new AccountName(createAccountCommand.getAccountName()),
                strategyList);
        if (StringUtils.isNotEmpty(createAccountCommand.getEmail())) {
            account.setEmailAddress(new EmailAddress(createAccountCommand.getEmail()));
        }
        if (StringUtils.isNotEmpty(createAccountCommand.getPhone())) {
            account.setPhone(new Phone(createAccountCommand.getPhone()));
        }
        if (StringUtils.isNotEmpty(createAccountCommand.getHeadImage())) {
            account.setHeadImage(new HeadImage(createAccountCommand.getHeadImage()));
        }
        account.setAccountType(AccountTypeEnum.BASIC.name());
        if (StringUtils.isNotEmpty(createAccountCommand.getAccountType())) {
            if (!EnumUtils.isValidEnum(AccountTypeEnum.class, createAccountCommand.getAccountType())) {
                throw new BusinessException(CommonReturnCode.PARAMETER_ILLEGAL);
            }
            AccountTypeEnum accountTypeEnum = EnumUtils.getEnum(AccountTypeEnum.class, createAccountCommand.getAccountType());
            account.setAccountType(accountTypeEnum.name());
        }
        if (StringUtils.isNotEmpty(createAccountCommand.getLoginName()) && StringUtils.isNotEmpty(createAccountCommand.getLoginPwd())) {
            Tenant tenant = tenantDomainService.findById(account.getTenantId());
            String loginName = AccountUtil.buildAccountLoginName(createAccountCommand.getLoginName(), tenant.getTenantName().getShortName());
            Account hasAccount = accountDomainService.findAccountByLoginName(loginName);
            if (Objects.nonNull(hasAccount)) {
                throw new BusinessException(BusinessErrorMessage.ACCOUNT_NAME_DUPLICATED);
            }
            SafeStrategy safeStrategy = new SafeStrategy(account.getId().getId(),
                    LoginSafeStrategyEnum.BASIC_AUTH.name(),
                    AccountUtil.buildAccountLoginName(createAccountCommand.getLoginName(), tenant.getTenantName().getShortName()),
                    AccountUtil.md5(createAccountCommand.getLoginPwd()));
            strategyList.add(safeStrategy);
        }
        account.setIsAdmin(BooleanUtils.isTrue(createAccountCommand.getIsAdmin()));
        account.save();
        accountDomainService.save(account);
        return PojoResult.succeed(account.getId().getId());
    }

    @Override
    @TenantValidCheck(expression = "#accountBasicQuery.tenantId")
    public PojoResult<AccountDTO> getAccount(AccountBasicQuery accountBasicQuery) {
        Account account = accountDomainService.findById(new AccountId(accountBasicQuery.getAccountId()));
        if (Objects.isNull(account)) {
            throw new BusinessException(BusinessErrorMessage.ACCOUNT_NOT_FOUND);
        }
        AccountDTO accountDTO = accountDataConvertor.sourceToDTO(account);
        return PojoResult.succeed(accountDTO);
    }

    @Override
    @TenantValidCheck(expression = "#disableAccountCommand.tenantId")
    public PojoResult<Boolean> disableAccount(DisableAccountCommand disableAccountCommand) {
        Account account = accountDomainService.findById(new AccountId(disableAccountCommand.getAccountId()));
        if (Objects.isNull(account)) {
            throw new BusinessException(BusinessErrorMessage.ACCOUNT_NOT_FOUND);
        }
        account.disable();
        accountDomainService.update(account);
        return PojoResult.succeed(Boolean.TRUE);
    }

    @Override
    @TenantValidCheck(expression = "#enableAccountCommand.tenantId")
    public PojoResult<Boolean> enableAccount(EnableAccountCommand enableAccountCommand) {
        Account account = accountDomainService.findById(new AccountId(enableAccountCommand.getAccountId()));
        if (Objects.isNull(account)) {
            throw new BusinessException(BusinessErrorMessage.ACCOUNT_NOT_FOUND);
        }
        account.enable();
        accountDomainService.update(account);
        return PojoResult.succeed(Boolean.TRUE);
    }

    @Override
    @TenantValidCheck(expression = "#deleteAccountCommand.tenantId")
    public PojoResult<Boolean> deleteAccount(DeleteAccountCommand deleteAccountCommand) {
        Account account = accountDomainService.findById(new AccountId(deleteAccountCommand.getAccountId()));
        if (Objects.isNull(account)) {
            throw new BusinessException(BusinessErrorMessage.ACCOUNT_NOT_FOUND);
        }
        account.delete();
        accountDomainService.update(account);
        return PojoResult.succeed(Boolean.TRUE);
    }

    @Override
    @TenantValidCheck(expression = "#disableAccountCommand.tenantId")
    public PojoResult<Boolean> modifyAccount(ModifyAccountCommand modifyAccountCommand) {
        return null;
    }

    @Override
    public PojoResult<Boolean> createSafeStrategy(CreateSafeStrategyCommand createSafeStrategyCommand) {
        return null;
    }

    @Override
    public PojoResult<Boolean> updateSafeStrategy(UpdateSafeStrategyCommand updateSafeStrategyCommand) {
        return null;
    }
}
