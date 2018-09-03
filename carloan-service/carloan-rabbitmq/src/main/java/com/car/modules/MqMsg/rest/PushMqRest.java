
package com.car.modules.MqMsg.rest;

import com.car.modules.MqMsg.mq.PushMq;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.feign.info.InserttheorderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: PushMqRest
 * @description:
 * @date 2018/5/31：15:43
 */

@RestController
@RequestMapping(value="/api/car")
public class PushMqRest  {

    @Autowired
    InserttheorderServiceFeign inserttheorderServiceFeign;
    @Autowired
    private PushMq pushMq;

/**
     * 手动推送与车贷交互任意报文
     * @param messageStr
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping(value = "/PushMqMessge", method = RequestMethod.GET)
    public ResponseResult<String> pushMqMessge(@RequestParam String messageStr){
        return inserttheorderServiceFeign.insertInfo(messageStr);
    }

    @ResponseBody
    @RequestMapping(value = "/PushMqCarMessge", method = RequestMethod.POST)
    public void PushMqCarMessge(@RequestParam String messageStr){
         pushMq.pushmessage(messageStr);
    }




}

