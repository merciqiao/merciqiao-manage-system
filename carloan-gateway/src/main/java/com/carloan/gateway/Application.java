package com.carloan.gateway;

import com.carloan.common.web.ApplicationBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by MMM on 2018/06/14.
 */
@SpringBootApplication
@ComponentScan(value = {
        "com.carloan.gateway",
        "com.carloan.common.web",
        "com.carloan.feign",
        "com.carloan.common.shiro",
        "com.carloan.common.config",
        "com.carloan.api.model.admin",
        "com.carloan.common.restTemplate",
//        "com.carloan.common.redisTemplate",
        "com.carloan.common.utils"
})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.carloan.feign"})
@EnableHystrixDashboard
@EnableCircuitBreaker
public class Application extends ApplicationBase {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
