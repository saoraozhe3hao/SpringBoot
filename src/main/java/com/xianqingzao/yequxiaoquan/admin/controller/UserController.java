package com.xianqingzao.yequxiaoquan.admin.controller;

import com.xianqingzao.yequxiaoquan.admin.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.admin.dao.UserDao;
import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import com.xianqingzao.yequxiaoquan.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 用户详情
    @RequestMapping(value="/me", method=RequestMethod.GET)
    public RestfulResult<User> me(@SessionAttribute("username") String username, @SessionAttribute("authorities") List<String> authorities) throws Exception {
        User user = new User(username);
        user.setAuthorities(authorities);
        RestfulResult result = new RestfulResult();
        result.setData(user);
        return result;
    }

    // 登出
    @RequestMapping(value="/logout")
    public RestfulResult logout(HttpSession session) throws Exception {
        session.removeAttribute("username");
        session.removeAttribute("authorities");
        RestfulResult result = new RestfulResult(-4,"");
        return result;
    }
}
