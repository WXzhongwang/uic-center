package com.rany.uic.api.facade.account;

import com.cake.framework.common.response.PojoResult;
import com.rany.uic.BaseTests;
import com.rany.uic.api.command.account.*;
import com.rany.uic.api.query.account.AccountBasicQuery;
import com.rany.uic.common.dto.account.AccountDTO;
import com.rany.uic.common.enums.AccountTypeEnum;
import com.rany.uic.common.enums.LoginSafeStrategyEnum;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/1/6 22:41
 * @email 18668485565163.com
 */
public class AccountFacadeTest extends BaseTests {


    @Resource
    private AccountFacade accountFacade;
    private static final Long TENANT_ID =  771342305205563392L;
    private static final Long ACCOUNT_ID =  771358516215689216L;

    @Test
    public void createAccount() {
        CreateAccountCommand createAccountCommand = new CreateAccountCommand();
        createAccountCommand.setTenantId(TENANT_ID);
        createAccountCommand.setAccountName("测试管理员01580");
        createAccountCommand.setEmail("1528683621@qq.com");
        createAccountCommand.setPhone("18668485565");
        createAccountCommand.setAccountType(AccountTypeEnum.BASIC.name());
        createAccountCommand.setIsAdmin(true);
        createAccountCommand.setLoginName("test");
        createAccountCommand.setLoginPwd("123456");
        PojoResult<Long> account = accountFacade.createAccount(createAccountCommand);
        Assert.assertTrue(account.getSuccess());
    }

    @Test
    public void getAccount() {
        AccountBasicQuery accountBasicQuery = new AccountBasicQuery();
        accountBasicQuery.setAccountId(ACCOUNT_ID);
        accountBasicQuery.setTenantId(TENANT_ID);
        PojoResult<AccountDTO> account = accountFacade.getAccount(accountBasicQuery);
        Assert.assertTrue(account.getSuccess());
    }

    @Test
    public void disableAccount() {
        DisableAccountCommand disableAccountCommand = new DisableAccountCommand();
        disableAccountCommand.setAccountId(ACCOUNT_ID);
        disableAccountCommand.setTenantId(TENANT_ID);
        PojoResult<Boolean> account = accountFacade.disableAccount(disableAccountCommand);
        Assert.assertTrue(account.getContent());
    }

    @Test
    public void enableAccount() {
        EnableAccountCommand enableAccountCommand = new EnableAccountCommand();
        enableAccountCommand.setAccountId(ACCOUNT_ID);
        enableAccountCommand.setTenantId(TENANT_ID);
        PojoResult<Boolean> account = accountFacade.enableAccount(enableAccountCommand);
        Assert.assertTrue(account.getContent());
    }

    @Test
    public void deleteAccount() {
        DeleteAccountCommand deleteAccountCommand = new DeleteAccountCommand();
        deleteAccountCommand.setAccountId(ACCOUNT_ID);
        deleteAccountCommand.setTenantId(TENANT_ID);
        PojoResult<Boolean> account = accountFacade.deleteAccount(deleteAccountCommand);
        Assert.assertTrue(account.getContent());
    }

    @Test
    public void modifyAccount() {
        ModifyAccountCommand modifyAccountCommand = new ModifyAccountCommand();
        modifyAccountCommand.setTenantId(TENANT_ID);
        modifyAccountCommand.setAccountId(ACCOUNT_ID);
        modifyAccountCommand.setQq("108719251");
        modifyAccountCommand.setWechat("WxZhongWang");
        PojoResult<Boolean> account = accountFacade.modifyAccount(modifyAccountCommand);
        Assert.assertTrue(account.getContent());
    }

    @Test
    public void createSafeStrategy() throws ParseException {
        CreateSafeStrategyCommand createSafeStrategyCommand = new CreateSafeStrategyCommand();
        createSafeStrategyCommand.setTenantId(TENANT_ID);
        createSafeStrategyCommand.setAccountId(ACCOUNT_ID);
        createSafeStrategyCommand.setAuthCode("1528683821@qq.com");
        createSafeStrategyCommand.setAuthValue("test123");
        createSafeStrategyCommand.setStrategy(LoginSafeStrategyEnum.LDAP);
        createSafeStrategyCommand.setBlockAt(DateUtils.parseDate("2023-01-15 00:00:00", "yyyy-MM-dd HH:mm:ss"));
        createSafeStrategyCommand.setExpiredAt(DateUtils.parseDate("2023-01-10 00:00:00", "yyyy-MM-dd HH:mm:ss"));
        PojoResult<Boolean> account = accountFacade.createSafeStrategy(createSafeStrategyCommand);
        Assert.assertTrue(account.getContent());
    }

    @Test
    public void updateSafeStrategy() throws ParseException {
        UpdateSafeStrategyCommand updateSafeStrategyCommand = new UpdateSafeStrategyCommand();
        updateSafeStrategyCommand.setTenantId(TENANT_ID);
        updateSafeStrategyCommand.setAccountId(ACCOUNT_ID);
        updateSafeStrategyCommand.setAuthCode("1528683821@qq.com");
        updateSafeStrategyCommand.setAuthValue("test123123");
        updateSafeStrategyCommand.setStrategy(LoginSafeStrategyEnum.LDAP);
        updateSafeStrategyCommand.setBlockAt(DateUtils.parseDate("2023-01-15 00:00:00", "yyyy-MM-dd HH:mm:ss"));
        updateSafeStrategyCommand.setExpiredAt(DateUtils.parseDate("2023-01-10 00:00:00", "yyyy-MM-dd HH:mm:ss"));
        PojoResult<Boolean> account = accountFacade.updateSafeStrategy(updateSafeStrategyCommand);
        Assert.assertTrue(account.getContent());
    }
}