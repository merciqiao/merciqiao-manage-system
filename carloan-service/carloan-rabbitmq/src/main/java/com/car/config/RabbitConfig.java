package com.car.config;

import lombok.extern.java.Log;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: RabbitConfig
 * @description:
 * @date 2018/6/22：10:00
 */
@Configuration
@Log
public class RabbitConfig {
    @Qualifier("firstConnectionFactory")
    @Autowired
    public ConnectionFactory connectionFactory;

    @Autowired
    public MQProperties mqProperties;


    @Bean(name="firstRabbitTemplate")
    public RabbitTemplate firstRabbitTemplate(){
        log.info("########################初始化rabitTemplate################################");
        RabbitTemplate firstRabbitTemplate = new RabbitTemplate(connectionFactory);
        return firstRabbitTemplate;
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }


    @Bean
    public TopicExchange defaultExchange() {
        return new TopicExchange(mqProperties.getCar_exchange());
    }














}
