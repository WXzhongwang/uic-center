package com.rany.uic.api.facade.account;

import com.cake.framework.common.response.PojoResult;
import com.rany.uic.BaseTests;
import com.rany.uic.api.command.account.CreateAccountCommand;
import com.rany.uic.api.command.account.DeleteAccountCommand;
import com.rany.uic.api.command.account.DisableAccountCommand;
import com.rany.uic.api.command.account.EnableAccountCommand;
import com.rany.uic.api.query.account.AccountBasicQuery;
import com.rany.uic.common.dto.account.AccountDTO;
import com.rany.uic.common.enums.AccountTypeEnum;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

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
    }

    @Test
    public void createSafeStrategy() {
    }

    @Test
    public void updateSafeStrategy() {
    }
}