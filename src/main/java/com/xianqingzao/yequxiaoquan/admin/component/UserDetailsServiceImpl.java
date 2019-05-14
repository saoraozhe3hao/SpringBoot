package com.xianqingzao.yequxiaoquan.admin.component;

import com.xianqingzao.yequxiaoquan.admin.mapper.UserMapper;
import com.xianqingzao.yequxiaoquan.admin.parameter.UserParam;
import com.xianqingzao.yequxiaoquan.admin.result.UserResult;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private SqlSessionFactory sqlSessionFactory;
//    @Autowired
//    private ApplicationContext applicationContext;
    @Autowired
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名，从数据库找出用户信息
        // 参数依次为：用户名，数据库里记录的密码，可用，未过期，密码未过期，未被锁定，权限列表
        // Spring Security 会 自动调用 PasswordEncoder.match() 来判断密码是否正确
//        String pwd = passwordEncoder.encode("mimamima");
//        SqlSession sqlSession = sqlSessionFactory.openSession() ;  // 用工厂模式生产 SqlSession
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class) ;
//        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        UserResult userResult = userMapper.getUser(new UserParam(username));
        return new User(username, userResult.getPassword(), true, true,
                true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_角色1,权限1"));
    }
}
