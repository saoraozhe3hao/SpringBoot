package com.xianqingzao.yequxiaoquan.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        request.getSession().setAttribute("username", request.getParameter("username"));
        // Collection<GrantedAuthority> 转 List<String>，把权限列表存到session
        Collection<? extends GrantedAuthority> authorityList = authentication.getAuthorities();
        List<String> authorities = new ArrayList(authorityList.size());
        Iterator<? extends GrantedAuthority> iterator = authorityList.iterator();
        while (iterator.hasNext()){
            authorities.add(iterator.next().getAuthority());
        }
        request.getSession().setAttribute("authorities",authorities);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString( new RestfulResult(null)));
    }
}
