package com.carloan.apimodel.quartzjob;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhangyl on 2018/7/11
 */
@Getter
@Setter
@ApiModel(value = "trigger对象")
public class TriggerInfoVO implements Serializable {
    /**
     * 上次执行时间
     */
    @ApiModelProperty(value = "上次执行时间")
    private String prevFireTime;
    /**
     * 下次执行时间
     */
    @ApiModelProperty(value = "下次执行时间")
    private String nextFireTime;
    /**
     * Trigger 名称
     */
    @ApiModelProperty(value = "Trigger 名称")
    private String triggerName;
    /**
     * JOB名称
     */
    @ApiModelProperty(value = "JOB名称")
    private String jobName;
    /**
     * 优先级
     */
    @ApiModelProperty(value = "优先级,值越小级别越高")
    private String priority;
    /**
     * 状态 WAITING:等待中;PAUSED:暂停;BLOCKED:阻塞（没有空闲的线程数）
     */
    @ApiModelProperty(value = "状态 WAITING:等待中;PAUSED:暂停;BLOCKED:阻塞（没有空闲的线程数）")
    private String triggerState;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String triggerType;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private String startTime;
}
