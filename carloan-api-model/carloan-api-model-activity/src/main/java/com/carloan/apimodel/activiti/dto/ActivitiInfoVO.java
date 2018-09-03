package com.carloan.apimodel.activiti.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2018/6/25.
 */
@Getter
@Setter
public class ActivitiInfoVO {
    // 流程key
    public String processKey;
    //流转方向
    private String transition;
    // 任务归属人
    public String owner;
    // 任务指派人
    public String assignee;
    //订单id
    public String orderid;
}
