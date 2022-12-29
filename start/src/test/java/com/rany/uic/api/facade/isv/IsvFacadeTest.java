package com.rany.uic.api.facade.isv;

import cn.hutool.core.lang.Assert;
import com.rany.uic.BaseTests;
import com.rany.uic.api.command.isv.CreateIsvCommand;
import com.rany.uic.api.command.isv.DeleteIsvCommand;
import com.rany.uic.api.dto.Result;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/28 19:53
 * @email 18668485565163.com
 */
public class IsvFacadeTest extends BaseTests {

    @Resource
    private IsvFacade isvFacade;

    @Test
    public void createIsv() {
        CreateIsvCommand createIsvCommand = new CreateIsvCommand();
        createIsvCommand.setName("杭州锐尼科技有限公司");
        createIsvCommand.setShortName("hzrany");
        createIsvCommand.setEmail("18668485565@163.com");
        createIsvCommand.setUrl("www.ranytech.com");
        createIsvCommand.setCountry("中国");
        createIsvCommand.setRegisterIp("127.0.0.1");
        createIsvCommand.setPhone("18668485565");
        Result<Boolean> isv = isvFacade.createIsv(createIsvCommand);
        Assert.isTrue(isv.isSuccess());
    }

    @Test
    public void deleteIsv() {
        DeleteIsvCommand deleteIsvCommand = new DeleteIsvCommand();
        deleteIsvCommand.setId(768060752375459840L);
        Result<Boolean> isv = isvFacade.deleteIsv(deleteIsvCommand);
        Assert.isTrue(isv.isSuccess());
    }
}