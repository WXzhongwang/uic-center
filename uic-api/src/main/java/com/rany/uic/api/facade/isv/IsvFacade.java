package com.rany.uic.api.facade.isv;

import com.rany.uic.api.command.isv.CreateIsvCommand;
import com.rany.uic.api.command.isv.DeleteIsvCommand;
import com.rany.uic.api.command.isv.DisableIsvCommand;
import com.rany.uic.api.command.isv.EnableIsvCommand;
import com.rany.uic.api.query.isv.IsvBasicQuery;
import com.rany.uic.common.base.Result;
import com.rany.uic.common.dto.isv.IsvDTO;

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


    /**
     * 禁用ISV
     *
     * @param disableIsvCommand
     * @return
     */
    Result<Boolean> disableIsv(DisableIsvCommand disableIsvCommand);


    /**
     * 启用ISV
     *
     * @param enableIsvCommand
     * @return
     */
    Result<Boolean> enableIsv(EnableIsvCommand enableIsvCommand);


    /**
     * 查询ISV基本信息
     *
     * @param isvBaseQuery
     * @return
     */
    Result<IsvDTO> findIsv(IsvBasicQuery isvBaseQuery);
}
