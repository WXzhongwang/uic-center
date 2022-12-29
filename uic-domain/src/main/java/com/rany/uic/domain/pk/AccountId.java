package com.rany.uic.domain.pk;

import com.cake.framework.common.base.Identifier;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/11/26 00:12
 * @email 18668485565163.com
 */
@Data
@NoArgsConstructor
//@Value
//@Builder
//@Setter(AccessLevel.PRIVATE)
public class AccountId implements Identifier {

    Long id;

    public AccountId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }
}

