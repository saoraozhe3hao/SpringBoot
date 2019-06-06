package com.xianqingzao.yequxiaoquan.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacService")
public class RbacService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        List<String> authorityList = (List<String>) request.getSession().getAttribute("authorities");
        // 未登录
        if (authorityList == null) {
            return false;
        }

        String method = request.getMethod().toLowerCase();
        String path = request.getServletPath();
        for (String authority : authorityList) {
            // authority 的格式为 module.allow
            // allow取值: get、post、put、delete、all
            String module = authority.split("\\.")[0];
            String allow = authority.split("\\.")[1];
            String regexStart = "/admin/" + module + "/";
            String regexEnd = "/admin/" + module + "$";
            if (path.matches(regexStart) || path.matches(regexEnd)) {
                // 权限列表里有的模块，才允许访问，且请求方法需要匹配
                if (method.equals("get") || method.equals(allow) || allow.equals("all")) {
                    return true;
                }
            }
        }
        return false;
    }
}
