package com.xianqingzao.yequxiaoquan.security;

import com.xianqingzao.yequxiaoquan.pojo.User;
import com.xianqingzao.yequxiaoquan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名，从数据库找出用户信息
        User user = userService.getUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        // List<String> 转 List<GrantedAuthority>
        List<String> authorityList = user.getAuthorities();
        List<GrantedAuthority> authorities = new ArrayList(authorityList.size());
        for(String authority : authorityList){
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        // 参数依次为：用户名，数据库里记录的密码，可用，未过期，密码未过期，未被锁定，权限列表
        // Spring Security 会 自动对比 PasswordEncoder.match(用户输入的密码) 和 这里传入的密码
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true,
                true, true, authorities);
    }
}
