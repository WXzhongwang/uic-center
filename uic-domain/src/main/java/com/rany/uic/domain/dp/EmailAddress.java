package com.rany.uic.domain.dp;

import lombok.Value;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 21:55
 * @email 18668485565163.com
 */
@Value
public class EmailAddress {

    String email;

    public EmailAddress(String email) {
        this.email = email;
        // 正则
    }
}
