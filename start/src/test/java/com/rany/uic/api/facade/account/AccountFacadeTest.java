package com.rany.uic.api.facade.account;

import com.cake.framework.common.response.PojoResult;
import com.rany.uic.BaseTests;
import com.rany.uic.api.command.account.CreateAccountCommand;
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

    @Test
    public void createAccount() {
        CreateAccountCommand createAccountCommand = new CreateAccountCommand();
        createAccountCommand.setTenantId(771342305205563392L);
        createAccountCommand.setAccountName("测试管理员01580");
        createAccountCommand.setEmail("1528683621@qq.com");
        createAccountCommand.setPhone("18668485565");
        createAccountCommand.setAccountType(AccountTypeEnum.BASIC.name());
        createAccountCommand.setIsAdmin(true);
        createAccountCommand.setLoginName("test");
        createAccountCommand.setLoginPwd("123456");
        PojoResult<Boolean> account = accountFacade.createAccount(createAccountCommand);
        Assert.assertTrue(account.getSuccess());
    }

    @Test
    public void disableAccount() {
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