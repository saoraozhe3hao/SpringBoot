package com.xianqingzao.yequxiaoquan.dao;

import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByName(String username);
    public List getRolesByUserId(String userId);
    public List getAuthoritiesByRoles(List<Role> roles);
    void resetPwd(String id, String password);
}
