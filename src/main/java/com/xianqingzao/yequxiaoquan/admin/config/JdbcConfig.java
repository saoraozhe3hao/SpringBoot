package com.xianqingzao.yequxiaoquan.admin.config;

import com.xianqingzao.yequxiaoquan.admin.mapper.UserMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JdbcConfig {

    @Bean
    public BasicDataSource basicDataSource() {  // 数据源
        BasicDataSource basicDataSource =  new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/user");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("wowo000");
        return basicDataSource;
    }
}
