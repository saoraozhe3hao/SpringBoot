package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Merchant;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page<Merchant> operators = merchantService.findByPage(query);
        PageInfo<User> pageInfo = new PageInfo(operators);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/merchant/forbid", method = RequestMethod.PUT)
    public RestfulResult disable(@RequestBody List<Integer> idList) {
        merchantService.disable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/merchant/enable", method = RequestMethod.PUT)
    public RestfulResult enable(@RequestBody List<Integer> idList) {
        merchantService.enable(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/merchant/{id}/deduct", method = RequestMethod.PUT)
    public RestfulResult alter(@PathVariable("id") String id, @Validated @RequestBody Merchant merchant) {
        merchantService.deduct(id, merchant.getDeductScore());
        return new RestfulResult(null);
    }
}
