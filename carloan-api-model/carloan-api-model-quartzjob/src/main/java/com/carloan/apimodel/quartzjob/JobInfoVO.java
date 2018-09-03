package com.carloan.apimodel.quartzjob;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhangyl on 2018/7/11
 */
@Getter
@Setter
public class JobInfoVO implements Serializable {
    private static final long serialVersionUID = -3271583457916595798L;
    /**
     * job名称
     */
    @ApiModelProperty(value = "任务名")
    private String jobName;
    /**
     * 类名
     */
    @ApiModelProperty(value = "任务class")
    private String className;
    /**
     * cron表达式
     */
    @ApiModelProperty(value = "cron表达式")
    private String cron;
}
