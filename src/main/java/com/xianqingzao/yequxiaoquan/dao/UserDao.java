package com.xianqingzao.yequxiaoquan.dao;

import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByName(String username);
    public List<Role> getRolesByUserId(String userId);
    public List<String> getAuthoritiesByRoles(List<Role> roles);
}
