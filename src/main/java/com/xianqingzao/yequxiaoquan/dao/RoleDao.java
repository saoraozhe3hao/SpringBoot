package com.xianqingzao.yequxiaoquan.dao;

import com.xianqingzao.yequxiaoquan.pojo.Role;
import com.xianqingzao.yequxiaoquan.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    public List<Role> getAllRole();
}
