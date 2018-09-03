package com.carloan.api.model.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class SysOrgParam  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**ID*/
    @ApiModelProperty(value="ID")
    private java.lang.Long id;

    /**ORG_CODE*/
    @ApiModelProperty(value="ORG_CODE")
    private java.lang.String orgCode;

    /**ORG_NAME*/
    @ApiModelProperty(value="ORG_NAME")
    private java.lang.String orgName;

    /**ORG_TYPE*/
    @ApiModelProperty(value="ORG_TYPE")
    private java.lang.String orgType;

    /**PARENT_ID*/
    @ApiModelProperty(value="PARENT_ID")
    private java.lang.String parentId;

    /**ORG_LEVEL*/
    @ApiModelProperty(value="ORG_LEVEL")
    private java.lang.String orgLevel;

}
