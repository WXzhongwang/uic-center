package com.rany.uic.common.exception;

import cn.hutool.core.util.StrUtil;
import com.cake.framework.common.exception.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Manager 错误消息定义
 *
 * @author zhongshengwang
 */
@Getter
@AllArgsConstructor
public enum ManagerErrorMessage {


    GET_USER_ROLE_ERROR("50001", "获取用户角色失败");

    private final String code;
    private final String message;

    public String getCode() {
        return StrUtil.join("-", ErrorCodeEnum.OUT.getCode(), this.code);
    }
}
