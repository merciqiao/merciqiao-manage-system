package com.carloan.api.model.admin;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysAclParam  extends PageInfoExt {
    private static final long serialVersionUID = 1L;

    /**主键*/
    @ApiModelProperty(value="主键")
    private java.lang.Long id;

    /**ROLE_ID*/
    @ApiModelProperty(value="ROLE_ID")
    private java.lang.Long roleId;

    /**RESOURE_ID*/
    @ApiModelProperty(value="RESOURE_ID")
    private java.lang.Long resoureId;

    /**ACCESSIBILITY*/
    @ApiModelProperty(value="ACCESSIBILITY")
    private java.lang.Long accessibility;

    /**APP_ID*/
    @ApiModelProperty(value="APP_ID")
    private java.lang.Long appId;

    /**VALIDATE_STATE*/
    @ApiModelProperty(value="VALIDATE_STATE")
    private java.lang.String validateState;

    /**VERSION*/
    @ApiModelProperty(value="VERSION")
    private java.lang.Long version;
}
