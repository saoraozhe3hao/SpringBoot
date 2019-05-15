package com.xianqingzao.yequxiaoquan.admin.dao;

import com.xianqingzao.yequxiaoquan.admin.pojo.Role;
import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public User getUserByName(String username);
    public List<Role> getRolesByUserId(String userId);
    public List<String> getAuthoritiesByRoles(List<Role> roles);
}
