package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.MerchantDao;
import com.xianqingzao.yequxiaoquan.pojo.Merchant;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MerchantService {
    @Autowired
    private MerchantDao merchantDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page page = merchantDao.findByPage(query);
        return page;
    }

    public void disable(List idList) {
        merchantDao.changeStatus(idList, "forbidden");
    }

    public void enable(List idList) {
        merchantDao.changeStatus(idList, "normal");
    }

    @Transactional
    public void deduct(String id, Float deductScore) {
        merchantDao.deduct(id, deductScore);
    }
}

