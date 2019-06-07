package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Operator;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class OperatorController {

    @Autowired
    private OperatorService operatorServicee;

    @RequestMapping(value="/operator", method=RequestMethod.GET)
    public RestfulResult<PageInfo<Operator>> findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        Page<Operator> operators = operatorServicee.findByPage(pageNum, pageSize);
        PageInfo<Operator> pageInfo = new PageInfo<>(operators);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value="/operator/disable", method=RequestMethod.PUT)
    public RestfulResult disable(@RequestBody List<Integer> idList) {
        operatorServicee.disable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value="/operator/enable", method=RequestMethod.PUT)
    public RestfulResult enable(@RequestBody List<Integer> idList) {
        operatorServicee.enable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value="/operator/{id}/password", method=RequestMethod.PUT)
    public RestfulResult resetPwd(@PathVariable("id") String id, @RequestBody Map<String,String> map) {
        operatorServicee.resetPwd(id, map.get("password"));
        return new RestfulResult(null);
    }
}
