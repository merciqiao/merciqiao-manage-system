package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.car.modules.loan",
		"com.car.modules.rest",
		"com.car.modules.jbpm",
		"com.car.modules.service",
		"com.car.modules.workflow",
		"com.carloan.common.config",
		"com.carloan.common.utils",
		"com.carloan.common.redisTemplate",
		"com.carloan.feign.workflow",
		"com.carloan.common.web"
})
@MapperScan({"com.car.modules.*.*.dao","com.car.modules.*.dao","com.car.modules.**.dao"})
@EnableFeignClients(basePackages = {"com.carloan.feign"})
@EnableEurekaClient
public class InfoApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfoApplication.class, args);
	}
}
