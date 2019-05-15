package com.xianqingzao.yequxiaoquan.admin.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Role implements Serializable {
    private String id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
