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
public class AccountName {

    String name;

    public AccountName(String name) {
        if (name == null || name.length() < 8) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
