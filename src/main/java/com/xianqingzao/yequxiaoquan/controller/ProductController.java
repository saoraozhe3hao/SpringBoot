package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Product;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public RestfulResult findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam(value = "search", required = false) String search,
                                    @RequestParam(value = "status", required = false) String status) {
        Query query = new Query(pageNum, pageSize, search, status);
        Page page = productService.findByPage(query);
        PageInfo pageInfo = new PageInfo(page);
        return new RestfulResult(pageInfo);
    }

    @RequestMapping(value = "/product/{id}/approve", method = RequestMethod.PUT)
    public RestfulResult approve(@PathVariable("id") String productId) {
        productService.approve(productId);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/product/{id}/disapprove", method = RequestMethod.PUT)
    public RestfulResult disapprove(@PathVariable("id") String productId, @RequestBody @Validated Product product) {
        product.setId(productId);
        productService.disapprove(product);
        return new RestfulResult(null);
    }

    @RequestMapping(value = "/product/{id}/offShelf", method = RequestMethod.PUT)
    public RestfulResult offShelf(@PathVariable("id") String productId) {
        productService.offShelf(productId);
        return new RestfulResult(null);
    }
}
