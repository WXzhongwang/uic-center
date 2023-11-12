package com.rany.uic.common.exception;

import com.cake.framework.common.exception.CommonReturnCode;
import lombok.Getter;

/**
 * BusinessException
 *
 * @author zhongshengwang
 * @description BusinessException
 * @date 2022/3/24 1:55 下午
 * @email 18668485565@163.com
 */

public class BusinessException extends RuntimeException {

    @Getter
    private String code;

    private String message;

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(CommonReturnCode returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
        this.message = returnCode.getMessage();
    }


    public BusinessException(BusinessErrorMessage returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
        this.message = returnCode.getMessage();
    }
}
