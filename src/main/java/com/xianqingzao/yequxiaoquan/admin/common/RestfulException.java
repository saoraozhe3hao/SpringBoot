package com.xianqingzao.yequxiaoquan.admin.common;

public class RestfulException extends RuntimeException {
    private Integer code = -1;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
