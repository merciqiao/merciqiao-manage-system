package com.carloan.service.master.sysconfig.dto;

import com.carloan.apimodel.common.PageInfoExt;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Getter
@Setter
public class SysConfigDTO extends PageInfoExt implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 配置名称
     */
    @ApiModelProperty(value = "配置名称")
    private String configName;

    /**
     * 配置编码
     */
    @ApiModelProperty(value = "配置编码")
    private String configCode;

    /**
     * 配置值
     */
    @ApiModelProperty(value = "配置值")
    private String configValue;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String configType;

    /**
     * VALIDATE_STATE
     */
    @ApiModelProperty(value = "VALIDATE_STATE")
    private String validateState;

    /**
     * VERSION
     */
    @ApiModelProperty(value = "VERSION")
    private Long version;

}