package com.carloan.apimodel.order;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:car_loan_survey_contacts
 *@author root
 *@version 1.0,
 *@date 2018-07-27 15:02:36
 */
@Getter
@Setter
public class CarLoanSurveyContactsDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	@ApiModelProperty(value="主键id")
	private Long id;

	/**订单编号*/
	@ApiModelProperty(value="订单编号")
	private String orderNumber;

	/**个人信息表ID*/
	@ApiModelProperty(value="个人信息表ID")
	private String carLoanUserId;

	/**联系人类型*/
	@ApiModelProperty(value="联系人类型")
	private String contactType;

	/**和本人关系*/
	@ApiModelProperty(value="和本人关系")
	private String relationship;

	/**姓名*/
	@ApiModelProperty(value="姓名")
	private String userName;

	/**联系人电话*/
	@ApiModelProperty(value="联系人电话")
	private String userTelephone;

	/**调查状态*/
	@ApiModelProperty(value="调查状态")
	private String investigationStatus;

	/**联系人家庭住址或单位住址*/
	@ApiModelProperty(value="联系人家庭住址或单位住址")
	private String homeAddress;

	/**工作单位名称*/
	@ApiModelProperty(value="工作单位名称")
	private String companyName;

	/**备注*/
	@ApiModelProperty(value="备注")
	private String remark;

	/**创建时间*/
	@ApiModelProperty(value="创建时间")
	private java.util.Date creationTime;

	/**修改时间*/
	@ApiModelProperty(value="修改时间")
	private java.util.Date updateTime;

	/**是否是原始联系人，原始联系人值为0，信审新增联系人值为1！信审操作时原始联系人不可编辑，只能新增！*/
	@ApiModelProperty(value="是否是原始联系人，原始联系人值为0，信审新增联系人值为1！信审操作时原始联系人不可编辑，只能新增！")
	private String type;

	/**是否为有效数据，1有效，0无效*/
	@ApiModelProperty(value="是否为有效数据，1有效，0无效")
	private String valueStatus;

}