package com.flying.entity;

import com.flying.constant.HttpCodeEnum;

public class Result<T> {

    private static final String SUCCESS_MSG = "OK";

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T data;

    public Result() {

    }

    public Result(T data) {
        this.status = 200;
        this.msg = SUCCESS_MSG;
        this.data = data;
    }

    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static Result err500() {
        return new Result<>(HttpCodeEnum.CODE_500.getValue(), "系统错误，请联系管理员", null);
    }

    public static Result err500(String msg) {
        return new Result<>(HttpCodeEnum.CODE_500.getValue(), msg, null);
    }

    public static <T> Result<T> err500(String msg, T data) {
        return new Result<>(HttpCodeEnum.CODE_500.getValue(), msg, data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> build(Integer status, String msg, T data) {
        return new Result<>(status, msg, data);
    }

    public static Result ok() {
        return new Result(HttpCodeEnum.CODE_200.getValue(), SUCCESS_MSG);
    }

    public static <T> Result<T> ok(String msg) {
        return new Result<>(HttpCodeEnum.CODE_200.getValue(), msg, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(HttpCodeEnum.CODE_200.getValue(), SUCCESS_MSG, data);
    }

    public static <T> Result<T> build(Integer status, String msg) {
        return new Result<>(status, msg, null);
    }
}
