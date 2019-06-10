package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Customer;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam(value = "search", required = false) String search,
                                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page<Customer> customers = customerService.findByPage(query);
        PageInfo<Customer> pageInfo = new PageInfo(customers);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/customer/forbid", method = RequestMethod.PUT)
    public RestfulResult disable(@RequestBody List<String> idList) {
        customerService.forbid(idList);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/customer/enable", method = RequestMethod.PUT)
    public RestfulResult enable(@RequestBody List<String> idList) {
        customerService.enable(idList);
        return new RestfulResult(null);
    }
}
