package com.xianqingzao.yequxiaoquan.controller;

import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 用户详情
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public RestfulResult<User> me(HttpSession session, @SessionAttribute("username") String username) throws Exception {
        User user = userService.getUserByName(username);
        session.setAttribute("userDetail", user);
        return new RestfulResult(user);
    }

    // 登出
    @RequestMapping(value = "/logout")
    public RestfulResult logout(HttpSession session) throws Exception {
        session.removeAttribute("username");
        session.removeAttribute("authorities");
        return new RestfulResult(-4, "");
    }
}
