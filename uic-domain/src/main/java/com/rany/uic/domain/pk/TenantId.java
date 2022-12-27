package com.rany.uic.domain.pk;

import com.cake.framework.common.base.Identifier;
import lombok.Value;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:12
 * @email 18668485565163.com
 */
@Value
public class TenantId implements Identifier {

    Long id;

    public TenantId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }
}

