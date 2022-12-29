package com.rany.uic;

import com.rany.uic.common.util.SnowflakeIdWorker;
import com.rany.uic.domain.aggregate.Account;
import com.rany.uic.domain.dp.AccountName;
import com.rany.uic.domain.pk.AccountId;
import com.rany.uic.domain.service.AccountDomainService;
import org.junit.Assert;
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
    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    @Test
    public void testSave() {
        Account account = new Account(new AccountId(snowflakeIdWorker.nextId()), new AccountName("zhongshengwang.zsw"));
        account.save();
        Boolean saveRes = accountDomainService.save(account);
        Assert.assertTrue(saveRes);
    }
}