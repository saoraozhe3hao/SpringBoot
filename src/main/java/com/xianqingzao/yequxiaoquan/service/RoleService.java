package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.OperatorDao;
import com.xianqingzao.yequxiaoquan.dao.RoleDao;
import com.xianqingzao.yequxiaoquan.dao.UserDao;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private OperatorDao operatorDao;
    @Autowired
    private RoleDao roleDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page page = roleDao.findByPage(query);
        return page;
    }

    @Transactional
    public void disable(List idList) {
        roleDao.changeStatus(idList, "disabled");
        roleDao.removeUserRole(idList);
    }

    public void enable(List idList) {
        roleDao.changeStatus(idList, "normal");
    }

    public List getAllAuthority() {
        return roleDao.findAllAuthority();
    }

    @Transactional
    public void alter(String id, String name, List authorityIds) {
        roleDao.alter(id, name);
        roleDao.cleanAuthority(id);
        roleDao.addAuthorityList(id, authorityIds);
    }

    @Transactional
    public void add(Role role) {
        role.setStatus("normal");
        roleDao.add(role);
        roleDao.addAuthorityList(role.getId(), role.getAuthorityIds());
    }
}

