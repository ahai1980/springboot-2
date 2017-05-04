package com.ora.constant;


import com.ora.result.ErrorInfoInterface;

/**
 * 业务错误码 案例
 */
public enum UserErrorInfoEnum implements ErrorInfoInterface {
    PARAMS_NO_COMPLETE("000001", "params no complete"),
    CITY_EXIT("000002", "city exit");

    private String code;

    private String message;

    UserErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
