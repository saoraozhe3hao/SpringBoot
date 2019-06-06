package com.xianqingzao.yequxiaoquan.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        RestfulResult result = new RestfulResult(-1, e.getMessage());
        response.getWriter().write(objectMapper.writeValueAsString(result));  // 将对象转成JSON字符串
    }
}