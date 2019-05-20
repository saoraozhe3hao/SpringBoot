package com.xianqingzao.yequxiaoquan.admin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.admin.dao.ProductDao;
import com.xianqingzao.yequxiaoquan.admin.dao.UserDao;
import com.xianqingzao.yequxiaoquan.admin.pojo.Product;
import com.xianqingzao.yequxiaoquan.admin.pojo.Role;
import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Page<Product> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productDao.findByPage();
    }
}

