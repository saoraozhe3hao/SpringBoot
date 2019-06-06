package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
    Page<Product> findByPage();
}
