package com.carloan.service.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableEurekaClient
@ComponentScan(basePackages = {
		"com.carloan.service.admin",
		"com.carloan.common.web",
		"com.carloan.common.config",
		"com.carloan.common.utils"
})

@MapperScan("com.carloan.service.admin.*.dao")
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
