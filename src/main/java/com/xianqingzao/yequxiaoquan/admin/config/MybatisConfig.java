package com.xianqingzao.yequxiaoquan.admin.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan("com.xianqingzao.yequxiaoquan.admin.mapper")
public class MybatisConfig {
    @Autowired
    private BasicDataSource basicDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {  // 连接工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(basicDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    //    @Bean
//    public MapperFactoryBean mapperFactoryBean(){
//        MapperFactoryBean mapperFactoryBean =  new MapperFactoryBean();
//        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        mapperFactoryBean.setMapperInterface(UserMapper.class);
//        return mapperFactoryBean;
//    }
}
