package com.car.modules.workflow.dispatch.process.assignee.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhangyl on 2018/7/31
 */
@Getter
@Setter
@Builder
public class ProcessAssigneeTO {
    private String proInstanceId;
    private String activityName;
    private String orgId;
    private String bizType;
}
