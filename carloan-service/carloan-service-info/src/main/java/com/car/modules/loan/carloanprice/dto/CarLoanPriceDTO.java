package com.car.modules.loan.carloanprice.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:定价审核意见表
 *@author root
 *@version 1.0,
 *@date 2018-07-03 13:23:52
 */
@Getter
@Setter
public class CarLoanPriceDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	@ApiModelProperty(value="主键id")
	private java.lang.Long id;

	/**订单编号*/
	@ApiModelProperty(value="订单编号")
	private java.lang.String orderNumber;

	/**定价产品类型*/
	@ApiModelProperty(value="定价产品类型")
	private java.lang.String pricingProductType;

	/**定价结论*/
	@ApiModelProperty(value="定价结论")
	private java.lang.String pricingConclusion;

	/**定价金额*/
	@ApiModelProperty(value="定价金额")
	private java.lang.String pricingMoney;

	/**定价备注信息*/
	@ApiModelProperty(value="定价备注信息")
	private java.lang.String pricingRemarks;

	/**定价内部备注信息*/
	@ApiModelProperty(value="定价内部备注信息")
	private java.lang.String innerRemarks;

	/**当前审批人*/
	@ApiModelProperty(value="当前审批人")
	private java.lang.String currentApprover;

	/**状态：2100 补件，2200 同意 2700 拒绝*/
	@ApiModelProperty(value="状态：2100 补件，2200 同意 2700 拒绝")
	private java.lang.String auditState;

	/**创建时间*/
	@ApiModelProperty(value="创建时间")
	private java.util.Date creationTime;

	/**修改时间*/
	@ApiModelProperty(value="修改时间")
	private java.util.Date updateTime;

	/**状态：301门店补件，304审核同意，305审核拒绝*/
	@ApiModelProperty(value="状态：301门店补件，304审核同意，305审核拒绝")
	private java.lang.String staTus;

	/**CAR_INFO_ID*/
	@ApiModelProperty(value="CAR_INFO_ID")
	private java.lang.Long carInfoId;
	/**流程类型*/
	@ApiModelProperty(value="流程类型")
	private java.lang.Integer bizType;
	/**流程实例ID*/
	@ApiModelProperty(value="流程实例ID")
	private java.lang.String processId;
	//任务当前节点
	private String actName;
	//操作0保存 1提交 save/submit
	private Short operation;
	//流程流转方向
	private String transition;
	private String isEdit;

}