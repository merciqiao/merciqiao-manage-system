package com.car.modules.loan.carloanopinion.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:初审终审(审核意见表)
 *@author root
 *@version 1.0,
 *@date 2018-07-04 14:30:47
 */
@Getter
@Setter
public class CarLoanOpinionDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	@ApiModelProperty(value="主键id")
	private java.lang.Long id;

	/**订单编号*/
	@ApiModelProperty(value="订单编号")
	private java.lang.String orderNumber;

	/**合同金额*/
	@ApiModelProperty(value="合同金额")
	private java.lang.String contractAmount;

	/**产品类型*/
	@ApiModelProperty(value="产品类型")
	private java.lang.String productType;

	/**还款方式*/
	@ApiModelProperty(value="还款方式")
	private java.lang.String repaymentMethod;

	/**审批期数*/
	@ApiModelProperty(value="审批期数")
	private java.lang.String approvalPeriod;

	/**是否同意过户的勾选*/
	@ApiModelProperty(value="是否同意过户的勾选")
	private java.lang.String ifTransfer;

	/**审核备注信息*/
	@ApiModelProperty(value="审核备注信息")
	private java.lang.String examineRemarks;
	/**内部备注信息*/
	@ApiModelProperty(value="审核内部备注信息")
	private java.lang.String innerRemarks;
	/**当前审批岗位*/
	@ApiModelProperty(value="当前审批岗位")
	private java.lang.String currentExaminationPost;

	/**当前审批人*/
	@ApiModelProperty(value="当前审批人")
	private java.lang.String currentApprover;

	/**创建时间*/
	@ApiModelProperty(value="创建时间")
	private java.util.Date creationTime;

	/**修改时间*/
	@ApiModelProperty(value="修改时间")
	private java.util.Date updateTime;

	/**流程类型*/
	@ApiModelProperty(value="流程类型")
	private java.lang.Integer bizType;

	/**流程实例ID*/
	@ApiModelProperty(value="流程实例ID")
	private java.lang.String processId;

	/**审批状态*/
	@ApiModelProperty(value="审批状态")
	private java.lang.String auditState;

	/**401客户信息补件,403客户信息审核同意,404客户信息审核拒绝,408欺诈审核拒绝,*/
	@ApiModelProperty(value="401客户信息补件,403客户信息审核同意,404客户信息审核拒绝,408欺诈审核拒绝,")
	private java.lang.String staTus;

	/**产品系列*/
	@ApiModelProperty(value="产品系列")
	private java.lang.String productSeries;

	/**CAR_INFO_ID*/
	@ApiModelProperty(value="CAR_INFO_ID")
	private java.lang.Long carInfoId;
	//操作0保存 1提交 save/submit
	private Short operation;
	private String isEdit;
	private String transition;
	//流程流转方向
	private String transition1;
	@ApiModelProperty(value="还款方式Str")
	private java.lang.String repaymentMethodStr;
	public String getRepaymentMethodStr() {
		String repaymentway="";
		if(this.repaymentMethod!=null&&this.repaymentMethod.length()>0) {
			switch (this.repaymentMethod) {
				case "RT01":
					repaymentway = "等额本息";
					break;
				case "RT02":
					repaymentway = "先息后本";
					break;
			}
		}
		return repaymentway;
	}

}