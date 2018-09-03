package com.carloan.apimodel.master;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author root
 * @version 1.0,
 * @Description:sys_config
 * @date 2018-07-13 16:35:02
 */
@Getter
@Setter
public class SysConfigVo extends PageInfoExt implements Serializable {

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