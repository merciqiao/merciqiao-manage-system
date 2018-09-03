package com.carloan.service.workflow;

import com.carloan.common.web.ApplicationBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by MMM on 2018/06/14.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
        "com.carloan.service.workflow",
        "com.carloan.common.web",
        "com.carloan.common.config",
        "com.carloan.feign.activity",
        "com.carloan.feign.info"
                              })

@MapperScan("com.carloan.service.quartzjob.*.dao")
@EnableFeignClients(basePackages = {"com.carloan.feign"})
public class Application extends ApplicationBase {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
