package com.carloan.api.model.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * Created by Administrator on 2018/7/18.
 */
@Getter
@Setter
public class SysAclVo implements Serializable {

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

    private String[] resourceids;

}
