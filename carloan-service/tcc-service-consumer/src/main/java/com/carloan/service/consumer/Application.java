package com.carloan.service.consumer;

import com.carloan.common.web.ApplicationBase;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by MMM on 2018/06/14.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
        "com.carloan.service.consumer",
        "com.carloan.common.web",
        "com.carloan.common.config",
        "com.carloan.feign.tcc",
                              })

@MapperScan("com.carloan.service.consumer.*.dao")
@EnableFeignClients(basePackages = {"com.carloan.feign"})
@ImportResource({ "classpath:bytetcc-supports-springcloud.xml" })
@Import(SpringCloudConfiguration.class)
public class Application extends ApplicationBase {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
