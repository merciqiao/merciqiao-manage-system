package com.car.modules.loan.carloanrichtext.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:car_loan_rich_text
 *@author root
 *@version 1.0,
 *@date 2018-07-26 13:26:50
 */
@Getter
@Setter
public class CarLoanRichTextDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	@ApiModelProperty(value="主键id")
	private java.lang.Long id;

	/**关联编号*/
	@ApiModelProperty(value="关联编号")
	private java.lang.String relationNumber;

	/**初审备注(NET_CHECK_FIRSTAUDIT_REMARK)或者终审备注(NET_CHECK_LASTAUDIT_REMARK)*/
	@ApiModelProperty(value="初审备注(NET_CHECK_FIRSTAUDIT_REMARK)或者终审备注(NET_CHECK_LASTAUDIT_REMARK)或者异常备注(NET_CHECK_THREEAUDIT_REMARK)")
	private java.lang.String bizType;

	/**备注内容*/
	@ApiModelProperty(value="备注内容")
	private java.lang.Object content;

	/**创建时间*/
	@ApiModelProperty(value="创建时间")
	private java.util.Date creationTime;

}