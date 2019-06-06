package com.xianqingzao.yequxiaoquan.common;

import com.xianqingzao.yequxiaoquan.security.LoginFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 只过滤登录接口
        if ("/admin/login".equals(request.getRequestURI()) && "post".equalsIgnoreCase(request.getMethod())) {
            try {
                validate(request);
            }
            catch (CaptchaException e) {
                loginFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validate(HttpServletRequest request) throws CaptchaException {
        String testCode = request.getParameter("captcha");
        Object realObj =  request.getSession().getAttribute("captchaCode");
        if (realObj == null) {
            throw new  CaptchaException("验证码已失效，请重新输入！");
        }
        String realCode = realObj.toString();
        Date now = new Date();
        Long captchaTime = Long.valueOf( request.getSession().getAttribute("captchaTime") + "");
        if (StringUtils.isEmpty(testCode) || !(testCode.equalsIgnoreCase(realCode))) {
            throw new  CaptchaException("验证码错误");
        } else if ((now.getTime() - captchaTime) / 1000 / 60 > 5) {
            throw new  CaptchaException("验证码已失效，请重新输入");
        } else {
            request.getSession().removeAttribute("captchaCode");
        }
    }
}