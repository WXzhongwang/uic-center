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
// @Value
@Data
@NoArgsConstructor
//@Value
//@Builder
//@Setter(AccessLevel.PRIVATE)
public class IsvName {

    String name;

    /**
     * 租户英文简称
     */
    String shortName;

    public IsvName(String name, String shortName) {
        if (name == null || name.length() > 100) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.shortName = shortName;
    }
}
