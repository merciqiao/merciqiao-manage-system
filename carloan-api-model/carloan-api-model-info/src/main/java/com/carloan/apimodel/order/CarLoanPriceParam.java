package com.carloan.apimodel.order;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 */
@Getter
@Setter
public class CarLoanPriceParam extends PageInfoExt {

    private static final long serialVersionUID = 1L;

    /**主键id*/
    @ApiModelProperty(value="主键id")
    private java.lang.Long id;

    /**订单编号*/
    @ApiModelProperty(value="订单编号")
    private java.lang.String orderNumber;

    /**状态：301门店补件，304审核同意，305审核拒绝*/
    @ApiModelProperty(value="状态：301门店补件，304审核同意，305审核拒绝")
    private java.lang.String staTus;

    /**CAR_INFO_ID*/
    @ApiModelProperty(value="CAR_INFO_ID")
    private java.lang.Long carInfoId;
}
