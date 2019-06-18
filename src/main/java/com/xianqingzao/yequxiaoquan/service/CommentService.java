package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.CommentDao;
import com.xianqingzao.yequxiaoquan.dao.OrderDao;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page page = commentDao.findByPage(query);
        return page;
    }

    public void delete(String deleterId, String commentId) {
        commentDao.delete(deleterId, commentId);
    }
}

