package com.jyblues.javamybatis2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.jyblues.javamybatis2.dto")
public class JavaMybatis2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaMybatis2Application.class, args);
	}

}
