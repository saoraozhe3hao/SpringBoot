package com.xianqingzao.yequxiaoquan.admin.dao;

import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUser(User userParam);   // SQL操作函数
}
