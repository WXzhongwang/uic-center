package com.rany.uic.common.exception;

import com.rany.uic.common.exception.enums.ServiceErrorMessage;

/**
 * ManagerException
 *
 * @author zhongshengwang
 * @description ServiceException
 * @date 2022/3/24 1:55 下午
 * @email zhongshengwang@shuwen.com
 */

public class ServiceException extends RuntimeException {

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

    public ServiceException(ServiceErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.code = errorMessage.getCode();
        this.message = errorMessage.getMessage();
    }

    public ServiceException(ServiceErrorMessage errorMessage, Throwable cause) {
        super(errorMessage.getMessage(), cause);
        this.code = errorMessage.getCode();
        this.message = errorMessage.getMessage();
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}
