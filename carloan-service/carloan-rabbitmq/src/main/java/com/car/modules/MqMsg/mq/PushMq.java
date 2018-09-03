package com.car.modules.MqMsg.mq;

import com.car.config.MQProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: PushMq
 * @description:
 * @date 2018/6/25：9:52
 */
@Component
public class PushMq {
    Logger logger = LoggerFactory.getLogger(PushMq.class);

    @Qualifier("firstRabbitTemplate")
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    public MQProperties mqProperties;

    public void pushmessage(String message){
        try{
            CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
            rabbitTemplate.convertAndSend(mqProperties.getCar_exchange(), mqProperties.getCar_put_routingkey(), message,correlationId);
            logger.info("推送消息：{}", message);
        }catch (Exception e){
            logger.error("推送异常：{}",e);
        }

    }
}
