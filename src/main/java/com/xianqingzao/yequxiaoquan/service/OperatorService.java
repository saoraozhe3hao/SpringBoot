package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.OperatorDao;
import com.xianqingzao.yequxiaoquan.dao.RoleDao;
import com.xianqingzao.yequxiaoquan.dao.UserDao;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperatorService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OperatorDao operatorDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public Page<User> findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page<User> operators = operatorDao.findByPage(query);
        return operators;
    }

    public void disable(List idList) {
        operatorDao.changeStatus(idList, "disabled");
    }

    public void enable(List idList) {
        operatorDao.changeStatus(idList, "normal");
    }

    public void resetPwd(String id, String password) {
        userDao.resetPwd(id, passwordEncoder.encode(password));
    }

    public List getAllRole() {
        return roleDao.getAllRole();
    }

    @Transactional
    public void alter(String id, String username, List roleIds) {
        operatorDao.alter(id, username);
        operatorDao.cleanRole(id);
        operatorDao.addRoleList(id, roleIds);
    }

    @Transactional
    public void add(String creatorId, User user) {
        user.setStatus("normal");
        user.setPassword(passwordEncoder.encode(user.getPwd()));
        operatorDao.add(creatorId, user);
        operatorDao.addRoleList(user.getId(), user.getRoleIds());
    }
}

