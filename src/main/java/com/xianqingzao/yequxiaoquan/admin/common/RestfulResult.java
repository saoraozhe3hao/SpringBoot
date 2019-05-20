package com.xianqingzao.yequxiaoquan.admin.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RestfulResult<T> {
    private Integer code = 0;
    private String msg;
    private T data;

    public RestfulResult(T data) {
        this.data = data;
    }

    public RestfulResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
