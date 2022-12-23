package com.rany.uic.common.exception.enums;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhongshengwang
 */
@Getter
@AllArgsConstructor
public enum ServiceErrorMessage {

    ADD_ENTITY_ERROR("10001", "实体操作失败");


    private final String code;
    private final String message;

    public String getCode() {
        return StrUtil.join("-", ErrorCodeEnum.SYS.getCode(), this.code);
    }
}
