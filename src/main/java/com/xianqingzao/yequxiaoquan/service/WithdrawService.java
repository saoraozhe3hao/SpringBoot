package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.WithdrawDao;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WithdrawService {
    @Autowired
    private WithdrawDao withdrawDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page page = withdrawDao.findByPage(query);
        return page;
    }

    public void handling(String operatorId, String withdrawId) {
        withdrawDao.handling(operatorId, withdrawId);
    }

    @Transactional
    public void paid(String operatorId, String withdrawId) {
        withdrawDao.deductBalance(withdrawId);
        withdrawDao.paid(operatorId, withdrawId);
    }

}

