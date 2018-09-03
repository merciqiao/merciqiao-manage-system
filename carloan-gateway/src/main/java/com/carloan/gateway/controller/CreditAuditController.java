package com.carloan.gateway.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.*;

import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.workflow.TransitionParam;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.common.shiro.MyShiroRealm;
import com.carloan.feign.info.CarLoanOpinionServicefeign;
import com.carloan.feign.info.CarLoanPriceServicefeign;
import com.carloan.feign.info.CarLoanReconsiderationServicefeign;
import com.carloan.feign.info.Jbpm4HistTaskServicefeign;
import com.carloan.feign.workflow.WorkFlowFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/2.
 */
@RestController
@RequestMapping(value="/creditaudit-api")
@Slf4j
@Api(tags = {"定价、审核接口-hanxiaoyan"})
public class CreditAuditController {
    @Autowired
    private CarLoanPriceServicefeign carLoanPricefeiservice;
    @Autowired
    private CarLoanOpinionServicefeign carLoanOpinionfeiservice;
    @Autowired
    private WorkFlowFeign workFlowfeiService;
    @Autowired
    private Jbpm4HistTaskServicefeign histTaskfeiservice;

    @Autowired
    private CarLoanReconsiderationServicefeign reconsiderationFeiservice;

    @ApiOperation(value = "查询定价信息", notes = "返回结果,SUCCESS:100,FAILED:200", httpMethod = "GET")
    @RequestMapping(value = "/queryLoanPriceByParam", method = RequestMethod.GET)
    public ResponseResult<Object> queryLoanPriceByOrderNum(@RequestParam("ordernum") String ordernum,@RequestParam("status") String status) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = carLoanPricefeiservice.queryLoanPriceinfo(ordernum,status);
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @ApiOperation(value = "新增定价信息", notes = "返回结果,SUCCESS:100,FAILED:200", httpMethod = "POST")
    @RequestMapping(value = "/saveLoanPrice", method = RequestMethod.POST)
    public ResponseResult<Object> saveLoanPrice(@RequestBody CarLoanPriceVo vo) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            if(vo != null || vo.getId() ==null)
            {
                result.setStatus(Status.FAILED);
                result.setMessage("执行异常,参数不完整");
            }
            UserInfo curuser= MyShiroRealm.getUserInfo();
            vo.setCurrentApprover(curuser.getUserId().toString());
            String conclusion =vo.getPricingConclusion();
            if(conclusion.equals("同意"))
            {
                vo.setAuditState(CarAuditState.CAR_AUDIT_2200.getKey());
                vo.setTransition("同意");
            }
            else  if(conclusion.equals("拒绝"))
            {
                vo.setAuditState(CarAuditState.CAR_AUDIT_2700.getKey());
                vo.setTransition("拒绝");
            }
            else  if(conclusion.equals("补件"))
            {
                vo.setAuditState(CarAuditState.CAR_AUDIT_2100.getKey());
                vo.setTransition("回退");
            }
            return carLoanPricefeiservice.addCarLoanPrice(vo);

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @ApiOperation(value = "查询审核信息", notes = "返回结果,SUCCESS:100,FAILED:200", httpMethod = "GET")
    @RequestMapping(value = "/queryLoanOpinionByParam", method = RequestMethod.GET)
    public ResponseResult<Object> queryLoanOpinionByOrderNum(@RequestParam("ordernum") String ordernum,@RequestParam("actName") String actName,@RequestParam("status") String status) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = carLoanOpinionfeiservice.queryLikeCarLoanOpinion(ordernum,actName,status);
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @ApiOperation(value = "新增审核信息", notes = "返回结果,SUCCESS:100,FAILED:200", httpMethod = "POST")
    @RequestMapping(value = "/saveLoanOpinion", method = RequestMethod.POST)
    public ResponseResult<Object> saveLoanOpinion(@RequestBody CarLoanOpinionVo vo) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            if(vo==null||vo.getId()==null)
            {
                result.setStatus(Status.FAILED);
                result.setMessage("参数不完整");
                return result;
            }
            UserInfo curuser= MyShiroRealm.getUserInfo();
            vo.setCurrentApprover(curuser.getUserId().toString());
            String conclusion =vo.getTransition();
            String transition="";
            String auditstate="";
            if(vo.getBizType().toString().equals(CarFlowConst.CAR_TASKTYPE_XINSHEN)) {
                if (conclusion.equals("同意")) {

                    auditstate=CarAuditState.CAR_AUDIT_3100.getKey();
                    transition = vo.getCurrentExaminationPost() + "同意";
                } else if (conclusion.equals("拒绝")) {
                    auditstate=CarAuditState.CAR_AUDIT_3300.getKey();
                    transition = vo.getCurrentExaminationPost() + "拒绝";
                } else if (conclusion.equals("补件")) {
                    auditstate=CarAuditState.CAR_AUDIT_2400.getKey();
                    transition = "回退补件";
                } else if (conclusion.equals("补充调查")) {
                    auditstate=CarAuditState.CAR_AUDIT_2300.getKey();
                    transition = "回退初审";
                }
                else if (conclusion.equals("疑似欺诈")) {
                    auditstate=CarAuditState.CAR_AUDIT_2300.getKey();
                    transition = "疑似欺诈";
                }
            }
            else if(vo.getBizType().toString().equals(CarFlowConst.CAR_TASKTYPE_FUYI)) {
                if (conclusion.equals("同意")) {
                    auditstate=CarAuditState.CAR_AUDIT_3500.getKey();
                    transition ="同意";
                } else if (conclusion.equals("拒绝")) {
                    auditstate=CarAuditState.CAR_AUDIT_3600.getKey();
                    transition = "拒绝";
                }
            }
            vo.setAuditState(auditstate);
            vo.setTransition1(transition);
            result= carLoanOpinionfeiservice.insertCarLoanOpinion(vo);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @ApiOperation(value = "获取页面展示tabs页签", notes = "测试参数 biztype 3000，actName 审核 返回结果,SUCCESS:100,FAILED:200", httpMethod = "POST")
    @RequestMapping(value = "/getAuditTabs", method = RequestMethod.POST)
    public ResponseResult<Object> getAuditTabs(@RequestParam("biztype") String biztype, @RequestParam("actName") String actName, @RequestParam("statusId") String statusId) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        Map<String, String> tabs = new HashMap<String, String>();
        tabs.put(AuditTabs.logInfoObj, "false");
        tabs.put(AuditTabs.carInfoObj, "false");
        try {
            if (CarFlowConst.CAR_TASKTYPE_XINSHEN.equals(biztype)) {
                tabs.put(AuditTabs.customerInfoObj, "false");
                tabs.put(AuditTabs.matchInfoObj, "false");
                tabs.put(AuditTabs.auditCarPriceObj, "false");
                if ((actName.equals("审核") || actName.equals("复核")) && statusId.equals("1")) {
                    tabs.put(AuditTabs.surveyInfoObj, "true");
                    tabs.put(AuditTabs.auditInfoObj, "true");
                    tabs.put(AuditTabs.antiFraudObj, "false");
                } else if (actName.equals("反欺诈") && statusId.equals("1")) {
                    tabs.put(AuditTabs.surveyInfoObj, "false");
                    tabs.put(AuditTabs.auditInfoObj, "false");
                    tabs.put(AuditTabs.antiFraudObj, "true");
                } else {
                    tabs.put(AuditTabs.surveyInfoObj, "false");
                    tabs.put(AuditTabs.auditInfoObj, "false");
                    tabs.put(AuditTabs.antiFraudObj, "false");
                }
            } else if (CarFlowConst.CAR_TASKTYPE_DINGJIA.equals(biztype)) {
                if (actName.equals("定价") && statusId.equals("1")) {
                    tabs.put(AuditTabs.auditCarPriceObj, "true");
                } else {
                    tabs.put(AuditTabs.auditCarPriceObj, "false");
                }
            } else if (CarFlowConst.CAR_TASKTYPE_FUYI.equals(biztype)) {

                tabs.put(AuditTabs.customerInfoObj, "false");
                tabs.put(AuditTabs.matchInfoObj, "false");
                tabs.put(AuditTabs.surveyInfoObj, "false");
                tabs.put(AuditTabs.auditCarPriceObj, "false");
                tabs.put(AuditTabs.antiFraudObj, "false");
                if (actName.equals("复议") && statusId.equals("1")) {
                    tabs.put(AuditTabs.custorReconsiderObj, "false");
                    tabs.put(AuditTabs.auditInfoObj, "true");
                } else {
                    tabs.put(AuditTabs.custorReconsiderObj, "false");
                    tabs.put(AuditTabs.auditInfoObj, "false");
                }
            }
            result.setData(tabs);
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @ApiOperation(value = "获取审核历史记录", notes = " ordernum 订单编号 返回结果,SUCCESS:100,FAILED:200", httpMethod = "GET")
    @RequestMapping(value = "/getAuditHistoryLogs", method = RequestMethod.GET)
    public ResponseResult<Object> getAuditHistoryLogs(@RequestParam("ordernum") String ordernum) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result=histTaskfeiservice.searchHistTaskByOrdernum(ordernum);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }

    }
    @ApiOperation(value = "获取复议信息", notes = " ordernum 订单编号 返回结果,SUCCESS:100,FAILED:200", httpMethod = "GET")
    @RequestMapping(value = "/getFuyiInfoByorderNum", method = RequestMethod.GET)
    public ResponseResult<Object> getFuyiInfoByorderNum(@RequestParam("ordernum") String ordernum) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result=reconsiderationFeiservice.getCarLoanReconsiderationList(ordernum);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }

    }


}
