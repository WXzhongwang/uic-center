package com.rany.uic.common.exception;

import com.rany.uic.common.exception.enums.BusinessErrorMessage;
import com.rany.uic.common.exception.enums.CommonReturnCode;

/**
 * BusinessException
 *
 * @author zhongshengwang
 * @description BusinessException
 * @date 2022/3/24 1:55 下午
 * @email zhongshengwang@shuwen.com
 */

public class BusinessException extends RuntimeException {

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

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
