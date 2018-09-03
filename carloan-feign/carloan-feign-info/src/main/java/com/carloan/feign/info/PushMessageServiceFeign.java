package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: PushMessageServiceFeign
 * @description:
 * @date 2018/7/9：15:45
 */
@FeignClient(value = "carloan-service-info",path = "/PushMessageRest-api" ,fallback = PushMessageServiceHystrix.class)
public interface PushMessageServiceFeign  {
    /**
     * 推送消息
     * @param orderNumber 订单编号
     * @param status 推送状态(301：定价车辆补件，304：定价审核同意，305：定价审核同意)
     * @param status 推送状态(401：客户信息补件，403：客户信息审核同意，404：户信息审核拒绝，406：复议审核同意，407：复议审核拒绝，408：反欺诈审核拒绝)
     */
    @RequestMapping(value = "/Stateofjudgment", method = RequestMethod.POST)
    ResponseResult Stateofjudgment(@RequestParam("orderNumber") String orderNumber, @RequestParam("status") String status);

}
