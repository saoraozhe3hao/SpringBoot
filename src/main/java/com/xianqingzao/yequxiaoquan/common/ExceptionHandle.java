package com.xianqingzao.yequxiaoquan.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestfulResult handle(Exception e){
        return new RestfulResult(1,e.getMessage());
    }
}