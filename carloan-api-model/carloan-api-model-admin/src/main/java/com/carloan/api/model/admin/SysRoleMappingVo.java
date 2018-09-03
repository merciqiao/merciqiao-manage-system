package com.carloan.api.model.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/18.
 */
@Getter
@Setter
public class SysRoleMappingVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键ID*/
    @ApiModelProperty(value="主键ID")
    private java.lang.Long id;

    /**ROLE_CODE*/
    @ApiModelProperty(value="ROLE_CODE")
    private java.lang.String roleCode;

    /**MAPPING_ROLE_CODE*/
    @ApiModelProperty(value="MAPPING_ROLE_CODE")
    private java.lang.String mappingRoleCode;

    /**VALIDATE_STATE*/
    @ApiModelProperty(value="VALIDATE_STATE")
    private java.lang.String validateState;

}
