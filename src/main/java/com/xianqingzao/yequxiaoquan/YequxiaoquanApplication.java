package com.xianqingzao.yequxiaoquan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xianqingzao.yequxiaoquan.admin.mapper")
public class YequxiaoquanApplication {

	public static void main(String[] args) {
		SpringApplication.run(YequxiaoquanApplication.class, args);
	}

}
