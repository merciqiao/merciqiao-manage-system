package com.carloan.service.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by MMM on 2018/06/14.
 */



@EnableEurekaClient
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
@ComponentScan(basePackages = {
        "com.carloan.service.activiti",
        "com.carloan.common.web",
        "com.carloan.common.config",
        "com.carloan.feign.workflow",
        "com.carloan.common.utils"

})
@EnableFeignClients(basePackages = {"com.carloan.feign"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
