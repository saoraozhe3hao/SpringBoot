package com.xianqingzao.yequxiaoquan.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.pojo.Product;
import com.xianqingzao.yequxiaoquan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public RestfulResult<PageInfo<Product>> findByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        Page<Product> products = productService.findByPage(pageNum, pageSize);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return new RestfulResult(pageInfo);
    }
}
