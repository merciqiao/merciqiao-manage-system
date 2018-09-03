package com.carloan.service.workflow.carflow.reconsiderncase.eventlistener;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MMM on 2018/06/01.
 * 车贷复议--更新业务流程状态
 */
@Component
@Slf4j
public class CarReconsidernCaseUpdateStateService extends EventStartCarBase{
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
            taskEventParam.setOrderTypeName("车贷复议");
            taskEventParam.setOrderTypeCode(CarFlowConst.CAR_TASKTYPE_FUYI);
            //执行更新订单状态
            log.info(MessageFormat.format("1.updateOrderState.fuyi.prepare,orderid:{0},state:{1}",orderId,auditState));
                Response result=jbpm4TaskServicefeign.UpdateOrderState(taskEventParam);
                if(Response.isSucess(result)){
                    log.info(MessageFormat.format("2.updateOrderState.fuyi.sucess,taskEventParam:{0}",taskEventParam.toString()));
                    return true;
                }
                else{
                    String msg=MessageFormat.format("2-2.updateOrderState.fuyi.error,taskEventParam:{0}",taskEventParam.toString());
                    log.error(msg);
                    throw new Exception(msg);
                }
        }
        catch (Exception ex){
            log.error("3-3.updateOrderState.fuyi.error");
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
        //如果是开始复议
        if(CarTransitionConst.CONST_FUYI_TURNDIR_START.equals(transition)){
            //定价审核中-审核中
            auditState= CarOrderState.FUYI_STATE_FUYI.getKey();
        }
        else if(CarTransitionConst.CONST_FUYI_TURNDIR_AGREE.equals(transition)){
            //审核结束-复议同意
            auditState=CarOrderState.FUYI_STATE_YISIQIZHA.getKey();
        }
        else if(CarTransitionConst.CONST_FUYI_TURNDIR_REFUSE.equals(transition)){
            //审核结束-复议拒绝
            auditState=CarOrderState.FUYI_STATE_QIZHAJUJUE.getKey();
        }

        return auditState;
    }

}
