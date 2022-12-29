package com.rany.uic.api.facade.tenant;

import com.rany.uic.BaseTests;
import com.rany.uic.api.command.tenant.CreateTenantCommand;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/29 22:39
 * @email 18668485565163.com
 */
public class TenantFacadeTest extends BaseTests {
    @Resource
    private TenantFacade tenantFacade;

    @Test
    public void createTenant() {
        CreateTenantCommand createTenantCommand = new CreateTenantCommand();
        createTenantCommand.setIsvId(768060752375459840L);
        createTenantCommand.setName("杭州锐尼科技有限公司");
        createTenantCommand.setShortName("hzrany");
        createTenantCommand.setEmail("lovepet24@163.com");
        createTenantCommand.setPhone("18668485565");
        createTenantCommand.setSource("dev");
        createTenantCommand.setInitialAccount(true);
        tenantFacade.createTenant(createTenantCommand);
    }
}