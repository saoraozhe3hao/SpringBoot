package com.xianqingzao.yequxiaoquan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xianqingzao.yequxiaoquan.common.SecondValidGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Role implements Serializable {
    private String id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\u3400-\\u4DB5\\u4E00-\\u9FA5\\u9FA6-\\u9FBB\\uF900-\\uFA2D\\uFA30-\\uFA6A\\uFA70-\\uFAD9]{1,8}$", message = "请输入正确的姓名")
    private String name;
    private String status;
    private List<Authority> authorities;
    @NotEmpty
    private List<String> authorityIds;

    public Role() {
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public List<String> getAuthorityIds() {
        return authorityIds;
    }

    public void setAuthorityIds(List<String> authorityIds) {
        this.authorityIds = authorityIds;
    }
}
