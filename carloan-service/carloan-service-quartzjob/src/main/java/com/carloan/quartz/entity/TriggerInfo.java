package com.carloan.quartz.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhangyl on 2018/6/27
 */
@Getter
@Setter
public class TriggerInfo implements Serializable {
    /**
     * 上次执行时间
     */
    private String prevFireTime;
    /**
     * 下次执行时间
     */
    private String nextFireTime;
    /**
     * Trigger 名称
     */
    private String triggerName;
    /**
     * JOB名称
     */
    private String jobName;
    /**
     * 优先级
     */
    private String priority;
    /**
     * 状态 WAITING:等待中;PAUSED:暂停;BLOCKED:阻塞（没有空闲的线程数）
     */
    private String triggerState;
    /**
     * 类型
     */
    private String triggerType;
    /**
     * 开始时间
     */
    private String startTime;
}
