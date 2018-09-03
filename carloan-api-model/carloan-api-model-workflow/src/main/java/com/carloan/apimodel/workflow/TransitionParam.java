package com.carloan.apimodel.workflow;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TransitionParam {
    /* 任务实例id */
    public String taskId;
    /* 扩展参数(暂时不用,可传null) */
    public Map<String,Object> variables;
    /* 流转类型 */
    public String type;
    /* 订单号 */
    public String orderNum;
}
