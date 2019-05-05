package com.xianqingzao.yequxiaoquan.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
public class MyController {
    @Value("${server.port}")   // 引用配置的值
    private String port;
    @RequestMapping("/hello")
    public String Hello(){
        return "Hello World";
    }
}
