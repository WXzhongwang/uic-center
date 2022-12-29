package com.rany.uic.domain.repository;

import com.cake.framework.ddd.repository.Repository;
import com.rany.uic.domain.aggregate.Isv;
import com.rany.uic.domain.pk.IsvId;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:19
 * @email 18668485565163.com
 */

public interface IsvRepository extends Repository<Isv, IsvId> {

    /**
     * isv 禁用
     *
     * @param isv
     * @return
     */
    Boolean disableIsv(Isv isv);
}
