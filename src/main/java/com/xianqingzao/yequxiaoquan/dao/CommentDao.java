package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao {
    Page findByPage(Query query);

    void delete(String deleterId, String id);
}
