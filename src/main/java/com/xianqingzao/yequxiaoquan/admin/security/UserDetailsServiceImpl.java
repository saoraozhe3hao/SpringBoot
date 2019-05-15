package com.xianqingzao.yequxiaoquan.admin.security;

import com.xianqingzao.yequxiaoquan.admin.dao.UserDao;
import com.xianqingzao.yequxiaoquan.admin.pojo.Role;
import com.xianqingzao.yequxiaoquan.admin.pojo.User;
import com.xianqingzao.yequxiaoquan.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名，从数据库找出用户信息
        User user = userService.getUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 参数依次为：用户名，数据库里记录的密码，可用，未过期，密码未过期，未被锁定，权限列表
        // Spring Security 会 自动对比 PasswordEncoder.match(用户输入的密码) 和 这里传入的密码
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true,
                true, true, AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles().get(0).getName()));
    }
}
