package com.carloan.apimodel.jbpm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by zhangyl on 2018/7/30
 */
@Getter
@Setter
@ApiModel("调单VO")
public class ConsignTaskVO implements Serializable {
    private static final long serialVersionUID = -7249931029776820020L;

    @ApiModelProperty(value = "taskId")
    @Min(value = 1,message = "TASKID不能为NULL")
    private long taskId;
    /**
     * 派单TO
     */
    @ApiModelProperty(value = "指定派单人")
    @NotBlank(message = "指定派单人不能为NULL")
    private String toUserId;

    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    //@NotBlank(message = "操作人不能为NULL")
    private String createBy;
}
