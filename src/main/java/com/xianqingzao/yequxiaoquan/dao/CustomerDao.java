package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {
    Page findByPage(Query query);

    void changeStatus(List idList, String status);
}
