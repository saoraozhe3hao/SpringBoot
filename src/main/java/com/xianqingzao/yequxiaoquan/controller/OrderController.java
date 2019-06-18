package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Product;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.OrderService;
import com.xianqingzao.yequxiaoquan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam(value = "search", required = false) String search,
                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page page = orderService.findByPage(query);
        PageInfo pageInfo = new PageInfo(page);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/order/{id}/refund", method = RequestMethod.PUT)
    public RestfulResult refund(@PathVariable("id") String orderId, @SessionAttribute("userDetail") User refunder) {
        orderService.refund(refunder.getId(), orderId);
        return new RestfulResult(null);
    }
}
