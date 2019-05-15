package com.xianqingzao.yequxiaoquan.admin.controller;

import com.xianqingzao.yequxiaoquan.admin.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import com.xianqingzao.yequxiaoquan.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private UserService userService;

    // 商品列表
    @RequestMapping(value="/product", method=RequestMethod.GET)
    public RestfulResult<User> product(@SessionAttribute("username") String username) throws Exception {
        User user = userService.getUserByName(username);
        RestfulResult result = new RestfulResult();
        return result;
    }

    // 商户举报列表
    @RequestMapping(value="/tipOff")
    public RestfulResult<User> tipOff(@SessionAttribute("username") String username) throws Exception {
        User user = userService.getUserByName(username);
        RestfulResult result = new RestfulResult();
        return result;
    }
}
