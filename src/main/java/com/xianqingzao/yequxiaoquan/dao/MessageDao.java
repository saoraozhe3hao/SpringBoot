package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    Page findByPage(Query query);

    public List<Reply> getRepliesByMessageId(String messageId);

    void reply(Reply reply);

    void changeStatus(String id, String status);
}
