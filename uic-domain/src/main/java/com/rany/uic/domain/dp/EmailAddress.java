package com.rany.uic.domain.dp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 21:55
 * @email 18668485565163.com
 */
@Data
@NoArgsConstructor
//@Value
//@Builder
//@Setter(AccessLevel.PRIVATE)
public class EmailAddress {

    String email;

    public EmailAddress(String email) {
        this.email = email;
        // 正则
    }
}
