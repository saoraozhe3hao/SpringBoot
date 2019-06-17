package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Product;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    Page findByPage(Query query);

    void audit(String id, String status, String reason);

    void offShelf(String id);
}
