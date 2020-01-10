package com.flying.exception;

public class MyException extends RuntimeException {


    private String errorCode;

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
    }

    public MyException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public MyException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
