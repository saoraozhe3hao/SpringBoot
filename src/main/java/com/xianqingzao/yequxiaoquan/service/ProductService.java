package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.ProductDao;
import com.xianqingzao.yequxiaoquan.pojo.Product;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page page = productDao.findByPage(query);
        return page;
    }

    public void approve(String id) {
        productDao.audit(id, "noneOrder", null);
    }

    @Transactional
    public void disapprove(Product product) {
        productDao.audit(product.getId(), "unapproved", product.getRefuseReason());
    }

    public void offShelf(String productId) {
        productDao.offShelf(productId);
    }
}

