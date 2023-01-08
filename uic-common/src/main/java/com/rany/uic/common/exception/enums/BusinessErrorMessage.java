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
    ISV_INVALID("2503", "isv不可用"),
    ISV_CHECK_NOT_PASS("2504", "isv校验不通过"),

    TENANT_NOT_FOUND("3500", "租户未找到"),
    TENANT_DELETED("3501", "租户已删除"),
    TENANT_DISABLED("3502", "租户已禁用"),

    TENANT_INVALID("3503", "租户不可用"),
    TENANT_CHECK_NOT_PASS("3504", "isv校验不通过"),
    TENANT_SHORT_NAME_EXISTED("3505", "租户简称已存在，换个试试"),
    TENANT_OVER_MAX_SIZE("3506", "租户个数已超过限制"),

    ACCOUNT_NAME_DUPLICATED("4500", "账号名已重复"),
    ACCOUNT_NOT_FOUND("4501", "账号未找到"),
    ACCOUNT_DELETED("4502", "账号已删除"),
    ACCOUNT_DISABLED("4503", "账号已禁用"),

    ACCOUNT_STRATEGY_NOT_FOUND("5500", "账号登录方式未找到"),
    ;

    private final String code;
    private final String message;

    public String getCode() {
        return StrUtil.join("-", ErrorCodeEnum.BIZ.getCode(), this.code);
    }
}
