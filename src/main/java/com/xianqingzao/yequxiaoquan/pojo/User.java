package com.xianqingzao.yequxiaoquan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.xianqingzao.yequxiaoquan.common.FirstValidGroup;
import com.xianqingzao.yequxiaoquan.common.SecondValidGroup;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)  // 值未null的不输出
public class User implements Serializable {
    private String id;
    @Pattern(regexp = "^1[34578]\\d{9}$", message = "手机号码格式不正确")
    @Pattern(regexp = "^1[34578]\\d{9}$", message = "手机号码格式不正确", groups = {SecondValidGroup.class})
    private String username;
    @Pattern(regexp = "^[a-zA-Z\\u3400-\\u4DB5\\u4E00-\\u9FA5\\u9FA6-\\u9FBB\\uF900-\\uFA2D\\uFA30-\\uFA6A\\uFA70-\\uFAD9]{1,8}$", message = "请输入正确的姓名")
    private String name;
    private String status;
    @Pattern(regexp = "^[A-Za-z\\d]{18,20}$", message = "请输入正确的身份证号")
    private String idNumber;
    @JsonIgnore  // 作为响应时，忽略这个字段
    private String password; // 作为查询结果时使用
    @Size(min = 32, max = 32)
    @Size(min = 32, max = 32, groups = {FirstValidGroup.class})
    private String pwd;      // 作为提交参数时使用
    private List<Role> roles;
    @NotEmpty
    @NotEmpty(groups = {SecondValidGroup.class})
    private List<String> roleIds;
    private List<String> authorities;
    private String creator;

    public User() {

    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String username) {
        this.username = username;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
