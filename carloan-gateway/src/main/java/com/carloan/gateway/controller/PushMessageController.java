package com.carloan.gateway.controller;

import com.carloan.apimodel.order.CarLoanLogDTO;
import com.carloan.feign.info.InserttheorderServiceFeign;
import com.carloan.feign.info.PushMessageServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: PushMessageController
 * @description:
 * @date 2018/8/7：9:25
 */
@RestController
@RequestMapping("/PushMessage-api")
@Api(tags = {"消息执行-zhouzhiwei"})
@Slf4j
public class PushMessageController {

    @Autowired
    private PushMessageServiceFeign pushMessageerviceFeign;
    @Autowired
    private InserttheorderServiceFeign inserttheorderServiceFeign;

    @RequestMapping(value = "/Stateofjudgment", method = RequestMethod.POST)
    @ApiOperation(value = "根据订单编号,状态推送消息", notes = "301：定价车辆补件，304：定价审核同意，305：定价审核同意，401：客户信息补件，403：客户信息审核同意，404：户信息审核拒绝，406：复议审核同意，407：复议审核拒绝，408：反欺诈审核拒绝", httpMethod = "GET")
    public void Stateofjudgment(@RequestBody CarLoanLogDTO carLoanLogDTO){
        pushMessageerviceFeign.Stateofjudgment(carLoanLogDTO.getOrderNumber(),carLoanLogDTO.getStatus());
    }


    @RequestMapping(value = "/insertInfo", method = RequestMethod.POST)
    @ApiOperation(value = "执行报文" ,httpMethod = "POST")
    public void insertInfo(@RequestBody CarLoanLogDTO carLoanLogDTO){
        this.inserttheorderServiceFeign.insertInfo(carLoanLogDTO.getReqjson());
    }



}
