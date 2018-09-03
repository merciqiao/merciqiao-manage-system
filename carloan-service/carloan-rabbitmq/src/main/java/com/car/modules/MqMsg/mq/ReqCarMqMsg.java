
package com.car.modules.MqMsg.mq;


import com.car.modules.MqMsg.util.FormatUtil;
import com.carloan.feign.info.InserttheorderServiceFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;


/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ReqCarMqMsg
 * @description:
 * @date 2018/5/28：10:50
 */

@Component
public class ReqCarMqMsg{

    private Logger logger = LoggerFactory.getLogger(ReqCarMqMsg.class);

    @Autowired
    InserttheorderServiceFeign inserttheorderServiceFeign;

    @RabbitListener(queues = "${spring.rabbitmq.car_queuename}", containerFactory = "rabbitListenerContainerFactory")
    public void process(@Payload byte[] bytes) throws UnsupportedEncodingException {
        String result = null;
        try {
            result = new String(bytes, "UTF8");
            inserttheorderServiceFeign.insertInfo(result);
            logger.info("\n监听到消息==========="+ FormatUtil.formatJson(result));
        } catch (UnsupportedEncodingException e) {
            logger.error("监听车贷门店Mq: insuranceTrial UnsupportedEncodingException error :{}",e);
        } catch (Exception e){
            logger.error("监听车贷门店Mq: insuranceTrial Exception error :{}",e);
        }
    }
}

