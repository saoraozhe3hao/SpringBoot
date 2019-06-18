package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    Page findByPage(Query query);

    void refund(String refunderId, String id);

    void setOverdue();
}
