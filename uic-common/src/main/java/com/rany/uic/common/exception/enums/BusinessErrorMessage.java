package com.rany.uic.common.exception.enums;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhongshengwang
 */
@Getter
@AllArgsConstructor
public enum BusinessErrorMessage {

    ISV_NOT_FOUND("2500", "isv未找到"),
    ISV_DELETED("2501", "isv已删除"),
    ISV_DISABLED("2502", "isv已禁用"),
    ;

    private final String code;
    private final String message;

    public String getCode() {
        return StrUtil.join("-", ErrorCodeEnum.BIZ.getCode(), this.code);
    }
}
