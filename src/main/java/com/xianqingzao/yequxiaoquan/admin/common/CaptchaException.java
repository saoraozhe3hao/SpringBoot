package com.xianqingzao.yequxiaoquan.admin.common;

import org.springframework.security.core.AuthenticationException;

public class CaptchaException extends AuthenticationException {
    public CaptchaException(String msg) {
        super(msg);
    }
}
