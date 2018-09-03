package com.carloan.apimodel.activiti.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2018/6/25.
 */
@Getter
@Setter
public class ActivitiInstanceInfoVO {
    //流程实例ID
    private String instanceID;
    //流转方向
    private String transition;
    //当前处理人ID
    private String assignee;
    //当前节点名称
    private String actName;
    //
    private String result;
    //保存节点可执行的transition
    private HashMap<String, List<String>> transitionMap;
}
