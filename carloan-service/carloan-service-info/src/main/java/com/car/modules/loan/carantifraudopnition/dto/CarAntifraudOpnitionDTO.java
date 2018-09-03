package com.car.modules.loan.carantifraudopnition.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:反欺诈审核意见表
 *@author root
 *@version 1.0,
 *@date 2018-07-17 10:31:50
 */
@Getter
@Setter
public class CarAntifraudOpnitionDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	@ApiModelProperty(value="主键id")
	private java.lang.Long id;

	/**订单编号*/
	@ApiModelProperty(value="订单编号")
	private java.lang.String orderNumber;

	/**CAR_INFO_ID*/
	@ApiModelProperty(value="CAR_INFO_ID")
	private java.lang.Long carInfoId;

	/**反欺诈审核结论*/
	@ApiModelProperty(value="反欺诈审核结论")
	private java.lang.String fraudConclusion;

	/**一级欺诈原因*/
	@ApiModelProperty(value="一级欺诈原因")
	private java.lang.String mainOption;

	/**二级欺诈原因*/
	@ApiModelProperty(value="二级欺诈原因")
	private java.lang.String subOption;

	/**备注信息*/
	@ApiModelProperty(value="备注信息")
	private java.lang.String remarks;

	/**当前审批人*/
	@ApiModelProperty(value="当前审批人")
	private java.lang.String approver;

	/**EXT1*/
	@ApiModelProperty(value="EXT1")
	private java.lang.String ext1;

	/**EXT2*/
	@ApiModelProperty(value="EXT2")
	private java.lang.String ext2;

	/**状态：301门店补件，304审核同意，305审核拒绝*/
	@ApiModelProperty(value="状态：301门店补件，304审核同意，305审核拒绝")
	private java.lang.String staTus;

	/**状态：2300 非欺诈 2600欺诈*/
	@ApiModelProperty(value="状态：2300 非欺诈 2600欺诈")
	private java.lang.String auditState;

	/**创建时间*/
	@ApiModelProperty(value="创建时间")
	private java.util.Date createTime;

	/**修改时间*/
	@ApiModelProperty(value="修改时间")
	private java.util.Date updateTime;

	/**操作类型 0 保存，1 提交*/
	@ApiModelProperty(value="操作类型 0 保存，1 提交")
	private java.lang.Short operation;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.Short validateState;

	/**流程实例ID*/
	@ApiModelProperty(value="流程实例ID")
	private java.lang.String processId;
	//流程流转方向
	private String transition;

	private String isEdit;


}