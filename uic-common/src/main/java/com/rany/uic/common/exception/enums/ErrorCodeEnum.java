package com.rany.uic.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码定义
 * <p>
 * 原则：越靠近底层错误代码越大
 *
 * @author liuwenlong
 * @date 2021-01-27 18:05
 */
@AllArgsConstructor
public enum ErrorCodeEnum {

    /**
     * 业务错误 BusinessException
     */
    BIZ("cb-biz", "业务错误-错误区间[0-10000]"),

    /**
     * 服务层错误 ServiceException
     */
    SYS("cb-sys", "服务错误-错误区间[10000-19999]"),

    /**
     * 外部错误 ManagerException
     */
    OUT("cb-out", "外部错误-错误区间[30000-39999]");

    @Getter
    private String code;

    @Getter
    private String desc;
}
