package com.example.demoapi;

import java.io.Serializable;

/**
 * @Author mubi
 * @Date 2021/6/3 22:30
 */
public class ResponseData<T> implements Serializable {

    private String code;

    private String msg;

    private T data;


    public ResponseData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(T data) {
        this.code = "0";
        this.msg = "SUCCESS";
        this.data = data;
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}