package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Operator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorDao {
    Page<Operator> findByPage();
    void changeStatus(List idList, String status);
}
