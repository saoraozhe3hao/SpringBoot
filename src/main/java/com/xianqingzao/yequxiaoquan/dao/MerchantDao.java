package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Merchant;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantDao {
    Page findByPage(Query query);

    void changeStatus(List idList, String status);

    void deduct(String id, Float deductScore);
}
