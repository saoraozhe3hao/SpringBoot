package com.xianqingzao.yequxiaoquan.admin.mapper;

import com.xianqingzao.yequxiaoquan.admin.parameter.UserParam;
import com.xianqingzao.yequxiaoquan.admin.result.UserResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserResult getUser(UserParam userParam);   // SQL操作函数
}
