package com.rany.uic.domain.dp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/12/27 21:58
 * @email 18668485565163.com
 */
@Data
@NoArgsConstructor
//@Value
//@Builder
//@Setter(AccessLevel.PRIVATE)
public class TenantSource {

    String source;

    public TenantSource(String source) {
        this.source = source;
        // 正则
    }
}
