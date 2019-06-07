package com.xianqingzao.yequxiaoquan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan("com.xianqingzao.yequxiaoquan.dao")
public class YequxiaoquanApplication {

	public static void main(String[] args) {
		SpringApplication.run(YequxiaoquanApplication.class, args);
	}

}
