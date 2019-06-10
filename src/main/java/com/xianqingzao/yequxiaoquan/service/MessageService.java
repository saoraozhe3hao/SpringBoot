package com.xianqingzao.yequxiaoquan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianqingzao.yequxiaoquan.dao.MessageDao;
import com.xianqingzao.yequxiaoquan.pojo.Message;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    public Page findByPage(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        Page<Message> messages = messageDao.findByPage(query);
        return messages;
    }

    @Transactional
    public void reply(Reply reply) {
        messageDao.reply(reply);
        messageDao.changeStatus(reply.getMessageId(), "replied");
    }
}

