package com.xianqingzao.yequxiaoquan.service;

import com.xianqingzao.yequxiaoquan.common.RestfulException;
import com.xianqingzao.yequxiaoquan.dao.UserDao;
import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;

    public User getUserByName(String username) {
        User user = userDao.getUserByName(username);
        if (user == null) {
            return null;
        }
        List<Role> roles = userDao.getRolesByUserId(user.getId());
        user.setRoles(roles);
        List<String> authorities = userDao.getAuthoritiesByRoles(roles);
        user.setAuthorities(authorities);
        return user;
    }

    public String resetPwd(User oldMe, User newMe) {
        if (!passwordEncoder.matches(newMe.getOldPwd(), oldMe.getPassword())) {
            throw new RestfulException("原密码错误");
        }
        String encodedPwd = passwordEncoder.encode(newMe.getPwd());
        userDao.resetPwd(oldMe.getId(), encodedPwd);
        return encodedPwd;
    }
}

