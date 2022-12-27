package com.rany.uic.domain.dp;

import lombok.Value;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:14
 * @email 18668485565163.com
 */
@Value
public class TenantName {

    /**
     * 租户名称
     */
    String name;
    /**
     * 租户英文简称
     */
    String shortName;


    public TenantName(String name, String shortName) {
        if (name == null || name.length() < 8) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.shortName = shortName;
    }
}
