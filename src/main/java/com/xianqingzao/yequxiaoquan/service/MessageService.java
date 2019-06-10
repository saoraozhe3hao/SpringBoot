package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.MessageDao;
import com.xianqingzao.yequxiaoquan.dao.OperatorDao;
import com.xianqingzao.yequxiaoquan.dao.RoleDao;
import com.xianqingzao.yequxiaoquan.dao.UserDao;
import com.xianqingzao.yequxiaoquan.pojo.Message;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page<Message> messages = messageDao.findByPage(query);
        return messages;
    }

    public void disable(List idList) {
        messageDao.changeStatus(idList, "disabled");
    }

    public void enable(List idList) {
        messageDao.changeStatus(idList, "normal");
    }

    public void resetPwd(String id, String password) {
        userDao.resetPwd(id, passwordEncoder.encode(password));
    }

    public List getAllRole() {
        return roleDao.findAll();
    }

    @Transactional
    public void alter(String id, String username, List roleIds) {
        messageDao.alter(id, username);
        messageDao.cleanRole(id);
        messageDao.addRoleList(id, roleIds);
    }

    @Transactional
    public void add(String creatorId, User user) {
        user.setStatus("normal");
        user.setPassword(passwordEncoder.encode(user.getPwd()));
        messageDao.add(creatorId, user);
        messageDao.addRoleList(user.getId(), user.getRoleIds());
    }
}

