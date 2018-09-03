package com.carloan.service.workflow.controller;


import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.service.workflow.carflow.creditaudit.StartFlowCarCreditAuditService;
import com.carloan.service.workflow.carflow.measureprice.StartFlowCarMeasurePriceService;
import com.carloan.service.workflow.carflow.reconsiderncase.StartFlowCarReconsidernCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/workflow-api")
@Slf4j
@Component
@Api(tags = {"发起工作流接口-qiaolixue"})
public class StartFlowController {
    @Autowired
    StartFlowCarCreditAuditService startFlowCarCreditAuditService;
    @Autowired
    StartFlowCarMeasurePriceService startFlowCarMeasurePriceService;
    @Autowired
    StartFlowCarReconsidernCaseService startFlowCarReconsidernCaseService;

    @ApiOperation(value="发起车贷信审流程",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/startProcessByOrderId_XinShen",method = RequestMethod.POST)
    public Response startProcessByOrderId_XinShen(@RequestParam String orderId){
        Response response=new Response();
        try {
            boolean isSuccess= startFlowCarCreditAuditService.startProcessByOrderId(orderId);
            if(isSuccess){
                response.setStatus(Status.SUCCESS);
                response.setMessage("执行成功");
            }
            else{
                response.setStatus(Status.FAILED);
                response.setMessage("执行失败");
            }
            return response;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            response.setStatus(Status.FAILED);
            response.setMessage("执行失败");
            return response;
        }
    }

    @ApiOperation(value="发起车贷定价流程",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/startProcessByOrderId_DingJia",method = RequestMethod.POST)
    public Response startProcessByOrderId_DingJia(@RequestParam String orderId){
        Response response=new Response();
        try {
            boolean isSuccess= startFlowCarMeasurePriceService.startProcessByOrderId(orderId);
            if(isSuccess){
                response.setStatus(Status.SUCCESS);
                response.setMessage("执行成功");
            }
            else{
                response.setStatus(Status.FAILED);
                response.setMessage("执行失败");
            }
            return response;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            response.setStatus(Status.FAILED);
            response.setMessage("执行失败");
            return response;
        }
    }
    @ApiOperation(value="发起车贷复议流程",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/startProcessByOrderId_FuYi",method = RequestMethod.POST)
    public Response startProcessByOrderId_FuYi(@RequestParam String orderId){
        Response response=new Response();
        try {
            boolean isSuccess= startFlowCarReconsidernCaseService.startProcessByOrderId(orderId);
            if(isSuccess){
                response.setStatus(Status.SUCCESS);
                response.setMessage("执行成功");
            }
            else{
                response.setStatus(Status.FAILED);
                response.setMessage("执行失败");
            }
            return response;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            response.setStatus(Status.FAILED);
            response.setMessage("执行失败");
            return response;
        }
    }
}
