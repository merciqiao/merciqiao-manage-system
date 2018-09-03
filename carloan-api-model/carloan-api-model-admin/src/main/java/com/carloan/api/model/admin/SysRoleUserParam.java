package com.carloan.api.model.admin;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class SysRoleUserParam extends PageInfoExt {

    private static final long serialVersionUID = 1L;

    /**主键*/
    @ApiModelProperty(value="主键")
    private java.lang.Long id;

    /**ROLE_ID*/
    @ApiModelProperty(value="ROLE_ID")
    private java.lang.Long roleId;

    /**TARGET_ID*/
    @ApiModelProperty(value="TARGET_ID")
    private java.lang.Long targetId;

    /**APP_ID*/
    @ApiModelProperty(value="APP_ID")
    private java.lang.Long appId;

    /**TARGET_TYPE*/
    @ApiModelProperty(value="TARGET_TYPE")
    private java.lang.String targetType;

    /**VALIDATE_STATE*/
    @ApiModelProperty(value="VALIDATE_STATE")
    private java.lang.String validateState;

    /**VERSION*/
    @ApiModelProperty(value="VERSION")
    private java.lang.Long version;

}
