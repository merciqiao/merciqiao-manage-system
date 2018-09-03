package com.car.modules.workflow.dispatch.rule.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhangyl on 2018/7/25
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfVO {
    @NotBlank(message = "ruleCode不能为null")
    private String ruleCode;

    @NotBlank(message = "bizType不能为null")
    private String bizType;
    private String arefId;
    private String productId;

}
