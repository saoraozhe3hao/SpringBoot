package com.xianqingzao.yequxiaoquan.dao;

import com.github.pagehelper.Page;
import com.xianqingzao.yequxiaoquan.pojo.Authority;
import com.xianqingzao.yequxiaoquan.pojo.Query;
import com.xianqingzao.yequxiaoquan.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    public List<Role> findAll();

    Page<Role> findByPage(Query query);

    public List<Authority> getAuthoritiesByRoleId(String roleId);

    void changeStatus(List idList, String status);

    void removeUserRole(List roleIdList);

    public List<Authority> findAllAuthority();

    void alter(String id, String name);

    void cleanAuthority(String roleId);

    void addAuthorityList(String roleId, List authorityIds);

    void add(Role role);
}
