package com.car.modules.loan.carloansurveyinfo.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:car_loan_survey_info
 *@author root
 *@version 1.0,
 *@date 2018-07-16 15:39:38
 */
@Getter
@Setter
public class CarLoanSurveyInfoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	@ApiModelProperty(value="主键id")
	private java.lang.Long id;

	/**订单编号*/
	@ApiModelProperty(value="订单编号")
	private java.lang.String orderNumber;

	/**电核列表联系人ID*/
	@ApiModelProperty(value="电核列表联系人ID")
	private java.lang.String surveyContactsId;

	/**电核备注*/
	@ApiModelProperty(value="电核备注")
	private java.lang.String otherRemark;

	/**CREATE_TIME*/
	@ApiModelProperty(value="CREATE_TIME")
	private java.util.Date createTime;

	/**UPDATE_TIME*/
	@ApiModelProperty(value="UPDATE_TIME")
	private java.util.Date updateTime;

}