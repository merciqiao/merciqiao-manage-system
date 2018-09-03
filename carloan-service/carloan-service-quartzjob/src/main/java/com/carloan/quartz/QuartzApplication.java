package com.carloan.quartz;

import com.carloan.common.web.ApplicationBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by MMM on 2018/06/14.
 */
@SpringBootApplication(scanBasePackages = {"com.carloan.quartz", "com.carloan.common.web",
        "com.carloan.feign.info", "com.carloan.common.redisTemplate"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.carloan.feign.info"})
@MapperScan(basePackages = "com.carloan.quartz.dao")
public class QuartzApplication extends ApplicationBase {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }
}
