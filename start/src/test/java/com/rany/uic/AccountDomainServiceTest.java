package com.rany.uic;

import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.service.AccountDomainService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/1 22:42
 * @email 18668485565163.com
 */
public class AccountDomainServiceTest extends BaseTests {

    @Resource
    private AccountDomainService accountDomainService;

    @Test
    public void testSave() throws InterruptedException {
        long base = 144;
        for (int i = 0; i < 200; i++) {
            base += i;
            Account account = new Account(accountDomainService, new AccountId(base), new AccountName("zhongshengwang.zsw"));
            Boolean save = account.save();
            // Assert.assertTrue(save);
        }
    }
}