package com.rany.uic.api.facade.tenant;

import cn.hutool.core.util.RandomUtil;
import com.rany.uic.BaseTests;
import com.rany.uic.api.command.tenant.CreateTenantCommand;
import com.rany.uic.api.command.tenant.DisableTenantCommand;
import com.rany.uic.api.command.tenant.EnableTenantCommand;
import com.rany.uic.api.command.tenant.ModifyTenantCommand;
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
        createTenantCommand.setName(RandomUtil.randomString(15));
        createTenantCommand.setShortName(RandomUtil.randomString(8));
        createTenantCommand.setEmail("lovepet24@163.com");
        createTenantCommand.setPhone("18668485565");
        createTenantCommand.setSource("dev");
        createTenantCommand.setInitialAccount(true);
        tenantFacade.createTenant(createTenantCommand);
    }


    @Test
    public void modifyTenant() {
        ModifyTenantCommand modifyTenantCommand = new ModifyTenantCommand();
        modifyTenantCommand.setTenantId(768460649511661568L);
        modifyTenantCommand.setName("杭州锐尼科技有限公司01");
        modifyTenantCommand.setEmail("lovepet24@163.com");
        modifyTenantCommand.setPhone("13554353449");
        modifyTenantCommand.setAddress("浙江省杭州市西湖区");
        tenantFacade.modifyTenant(modifyTenantCommand);
    }

    @Test
    public void disableTenant() {
        DisableTenantCommand disableTenantCommand = new DisableTenantCommand();
        disableTenantCommand.setTenantId(768460649511661568L);
        tenantFacade.disableTenant(disableTenantCommand);
    }


    @Test
    public void enableTenant() {
        EnableTenantCommand enableTenantCommand = new EnableTenantCommand();
        enableTenantCommand.setTenantId(768460649511661568L);
        tenantFacade.enableTenant(enableTenantCommand);
    }
}