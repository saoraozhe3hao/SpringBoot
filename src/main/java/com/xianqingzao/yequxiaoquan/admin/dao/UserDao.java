package com.xianqingzao.yequxiaoquan.admin.dao;

import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User getUserByName(User userParam);
    public User getUserById(String id);
}
