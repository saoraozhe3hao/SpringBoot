package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.CustomerDao;
import com.xianqingzao.yequxiaoquan.dao.OperatorDao;
import com.xianqingzao.yequxiaoquan.dao.RoleDao;
import com.xianqingzao.yequxiaoquan.dao.UserDao;
import com.xianqingzao.yequxiaoquan.pojo.Customer;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public Page<Customer> findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page<Customer> customers = customerDao.findByPage(query);
        return customers;
    }

    public void forbid(List idList) {
        customerDao.changeStatus(idList, "forbidden");
    }

    public void enable(List idList) {
        customerDao.changeStatus(idList, "normal");
    }
}

