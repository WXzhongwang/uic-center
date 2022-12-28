package com.rany.uic.domain.dp;

import lombok.Value;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 21:59
 * @email 18668485565163.com
 */
@Value
public class Phone {
    String phone;

    public Phone(String phone) {
        this.phone = phone;
        // 正则
    }
}
