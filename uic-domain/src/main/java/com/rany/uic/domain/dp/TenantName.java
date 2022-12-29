package com.rany.uic.domain.dp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:14
 * @email 18668485565163.com
 */
@Data
@NoArgsConstructor
//@Value
//@Builder
//@Setter(AccessLevel.PRIVATE)
public class TenantName {

    /**
     * 租户名称
     */
    String name;
    /**
     * 租户英文简称
     * 8-20个英文字符小写组成的串
     * eg. hzrany
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
