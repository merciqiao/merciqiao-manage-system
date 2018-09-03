package com.carloan.service.activiti.eventlistener.measureprice;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.workflow.TaskEventParam;
import com.carloan.common.utils.SpringUtil;
import com.carloan.feign.workflow.WorkFlowFeign;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 车贷定价事件--更新订单状态
 */
@Component
@Slf4j
public class CarMeasurePriceUpdateState implements  ExecutionListener {
    @Autowired
    WorkFlowFeign workFlowFeign;

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        if(workFlowFeign==null){
            workFlowFeign=(WorkFlowFeign)SpringUtil.getObject("com.carloan.feign.workflow.WorkFlowFeign");
        }
        Map<String, Object> variables = new HashMap<String, Object>();
        variables=delegateExecution.getVariables();
        String transition= (String)variables.get("transition");

        TaskEventParam taskEventParam=new TaskEventParam();
        taskEventParam.setProInstanceId(delegateExecution.getProcessInstanceId());
        taskEventParam.setActivityName(delegateExecution.getCurrentActivityName());
        taskEventParam.setTransition(transition);
        taskEventParam.setVariables(variables);

        Response result= workFlowFeign.updateOrderState_DingJia(taskEventParam);
        String msg=MessageFormat.format("CarMeasurePriceUpdateState.notify.{0},taskEventParam:{1}", result,taskEventParam.toString());
        if(Response.isSucess(result)) {
            log.info(msg);
        }
        else{
            log.error(msg);
            throw new Exception(msg);

        }
    }
}
