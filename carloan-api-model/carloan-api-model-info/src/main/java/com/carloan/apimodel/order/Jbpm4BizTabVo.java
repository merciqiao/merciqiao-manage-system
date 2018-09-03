package com.carloan.apimodel.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jbpm4BizTabVo {
    /**主键ID*/
    private Long id;

    /**BIZ_TAB_NAME*/
    private String bizTabName;

    /**BIZ_TYPE*/
    private String bizType;

    /**BIZ_INF_ID*/
    private String bizInfId;

    /**BIZ_INF_NAME*/
    private String bizInfName;

    /**BIZ_TASK_TYPE*/
    private String bizTaskType;

    /**PRO_INSTANCE_ID*/
    private String proInstanceId;

    /**START_PRO_USERID*/
    private String startProUserid;

    /**PRO_INSTANCE_STATE*/
    private String proInstanceState;

    /**TASK_STATE*/
    private String taskState;

    /**VALIDATE_STATE*/
    private String validateState;

    /**OWNER_ID*/
    private String ownerId;

    /**ORG_ID*/
    private String orgId;

    /**创建时间*/
    private java.util.Date createTime;

    /**修改时间*/
    private java.util.Date modifyTime;

    /**CREATE_BY*/
    private String createBy;

    /**MODIFY_BY*/
    private String modifyBy;

    /**REMARK*/
    private String remark;

    /**IS_HIDDEN*/
    private String isHidden;

    /**BIZ_INF_NO*/
    private String bizInfNo;

    /**超时提醒时间*/
    private java.util.Date overTime;

    /**提醒时间*/
    private java.util.Date remindTime;
}
