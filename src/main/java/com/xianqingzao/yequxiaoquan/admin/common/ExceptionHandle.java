package com.xianqingzao.yequxiaoquan.admin.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestfulResult handle(Exception e){
        RestfulResult result = new RestfulResult();
        result.setCode(1);  // code也需要定制的话，可以扩展RuntimeException，增加code成员。Controller抛出new MyException(2, "我是异常")，这里就可以获取code
        result.setMsg(e.getMessage());
        result.setData(null);
        return result;
    }
}