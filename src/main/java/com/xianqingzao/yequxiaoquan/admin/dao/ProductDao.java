package com.xianqingzao.yequxiaoquan.admin.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.admin.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    Page<Product> findByPage();
}
