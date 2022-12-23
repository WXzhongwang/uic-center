package com.rany.uic.api.facade.isv;

import com.rany.uic.api.command.isv.CreateIsvCommand;
import com.rany.uic.api.command.isv.DeleteIsvCommand;
import com.rany.uic.api.dto.Result;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/15 22:21
 * @email 18668485565163.com
 */
public interface IsvFacade {


    /**
     * 创建ISV
     *
     * @param createIsvCommand
     * @return
     */
    Result<Boolean> createIsv(CreateIsvCommand createIsvCommand);

    /**
     * ISV 删除
     *
     * @param deleteIsvCommand
     * @return
     */
    Result<Boolean> deleteIsv(DeleteIsvCommand deleteIsvCommand);
}
