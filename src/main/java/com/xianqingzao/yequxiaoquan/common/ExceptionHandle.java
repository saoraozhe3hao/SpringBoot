package com.xianqingzao.yequxiaoquan.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestfulResult handle(Exception e) {
        String errorMsg = e.getMessage();
        if(errorMsg == null){
            errorMsg = e.getCause().toString();
        }
        return new RestfulResult(1, errorMsg);
    }
}