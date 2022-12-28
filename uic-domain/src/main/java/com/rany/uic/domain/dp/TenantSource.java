package com.rany.uic.domain.dp;

import lombok.Value;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 21:58
 * @email 18668485565163.com
 */
@Value
public class TenantSource {

    String source;

    public TenantSource(String source) {
        this.source = source;
        // 正则
    }
}
