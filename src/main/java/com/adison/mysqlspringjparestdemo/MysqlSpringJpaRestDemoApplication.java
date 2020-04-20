package com.adison.mysqlspringjparestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers", "model", "repositories"})
public class MysqlSpringJpaRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlSpringJpaRestDemoApplication.class, args);
	}

}
