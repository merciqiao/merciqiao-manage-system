package com.carloan.service.workflow.carflow.creditaudit;


import com.carloan.apimodel.activiti.dto.ActivitiInfoVO;
import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanInfoParam;
import com.carloan.apimodel.order.CarLoanInfoVo;
import com.carloan.apimodel.order.CarLoanUserVo;
import com.carloan.apimodel.order.Jbpm4BizTabParam;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.apimodel.workflow.common.CarTransitionConst;
import com.carloan.feign.activity.ActivityFeign;
import com.carloan.feign.info.CarLoanInfoServiceFeign;
import com.carloan.feign.info.CarLoanUserServiceFeign;
import com.carloan.feign.info.Jbpm4BizTabServiceFeign;
import com.carloan.service.workflow.carflow.StartFlowBaseService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;

/**
 * Created by MMM on 2018/05/26.
 * 车贷信审,流程异步启动类
 */
@Service
@Slf4j
public class StartFlowCarCreditAuditService  implements StartFlowBaseService {
    @Autowired
    ActivityFeign activityFeign;
    @Autowired
    Jbpm4BizTabServiceFeign jbpm4BizTabServiceFeign;
    @Autowired
    CarLoanInfoServiceFeign carLoanInfoServiceFeign;
    @Autowired
    CarLoanUserServiceFeign carLoanUserServiceFeign;
    @Autowired
    Mapper mapper;

    /**
     * 发起车贷信审流程
     *
     * @param orderId 进件id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean startProcessByOrderId(String orderId) {
        //判断流程是否已经发起
        Jbpm4BizTabParam jbpm4BizTabExistParam=new Jbpm4BizTabParam();
        jbpm4BizTabExistParam.setBizInfId(orderId);
        jbpm4BizTabExistParam.setBizType(CarFlowConst.CAR_TASKTYPE_XINSHEN);
        Response responseExist= jbpm4BizTabServiceFeign.findJbpm4BizTabExist(jbpm4BizTabExistParam);
        if(Response.isSucess(responseExist)){
            log.info(MessageFormat.format("startflow.xinshen.sucess.already,jbpm4BizTabParam:{0}",jbpm4BizTabExistParam.toString()));
            return true;
        }

        String processKey = "carCreditAuditKey";//流程编码

        ActivitiInfoVO activitiInfoVO = new ActivitiInfoVO();
        activitiInfoVO.setOrderid(orderId);
        activitiInfoVO.setTransition(CarTransitionConst.CONST_XINSHEN_TURNDIR_START);
        activitiInfoVO.setAssignee("-1");
        activitiInfoVO.setProcessKey(processKey);
        log.info(MessageFormat.format("********>>1.active start xinshen flow prepare,orderid:{0}",orderId));
        //发起流程
        ResponseResult<ActivitiInstanceInfoVO> result = activityFeign.startprocess(activitiInfoVO);
        if (ResponseResult.isSucess(result)&&result.getData()!=null) {
            log.info(MessageFormat.format("2.active start xinshen flow sucess,orderid:{0}",orderId));
            ActivitiInstanceInfoVO activitiInstanceInfoVO = result.getData();
            String processId = activitiInstanceInfoVO.getInstanceID();

            Jbpm4BizTabParam jbpm4BizTabParam=new Jbpm4BizTabParam();
            jbpm4BizTabParam.setId(Long.parseLong(orderId));
            jbpm4BizTabParam.setProInstanceId(processId);//流程id
            jbpm4BizTabParam.setBizType(CarFlowConst.CAR_TASKTYPE_XINSHEN);//订单类型(定价)
            log.info(MessageFormat.format("3.save xinshen jbpm4_biz_tab prepare,orderid:{0},taskid:{1}",orderId,processId));
            Response response= jbpm4BizTabServiceFeign.saveJbpm4BizTab(jbpm4BizTabParam);
            if(Response.isSucess(response)){
                log.info(MessageFormat.format("4.startflow.xinshen.sucess,jbpm4BizTabParam:{0}",jbpm4BizTabParam.toString()));
                return true;
            }
            else{
                log.error(MessageFormat.format("4-4.startProcessByOrderId.saveJbpm4BizTab.error,jbpm4BizTabParam:{0}",jbpm4BizTabParam.toString()));
                return false;
            }

        } else {
            log.error(MessageFormat.format("2-2.startProcessByOrderId.startprocess.error,orderid:{0}", orderId));
            return false;
        }

    }
}
