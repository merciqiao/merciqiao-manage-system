package com.carloan.service.workflow.carflow.creditaudit.eventlistener;


import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.order.CarLoanInfoParam;
import com.carloan.apimodel.workflow.TaskEventParam;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.apimodel.workflow.common.CarOrderState;
import com.carloan.apimodel.workflow.common.CarTransitionConst;
import com.carloan.feign.info.CarLoanInfoServiceFeign;
import com.carloan.feign.info.Jbpm4TaskServicefeign;
import com.carloan.service.workflow.carflow.EventStartCarBase;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MMM on 2018/06/01.
 * 车贷信审--更新业务流程状态
 */
@Component
@Slf4j
public class CarCreditAuditUpdateStateService extends EventStartCarBase{

    @Autowired
    CarLoanInfoServiceFeign carLoanInfoServiceFeign;
    @Autowired
    Jbpm4TaskServicefeign jbpm4TaskServicefeign;
    /**
     * 更新进件状态
     * @param taskEventParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateOrderState(TaskEventParam taskEventParam) throws Exception{
        try {

            Map<String, Object> variables=new HashMap<>();
            variables=taskEventParam.getVariables();

            Long orderId=Long.parseLong(variables.get("orderid").toString());
            String transition= (String)variables.get("transition");

            String auditState = this.getAuditType(transition);
            CarLoanInfoParam carLoanInfoParam=new CarLoanInfoParam();
            carLoanInfoParam.setId(orderId);
            carLoanInfoParam.setAuditeState(auditState);

            taskEventParam.setOrderId(orderId.toString());
            taskEventParam.setAuditState(auditState);
            taskEventParam.setOrderTypeName("车贷信审");
            taskEventParam.setOrderTypeCode(CarFlowConst.CAR_TASKTYPE_XINSHEN);
            log.info(MessageFormat.format("1.updateOrderState.xinshen.prepare,orderid:{0},state:{1}",orderId,auditState));
                Response result= jbpm4TaskServicefeign.UpdateOrderState(taskEventParam);
                if(Response.isSucess(result)){
                    log.info(MessageFormat.format("2.updateOrderState.xinshen.sucess,taskEventParam:{0}",taskEventParam.toString()));
                    return true;
                }
                else{
                    String msg=MessageFormat.format("2-2.updateOrderState.xinshen.error,taskEventParam:{0}",taskEventParam.toString());
                    log.error(msg);
                    throw new Exception(msg);
                }
        }
        catch (Exception ex){
            log.error("3-3.updateOrderState.xinshen.error");
            log.error(ex.getMessage()+MessageFormat.format("updateOrderState.error," +
                    "taskEventParam:{0}",taskEventParam.toString()));
            throw ex;
        }
    }



    /**
     * 根据流转名称获取审核状态
     * @param transition
     * @return
     */
    private String getAuditType(String transition){
        String auditState="";
        //如果是开始审核
        if(CarTransitionConst.CONST_XINSHEN_TURNDIR_START.equals(transition)){
            //审核中-审核中
            auditState= CarOrderState.XINSHEN_STATE_SHENHE.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_AGREE_SHENHE.equals(transition)){
            //审核结束-同意
            auditState=CarOrderState.XINSHEN_STATE_SHENHE.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_AGREE_FUHE.equals(transition)){
            //审核结束-同意
            auditState=CarOrderState.XINSHEN_STATE_TONGYI.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_REFUSE_SHENHE.equals(transition)){
            //审核中-审核中
            auditState=CarOrderState.XINSHEN_STATE_SHENHE.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_REFUSE_FUHE.equals(transition)){
            //审核结束-拒绝
            auditState=CarOrderState.XINSHEN_STATE_JUJUE.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_LILEANTIFRAUD.equals(transition)){
            //审核中-疑似欺诈
            auditState=CarOrderState.XINSHEN_STATE_YISIQIZHA.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_ROLLBACK_BUJIAN.equals(transition)){
            //审核中-补件
            auditState=CarOrderState.XINSHEN_STATE_BUJIAN.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_ROLLBACK_SHENHE.equals(transition)){
            //审核中-审核中
            auditState=CarOrderState.XINSHEN_STATE_SHENHE.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_ROLLBACK_FUHE.equals(transition)){
            //审核中-复核中
            auditState=CarOrderState.XINSHEN_STATE_SHENHE.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_ATTACH.equals(transition)){
            //审核中-审核中
            auditState=CarOrderState.XINSHEN_STATE_SHENHE.getKey();
        }
        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_NOTANTIFRAUD.equals(transition)){
            //审核中-审核中
            auditState=CarOrderState.XINSHEN_STATE_SHENHE.getKey();
        }

        else if(CarTransitionConst.CONST_XINSHEN_TURNDIR_ANTIFRAUD.equals(transition)){
            //审核结束-欺诈拒绝
            auditState=CarOrderState.XINSHEN_STATE_QIZHAJUJUE.getKey();
        }
        return auditState;
    }

}
