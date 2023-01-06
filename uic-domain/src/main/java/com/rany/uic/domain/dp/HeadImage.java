package com.rany.uic.domain.dp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/1/6 22:29
 * @email 18668485565163.com
 */
@Data
@NoArgsConstructor
public class HeadImage {

    String img;

    public HeadImage(String headImage) {
        this.img = headImage;
        // 正则
    }
}
