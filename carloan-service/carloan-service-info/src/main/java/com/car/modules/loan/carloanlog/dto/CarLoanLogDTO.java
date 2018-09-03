package com.car.modules.loan.carloanlog.dto;

import com.carloan.apimodel.common.PageInfoExt;
import lombok.Getter;
import lombok.Setter;

/**
 *@Description:CAR_LOAN_LOG
 *@author Administrator
 *@version 1.0,
 *@date 2018-05-24 16:24:05
 */
@Getter
@Setter
public class CarLoanLogDTO extends PageInfoExt {

	private static final long serialVersionUID = 1L;

	/**主键id*/
	private Long id;

	/**ORDER_NUMBER*/
	private String orderNumber;

	/**OPERATION_ACTION*/
	private String operationAction;

	/**REQ_JSON*/
	private String reqJson;

	/**ERR_JSON*/
	private String errJson;

	/**CREATION_TIME*/
	private java.util.Date creationTime;

	/**UPDATE_TIME*/
	private java.util.Date updateTime;

	private String creationTimeSta;
	private String creationTimeEnd;
	private String status;



}