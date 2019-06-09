package com.xianqingzao.yequxiaoquan.controller;

import com.xianqingzao.yequxiaoquan.common.FirstValidGroup;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.common.ThirdValidGroup;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 用户详情
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public RestfulResult<User> me(HttpSession session, @SessionAttribute("username") String username) {
        User user = userService.getUserByName(username);
        session.setAttribute("userDetail", user);
        return new RestfulResult(user);
    }

    // 修改密码
    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    public RestfulResult resetPwd(HttpSession session, @Validated({ThirdValidGroup.class}) @RequestBody User newMe, @SessionAttribute("userDetail") User oldMe) {
        String newEncodedPwd = userService.resetPwd(oldMe, newMe);
        oldMe.setPassword(newEncodedPwd);
        session.setAttribute("userDetail", oldMe);
        return new RestfulResult(null);
    }

    // 登出
    @RequestMapping(value = "/logout")
    public RestfulResult logout(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("authorities");
        return new RestfulResult(-4, "");
    }
}
