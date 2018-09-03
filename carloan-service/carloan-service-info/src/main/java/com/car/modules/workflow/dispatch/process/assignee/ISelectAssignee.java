package com.car.modules.workflow.dispatch.process.assignee;

import com.car.modules.workflow.dispatch.process.assignee.entity.ProcessAssigneeTO;

/**
 * Created by zhangyl on 2018/7/31
 */
public interface ISelectAssignee {
    /**
     * 根据规则查找处理人
     * @param processAssigneeDTO
     * @return
     */
    String getAssigneeByRule(ProcessAssigneeTO processAssigneeDTO);
}
