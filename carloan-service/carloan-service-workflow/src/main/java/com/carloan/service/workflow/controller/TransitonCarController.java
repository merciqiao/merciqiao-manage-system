package com.carloan.service.workflow.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.workflow.TransitionParam;
import com.carloan.service.workflow.carflow.creditaudit.TransitionCarCreditAudit;
import com.carloan.service.workflow.carflow.measureprice.TransitionCarMeasurePrice;
import com.carloan.service.workflow.carflow.reconsiderncase.TransitionCarReconsidernCase;
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
@Api(tags = {"流程流转接口-qiaolixue"})
/**
 * 车贷流转控制器类
 */
public class TransitonCarController {
    @Autowired
    TransitionCarCreditAudit transitionCarCreditAudit;
    @Autowired
    TransitionCarMeasurePrice transitionCarMeasurePrice;
    @Autowired
    TransitionCarReconsidernCase transitionCarReconsidernCase;

    /**
     * 流转--信审
     * @param taskId 流程实例id
     * @param variables 参数扩展字段(暂时不用)
     * @param type 流转类型
     * @return
     * @throws Exception
     */
    @ApiOperation(value="信审流转",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/doTransition_XinShen",method = RequestMethod.POST)
    public Response doTransition_XinShen(@RequestBody TransitionParam transitionParam) throws Exception{
        Response response=new Response();
        try{
            boolean isSuccess=false;
            String taskId=transitionParam.getTaskId();
            String type=transitionParam.getType();
            Map<String,Object> variables =transitionParam.getVariables();
            switch (type){
                case "审核同意":
                    isSuccess= transitionCarCreditAudit.agree_shenhe(taskId,variables);
                    break;
                case "复核同意":
                    isSuccess= transitionCarCreditAudit.agree_fuhe(taskId,variables);
                    break;
                case "审核拒绝":
                    isSuccess= transitionCarCreditAudit.refuse_shenhe(taskId,variables);
                    break;
                case "复核拒绝":
                    isSuccess= transitionCarCreditAudit.refuse_fuhe(taskId,variables);
                    break;
                case "疑似欺诈":
                    isSuccess= transitionCarCreditAudit.likeAntiFraud(taskId,variables);
                    break;
                case "回退补件":
                    isSuccess= transitionCarCreditAudit.rollBack_bujian(taskId,variables);
                    break;
                case "回退审核":
                    isSuccess= transitionCarCreditAudit.rollBack_shenhe(taskId,variables);
                    break;
                case "回退复核":
                    isSuccess= transitionCarCreditAudit.rollBack_fuhe(taskId,variables);
                    break;
                case "补件":
                    isSuccess= transitionCarCreditAudit.attach(taskId,variables);
                    break;
                case "非欺诈":
                    isSuccess= transitionCarCreditAudit.notAntiFraud(taskId,variables);
                    break;
                case "欺诈":
                    isSuccess= transitionCarCreditAudit.antiFraud(taskId,variables);
                    break;
                default:
                    isSuccess= false;
            }
            if(isSuccess){
                response.setStatus(Status.SUCCESS);
                response.setMessage("执行成功");
            }
            else{
                log.error("doTransition_XinShen.error,param:",transitionParam.toString());
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
     * 流转--定价
     * @param taskId 流程实例id
     * @param variables
     * @param type 流转类型
     * @return
     * @throws Exception
     */
    @ApiOperation(value="定价流转",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/doTransition_DingJia",method = RequestMethod.POST)
    public Response doTransition_DingJia(@RequestBody TransitionParam transitionParam) throws Exception{
        Response response=new Response();
        try{
            boolean isSuccess=false;
            String taskId=transitionParam.getTaskId();
            String type=transitionParam.getType();
            Map<String,Object> variables =transitionParam.getVariables();
            switch (type){
                case "同意":
                    isSuccess= transitionCarMeasurePrice.agree(taskId,variables);
                    break;
                case "拒绝":
                    isSuccess= transitionCarMeasurePrice.refuse(taskId,variables);
                    break;
                case "回退":
                    isSuccess= transitionCarMeasurePrice.rollBack(taskId,variables);
                    break;
                case "补件":
                    isSuccess= transitionCarMeasurePrice.attach(taskId,variables);
                    break;
                default:
                    isSuccess= false;
            }
            if(isSuccess){
                response.setStatus(Status.SUCCESS);
                response.setMessage("执行成功");
            }
            else{
                response.setStatus(Status.FAILED);
                response.setMessage("执行失败");
                log.error("doTransition_DingJia.error,param:",transitionParam.toString());
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
     * 流转-复议
     * @param taskId 流程实例id
     * @param variables
     * @param type 流转类型
     * @return
     * @throws Exception
     */
    @ApiOperation(value="复议流转",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/doTransition_FuYi",method = RequestMethod.POST)
    public Response doTransition_FuYi(@RequestBody TransitionParam transitionParam) throws Exception{
        Response response=new Response();
        try{
            boolean isSuccess=false;
            String taskId=transitionParam.getTaskId();
            String type=transitionParam.getType();
            Map<String,Object> variables =transitionParam.getVariables();
            switch (type){
                case "同意":
                    isSuccess= transitionCarReconsidernCase.agree(taskId,variables);
                    break;
                case "拒绝":
                    isSuccess= transitionCarReconsidernCase.refuse(taskId,variables);
                    break;
                default:
                    isSuccess= false;
            }
            if(isSuccess){
                response.setStatus(Status.SUCCESS);
                response.setMessage("执行成功");
            }
            else{
                response.setStatus(Status.FAILED);
                response.setMessage("执行失败");
                log.error("doTransition_FuYi.error,param:",transitionParam.toString());
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
     * 信审--补件流转,根据订单号
     * @param orderNum
     * @return
     * @throws Exception
     */
    @ApiOperation(value="信审流转--补件",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/doTransition_XinShen_Attach",method = RequestMethod.POST)
    public Response doTransition_XinShen_Attach(@RequestBody TransitionParam transitionParam) throws Exception{
        Response response=new Response();
        try{
            boolean isSuccess=false;
            String orderNum=transitionParam.getOrderNum();
            isSuccess= transitionCarCreditAudit.attach(orderNum);
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
    @ApiOperation(value="定价流转--补件",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/doTransition_DingJia_Attach",method = RequestMethod.POST)
    public Response doTransition_DingJia_Attach(@RequestBody TransitionParam transitionParam) throws Exception{
        Response response=new Response();
        try{
            boolean isSuccess=false;
            String orderNum=transitionParam.getOrderNum();
            isSuccess= transitionCarMeasurePrice.attach(orderNum);
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
