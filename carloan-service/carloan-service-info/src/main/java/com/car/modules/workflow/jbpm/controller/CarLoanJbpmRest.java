package com.car.modules.workflow.jbpm.controller;

import com.car.modules.workflow.jbpm.service.JbpmService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.jbpm.ConsignTaskVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by zhangyl on 2018/7/30
 */
@RestController
@RequestMapping("jbpm")
@Api(tags = "流程相关-更新派单人")
public class CarLoanJbpmRest {
    @Autowired
    private JbpmService jbpmService;

    @ApiOperation(value = "更换派单人", notes = "application/json")
    @RequestMapping(value = "updateAssignee", method = RequestMethod.POST)
    public ResponseResult<Boolean> updateAssignee(@RequestBody @Valid ConsignTaskVO consignedTaskVO, BindingResult result) {
        jbpmService.updateAssignee(consignedTaskVO);
        return new ResponseResult<>();
    }

    @ApiOperation(value = "定时派单")
    @RequestMapping(value = "dispatchJob/{bizType}/{activityName}", method = RequestMethod.PUT)
    public ResponseResult<Boolean> dispatchJob(@PathVariable("bizType") String bizType, @PathVariable("activityName") String activityName) {
        jbpmService.dispatchJob(bizType,activityName);
        return new ResponseResult<>();
    }
}
