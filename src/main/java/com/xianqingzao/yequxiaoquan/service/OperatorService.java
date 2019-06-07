package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.OperatorDao;
import com.xianqingzao.yequxiaoquan.dao.RoleDao;
import com.xianqingzao.yequxiaoquan.pojo.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OperatorDao operatorDao;
    @Autowired
    private RoleDao roleDao;

    public Page<Operator> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Operator> operators = operatorDao.findByPage();
        return operators;
    }

    public void disable(List idList) {
        operatorDao.changeStatus(idList, "disabled");
    }

    public void enable(List idList) {
        operatorDao.changeStatus(idList, "normal");
    }

    public void resetPwd(String id, String password) {
        operatorDao.resetPwd(id, passwordEncoder.encode(password));
    }

    public List getAllRole() {
        return roleDao.getAllRole();
    }

    public void alter(String id, String username, List roleIds) {
        operatorDao.alter(id, username);
        operatorDao.cleanRole(id);
        operatorDao.addRoleList(id, roleIds);
    }
}

