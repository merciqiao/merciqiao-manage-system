package com.carloan.apimodel.workflow;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
/**
 * 流程事件参数
 */
public class TaskEventParam {
    /* 流程实例id */
    public String proInstanceId;
    /* 节点名称 */
    private String activityName;
    /* 流转名称 */
    private String transition;
    /* variables */
    public Map<String, Object> variables=new HashMap<>();

    public String orderId;
    public String auditState;
    public String orderTypeName;
    public String orderTypeCode;


}
