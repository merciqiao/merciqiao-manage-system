package com.car.modules.workflow.dispatch.process.task.impl;

import com.car.modules.workflow.dispatch.process.assignee.ISelectAssignee;
import com.car.modules.workflow.dispatch.process.assignee.entity.ProcessAssigneeTO;
import com.car.modules.workflow.dispatch.process.task.AbstractProcessTask;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyl on 2018/7/31
 * 车贷审核节点  派单任务
 */
@Component
public class AuditProcessTaskServiceImpl extends AbstractProcessTask {
    @Autowired
    @Qualifier("com.car.modules.workflow.dispatch.process.assignee.impl.SelectAuditAssigneeImpl")
    private ISelectAssignee selectAssignee;
    @Override
    public String getType() {
        StringBuilder builder = new StringBuilder();
        builder.append(CarFlowConst.CAR_TASKTYPE_XINSHEN).append(":").append(CarFlowConst.AUDIT);
        return builder.toString();
    }

    @Override
    public String executeInternal(ProcessAssigneeTO processAssigneeDTO) {
        return selectAssignee.getAssigneeByRule(processAssigneeDTO);
    }
}
