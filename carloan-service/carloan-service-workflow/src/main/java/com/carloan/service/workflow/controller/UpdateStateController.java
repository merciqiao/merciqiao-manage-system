package com.carloan.service.workflow.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.workflow.TaskEventParam;
import com.carloan.service.workflow.carflow.creditaudit.eventlistener.CarCreditAuditUpdateStateService;
import com.carloan.service.workflow.carflow.measureprice.eventlistener.CarMeasurePriceUpdateStateService;
import com.carloan.service.workflow.carflow.reconsiderncase.eventlistener.CarReconsidernCaseUpdateStateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/workflow-api")
@Slf4j
@Component
@Api(tags = {"流程流转更新订单状态接口-qiaolixue"})
public class UpdateStateController {

    @Autowired
    CarCreditAuditUpdateStateService carCreditAuditUpdateStateService;

    @Autowired
    CarMeasurePriceUpdateStateService carMeasurePriceUpdateStateService;

    @Autowired
    CarReconsidernCaseUpdateStateService carReconsidernCaseUpdateStateService;
    /**
     * 信审
     * @param taskEventParam
     * @return
     */
    @ApiOperation(value="信审更新订单状态",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateState_XinShen",method = RequestMethod.POST)
    public Response updateOrderState_XinShen(@RequestBody TaskEventParam taskEventParam){
        Response response=new Response();
        try {
            boolean isSuccess=false;
            isSuccess= carCreditAuditUpdateStateService.updateOrderState(taskEventParam);
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
    /**
     * 定价
     * @param taskEventParam
     * @return
     */
    @ApiOperation(value="定价更新订单状态",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateOrderState_DingJia",method = RequestMethod.POST)
    public Response updateOrderState_DingJia(@RequestBody TaskEventParam taskEventParam){
        Response response=new Response();
        try {
            boolean isSuccess=false;
            isSuccess= carMeasurePriceUpdateStateService.updateOrderState(taskEventParam);
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
    /**
     * 定价
     * @param taskEventParam
     * @return
     */
    @ApiOperation(value="复议更新订单状态",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateOrderState_FuYi",method = RequestMethod.POST)
    public Response updateOrderState_FuYi(@RequestBody TaskEventParam taskEventParam){
        Response response=new Response();
        try {
            boolean isSuccess=false;
            isSuccess= carReconsidernCaseUpdateStateService.updateOrderState(taskEventParam);
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
