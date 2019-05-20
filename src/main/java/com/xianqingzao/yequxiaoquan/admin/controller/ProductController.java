package com.xianqingzao.yequxiaoquan.admin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xianqingzao.yequxiaoquan.admin.common.RestfulResult;
import com.xianqingzao.yequxiaoquan.admin.pojo.Product;
import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import com.xianqingzao.yequxiaoquan.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
