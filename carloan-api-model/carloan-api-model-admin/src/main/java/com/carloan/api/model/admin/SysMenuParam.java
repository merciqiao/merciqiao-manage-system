package com.carloan.api.model.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class SysMenuParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键*/
    @ApiModelProperty(value="主键")
    private java.lang.Long id;

    /**MENU_CODE*/
    @ApiModelProperty(value="MENU_CODE")
    private java.lang.String menuCode;

    /**MENU_NAME*/
    @ApiModelProperty(value="MENU_NAME")
    private java.lang.String menuName;

    /**PARENT_ID*/
    @ApiModelProperty(value="PARENT_ID")
    private java.lang.String parentId;

    /**VALIDATE_STATE*/
    @ApiModelProperty(value="VALIDATE_STATE")
    private java.lang.String validateState;

    /**VERSION*/
    @ApiModelProperty(value="VERSION")
    private java.lang.Long version;


}