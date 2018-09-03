package com.car.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: RabbitMQ_Queue
 * @description:
 * @date 2018/6/22：13:09
 */
@Configuration
@Component
public class RabbitMQQueue extends RabbitConfig{
    Logger logger = LoggerFactory.getLogger(RabbitMQQueue.class);

    public RabbitMQQueue(){
        logger.info("############### RabbitMQ Queue 创建 ###############");
    }



    @Bean
    public Queue CreationCarQueue() {
        logger.info("创建队列：{}", mqProperties.getCar_queuename());
        return new Queue(mqProperties.getCar_queuename());
    }



    @Bean
    public Binding binding() {
        logger.info("绑定队列，exchange:{},routingKey:{},queueName:{}", mqProperties.getCar_exchange(), mqProperties.getCar_routingkey(), mqProperties.getCar_queuename());
        return BindingBuilder.bind(CreationCarQueue()).to(defaultExchange()).with(mqProperties.getCar_routingkey());
    }
}
