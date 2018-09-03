package com.carloan.api.model.admin;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysPositionParam  extends PageInfoExt {
    private static final long serialVersionUID = 1L;

    /**主键*/
    @ApiModelProperty(value="主键")
    private java.lang.Long id;

    /**POSITION_NAME*/
    @ApiModelProperty(value="POSITION_NAME")
    private java.lang.String positionName;

    /**POSITION_CODE*/
    @ApiModelProperty(value="POSITION_CODE")
    private java.lang.String positionCode;

    /**ORDER_BY*/
    @ApiModelProperty(value="ORDER_BY")
    private java.lang.String orderBy;

    /**VALIDATE_STATE*/
    @ApiModelProperty(value="VALIDATE_STATE")
    private java.lang.String validateState;

    /**VERSION*/
    @ApiModelProperty(value="VERSION")
    private java.lang.Long version;

    /**创建时间*/
    @ApiModelProperty(value="创建时间")
    private java.util.Date createDate;

    /**ORG_CODE*/
    @ApiModelProperty(value="ORG_CODE")
    private java.lang.String orgCode;

    /**IS_RESPONSIBLE*/
    @ApiModelProperty(value="IS_RESPONSIBLE")
    private java.lang.String isResponsible;

    /**POSITION_SEQUENCE*/
    @ApiModelProperty(value="POSITION_SEQUENCE")
    private java.lang.String positionSequence;

    /**POST*/
    @ApiModelProperty(value="POST")
    private java.lang.String post;

    /**有效日期*/
    @ApiModelProperty(value="有效日期")
    private java.util.Date effectiveDate;

    /**PARENT_ID*/
    @ApiModelProperty(value="PARENT_ID")
    private java.lang.String parentId;
}
