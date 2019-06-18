package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.OrderDao;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page page = orderDao.findByPage(query);
        return page;
    }

    public void refund(String refunderId, String orderId) {
        orderDao.refund(refunderId, orderId);
    }
}

