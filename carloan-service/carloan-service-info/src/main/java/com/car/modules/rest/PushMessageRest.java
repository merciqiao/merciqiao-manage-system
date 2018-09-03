package com.car.modules.rest;

import com.car.modules.service.PushCarPrice;
import com.car.modules.service.PushCarUserMsg;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.feign.admin.SysPushMqServicefeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: PushmessageRest
 * @description:
 * @date 2018/6/27：14:03
 */
@RestController
@RequestMapping(value = "/PushMessageRest-api")
@Slf4j
@Component
@Api(tags="根据进件编号，订单状态推送相应的消息到车贷")
public class PushMessageRest {
    @Autowired
    private PushCarPrice pushCarPrice;
    @Autowired
    private PushCarUserMsg pushCarUserMsg;



   @Autowired
   SysPushMqServicefeign sysPushMqServicefeign;


    @ApiOperation(value="推送审核信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/Stateofjudgment", method = RequestMethod.POST)
    public ResponseResult Stateofjudgment(@RequestParam String orderNumber, @RequestParam String status) {
        log.info("收到请求，进件编号{}，状态{}", orderNumber, status);
        ResponseResult responseResult = new ResponseResult();
        try {
            String[] carStatus = new String[]{"301", "304", "305"};
            String[] carUserStatus = new String[]{"401", "403", "404","406", "407", "408"};
            if (StringUtils.startsWithAny(status, carStatus)) {
                this.pushCarPrice.executeAsynJob(orderNumber, status);
            } else if (StringUtils.startsWithAny(status, carUserStatus)) {
                this.pushCarUserMsg.executeAsynJob(orderNumber, status);
            }
            responseResult.setMessage("执行成功");
            responseResult.setStatus(Status.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.setMessage("执行失败");
            responseResult.setStatus(Status.FAILED);
            responseResult.setData(e);
        }
        return responseResult;
    }

        @ApiOperation(value="推送报文",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
        @RequestMapping(value = "/putMq", method = RequestMethod.POST)
        public void putMq(@RequestParam String messageStr) {
           sysPushMqServicefeign.PushMqCarMessge(messageStr);
        }

    }
