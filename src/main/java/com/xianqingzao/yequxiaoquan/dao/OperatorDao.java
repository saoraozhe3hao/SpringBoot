package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorDao {
    Page<User> findByPage(Query query);

    void changeStatus(List idList, String status);

    void alter(String id, String username);

    void cleanRole(String userId);

    void addRoleList(String userId, List roleIds);

    void add(String creatorId, User user);
}
