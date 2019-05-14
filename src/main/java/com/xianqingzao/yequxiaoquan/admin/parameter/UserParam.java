package com.xianqingzao.yequxiaoquan.admin.parameter;

public class UserParam {
    private String id;
    private String username;

    public UserParam(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
