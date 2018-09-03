package com.carloan.apimodel.quartzjob;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhangyl on 2018/7/10
 */
@Getter
@Setter
@ApiModel("分页信息")
public class TriggerExtVO extends PageInfoExt {
    /**
     * 任务名称
     */
    @ApiModelProperty(value = "任务名称",example = "jobName")
    private String jobName;
    /**
     * 状态 WAITING:等待中;PAUSED:暂停;BLOCKED:阻塞（没有空闲的线程数）
     */
    @ApiModelProperty(value = "状态 WAITING:等待中;PAUSED:暂停;BLOCKED:阻塞（没有空闲的线程数）",example = "WAITING")
    private String triggerState;
}
