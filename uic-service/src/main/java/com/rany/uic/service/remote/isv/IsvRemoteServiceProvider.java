package com.rany.uic.service.remote.isv;

import com.alibaba.dubbo.config.annotation.Service;
import com.rany.uic.api.command.isv.CreateIsvCommand;
import com.rany.uic.api.command.isv.DeleteIsvCommand;
import com.rany.uic.api.dto.Result;
import com.rany.uic.api.facade.isv.IsvFacade;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:29
 * @email 18668485565163.com
 */
@Service
public class IsvRemoteServiceProvider implements IsvFacade {
    
    @Override
    public Result<Boolean> createIsv(CreateIsvCommand createIsvCommand) {
        return null;
    }

    @Override
    public Result<Boolean> deleteIsv(DeleteIsvCommand deleteIsvCommand) {
        return Result.succeed(true);
    }
}
