package com.carloan.service.workflow.carflow.measureprice.eventlistener;


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
 * 车贷定价--更新业务流程状态
 */
@Component
@Slf4j
public class CarMeasurePriceUpdateStateService extends EventStartCarBase {

    @Autowired
    CarLoanInfoServiceFeign carLoanInfoServiceFeign;
    @Autowired
    Jbpm4TaskServicefeign jbpm4TaskServicefeign;
    /**
     * 更新进件状态
     *
     * @param taskEventParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateOrderState(TaskEventParam taskEventParam) throws Exception {
        try {
            Map<String, Object> variables = new HashMap<>();
            variables = taskEventParam.getVariables();

            Long orderId = Long.parseLong(variables.get("orderid").toString());
            String transition = (String) variables.get("transition");

            String auditState = this.getAuditType(transition);
            CarLoanInfoParam carLoanInfoParam = new CarLoanInfoParam();
            carLoanInfoParam.setId(orderId);
            carLoanInfoParam.setAuditeState(auditState);

            taskEventParam.setOrderId(orderId.toString());
            taskEventParam.setAuditState(auditState);
            taskEventParam.setOrderTypeName("车贷定价");
            taskEventParam.setOrderTypeCode(CarFlowConst.CAR_TASKTYPE_DINGJIA);
            //执行更新订单状态
            log.info(MessageFormat.format("1.updateOrderState.dingjia.prepare,orderid:{0},state:{1}",orderId,auditState));
                //执行保存任务流转历史表
                Response result= jbpm4TaskServicefeign.UpdateOrderState(taskEventParam);
                if(Response.isSucess(result)){
                    log.info(MessageFormat.format("2.updateOrderState.dingjia.sucess,taskEventParam:{0}",taskEventParam.toString()));
                    return true;
                }
                else{
                    String msg=MessageFormat.format("2-2.updateOrderState.dingjia.error,taskEventParam:{0}",taskEventParam.toString());
                    log.error(msg);
                    throw new Exception(msg);
                }


        } catch (Exception ex) {
            log.error("3-3.updateOrderState.dingjia.error");
            log.error(ex.getMessage()+MessageFormat.format("updateOrderState.error," +
                    "taskEventParam:{0}",taskEventParam.toString()));
            throw ex;
        }
    }

    /**
     * 根据流转名称获取审核状态
     *
     * @param transition
     * @return
     */
    private String getAuditType(String transition) {
        String auditState = "";
        //如果是开始审核--定价审核中
        if (CarTransitionConst.CONST_DINGJIA_TURNDIR_START.equals(transition)) {
            //定价审核开始-审核中
            auditState = CarOrderState.DINGJIA_STATE_SHENHE.getKey();
        } else if (CarTransitionConst.CONST_DINGJIA_TURNDIR_ATTACH.equals(transition)) {
            //定价审核补件-审核中
            auditState = CarOrderState.DINGJIA_STATE_SHENHE.getKey();
        } else if (CarTransitionConst.CONST_DINGJIA_TURNDIR_AGREE.equals(transition)) {
            //定价审核结束-同意
            auditState = CarOrderState.DINGJIA_STATE_TONGYI.getKey();
        } else if (CarTransitionConst.CONST_DINGJIA_TURNDIR_REFUSE.equals(transition)) {
            //定价审核结束-拒绝
            auditState = CarOrderState.DINGJIA_STATE_JUJUE.getKey();
        } else if (CarTransitionConst.CONST_DINGJIA_TURNDIR_ROLLBACK.equals(transition)) {
            //定价审核回退-补件
            auditState = CarOrderState.DINGJIA_STATE_BUJIAN.getKey();
        }
        return auditState;
    }




}
