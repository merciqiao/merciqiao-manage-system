package com.carloan.apimodel.biz;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;


/**
 * Created by zhangyl on 2018/8/8
 */
@Getter
@Setter
@ApiModel("异步处理任务VO")
public class BizAsynJobVO {
    /**
     * 处理类
     */
    @NotBlank(message = "处理类不能为NUll")
    private String beanClass;

    /**
     * 业务keyID
     */
    @NotBlank(message = "业务keyID不能为NUll")
    private String bizKeyId;

    /**
     * 状态 enum类
     */
    @Min(value = 1, message = "状态最小为1")
    private Integer jobState;
}
