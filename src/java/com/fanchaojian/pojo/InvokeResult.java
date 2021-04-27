package com.fanchaojian.pojo;

/**
 * @author fanchaojian
 * @date 2021-4-19 - 15:38
 */
public class InvokeResult {
    private String code ;

    private String message ;

    public InvokeResult() {
    }

    public InvokeResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InvokeResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

