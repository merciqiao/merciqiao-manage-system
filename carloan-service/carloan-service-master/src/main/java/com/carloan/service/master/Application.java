package com.carloan.service.master;

import com.carloan.common.web.ApplicationBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by MMM on 2018/06/14.
 */

@ComponentScan(basePackages = {
        "com.carloan.service.master",
        "com.carloan.common.web",
        "com.carloan.common.config",
        "com.carloan.apimodel.master"

})
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.carloan.service.master.*.dao")
public class Application extends ApplicationBase {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
