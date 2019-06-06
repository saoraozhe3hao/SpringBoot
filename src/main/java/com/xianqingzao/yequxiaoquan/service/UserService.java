package com.xianqingzao.yequxiaoquan.service;

import com.xianqingzao.yequxiaoquan.dao.UserDao;
import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserByName(String username){
        User user = userDao.getUserByName(username);
        if(user == null){
            return null;
        }
        List<Role> roles = userDao.getRolesByUserId(user.getId());
        user.setRoles(roles);
        List<String> authorities = userDao.getAuthoritiesByRoles(roles);
        user.setAuthorities(authorities);
        return user;
    }
}

