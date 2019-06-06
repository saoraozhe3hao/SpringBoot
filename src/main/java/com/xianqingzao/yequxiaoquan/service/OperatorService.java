package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.OperatorDao;
import com.xianqingzao.yequxiaoquan.dao.UserDao;
import com.xianqingzao.yequxiaoquan.pojo.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {
    @Autowired
    private OperatorDao operatorDao;
    @Autowired
    private UserDao userDao;

    public Page<Operator> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Operator> operators =  operatorDao.findByPage();
        return operators;
    }
}

