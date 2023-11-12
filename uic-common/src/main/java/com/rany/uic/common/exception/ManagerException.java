package com.rany.uic.common.exception;


import lombok.Getter;

/**
 * ManagerException
 *
 * @author zhongshengwang
 * @description ManagerException
 * @date 2022/3/24 1:55 下午
 * @email 18668485565@163.com
 */
@Getter
public class ManagerException extends RuntimeException {

    private String code;

    private String message;

    public ManagerException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ManagerException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public ManagerException(ManagerErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.code = errorMessage.getCode();
        this.message = errorMessage.getMessage();
    }
}
