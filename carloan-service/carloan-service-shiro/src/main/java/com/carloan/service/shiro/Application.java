package com.carloan.service.shiro;

import com.carloan.common.web.ApplicationBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by MMM on 2018/06/14.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
        "com.carloan.service.shiro",
        "com.carloan.common.web",
        "com.carloan.common.config",
        "com.carloan.common.utils"
                              })

@MapperScan("com.carloan.service.shiro.*.dao")
public class Application extends ApplicationBase {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
