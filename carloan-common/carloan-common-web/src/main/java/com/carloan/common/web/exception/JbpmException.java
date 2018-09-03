package com.carloan.common.web.exception;

/**
 * Created by zhangyl on 2018/7/30
 * 自定义JBPM异常
 */
public class JbpmException extends RuntimeException {
    private int errorCode;
    private String msg;

    public JbpmException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public JbpmException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
        this.msg = msg;
    }


    public JbpmException(int errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
