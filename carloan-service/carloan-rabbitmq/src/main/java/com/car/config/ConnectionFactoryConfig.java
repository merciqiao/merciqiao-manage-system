package com.car.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ConnectionFactoryConfig
 * @description:
 * @date 2018/6/22：11:30
 */
@Configuration
public class ConnectionFactoryConfig {
    @Bean(name="firstConnectionFactory")
    public ConnectionFactory firstConnectionFactory(@Value("${spring.rabbitmq.car_host}") String host,
                                                    @Value("${spring.rabbitmq.car_port}") int port,
                                                    @Value("${spring.rabbitmq.car_username}") String username,
                                                    @Value("${spring.rabbitmq.car_password}") String password,
                                                    @Value("${spring.rabbitmq.car_vhost}") String virtualhost
    ){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualhost);
        return connectionFactory;
    }
}
