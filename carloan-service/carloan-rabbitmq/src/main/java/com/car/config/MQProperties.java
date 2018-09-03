package com.car.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: MQProperties
 * @description:
 * @date 2018/6/22：13:14
 */
@Component
@Data
@ConfigurationProperties(prefix = MQProperties.MQCONFIG_PREFIX)
public class MQProperties {
    public static final String MQCONFIG_PREFIX = "spring.rabbitmq";
    private String car_host;
    private String car_port;
    private String car_username;
    private String car_password;
    private String car_vhost;
    private String car_exchange;
    private String car_routingkey;
    private String car_queuename;
    private String car_put_routingkey;
}
