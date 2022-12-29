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
    ISV_INVALID("2502", "isv不可用"),

    TENANT_NOT_FOUND("3501", "租户未找到"),
    TENANT_DELETED("3502", "租户已删除"),
    TENANT_DISABLED("3503", "租户已禁用"),
    TENANT_SHORT_NAME_EXISTED("3504", "租户简称已存在，换个试试"),
    TENANT_OVER_MAX_SIZE("3505", "租户个数已超过限制"),
    ;

    private final String code;
    private final String message;

    public String getCode() {
        return StrUtil.join("-", ErrorCodeEnum.BIZ.getCode(), this.code);
    }
}
