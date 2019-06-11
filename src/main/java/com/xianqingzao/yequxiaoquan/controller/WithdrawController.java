package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Record;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page page = withdrawService.findByPage(query);
        PageInfo pageInfo = new PageInfo(page);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/withdraw/{id}/handling", method = RequestMethod.PUT)
    public RestfulResult handling(@PathVariable("id") String withdrawId, @SessionAttribute("userDetail") User operator) {
        withdrawService.handling(operator.getId(), withdrawId);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/withdraw/{id}/paid", method = RequestMethod.PUT)
    public RestfulResult paid(@PathVariable("id") String withdrawId, @SessionAttribute("userDetail") User operator) {
        withdrawService.paid(operator.getId(), withdrawId);
        return new RestfulResult(null);
    }
}
