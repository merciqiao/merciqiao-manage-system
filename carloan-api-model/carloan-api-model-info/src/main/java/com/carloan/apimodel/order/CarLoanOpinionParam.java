package com.carloan.apimodel.order;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/6.
 */
@Getter
@Setter
public class CarLoanOpinionParam  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键id*/
    @ApiModelProperty(value="主键id")
    private java.lang.Long id;

    /**订单编号*/
    @ApiModelProperty(value="订单编号")
    private java.lang.String orderNumber;

    /**当前审批岗位*/
    @ApiModelProperty(value="当前审批岗位")
    private java.lang.String currentExaminationPost;

    /**当前审批人*/
    @ApiModelProperty(value="当前审批人")
    private java.lang.String currentApprover;

    /**流程类型*/
    @ApiModelProperty(value="流程类型")
    private java.lang.Integer bizType;

    /**流程实例ID*/
    @ApiModelProperty(value="流程实例ID")
    private java.lang.String processId;

    /**审批状态*/
    @ApiModelProperty(value="审批状态")
    private java.lang.String auditState;

    /**产品系列*/
    @ApiModelProperty(value="产品系列")
    private java.lang.String productSeries;

    /**CAR_INFO_ID*/
    @ApiModelProperty(value="CAR_INFO_ID")
    private java.lang.Long carInfoId;

}
