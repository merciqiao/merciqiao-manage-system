package com.carloan.apimodel.order;

import com.carloan.apimodel.common.PageInfoExt;
import lombok.Data;

/**
 *@Description:CAR_LOAN_LOG
 *@author Administrator
 *@version 1.0,
 *@date 2018-05-24 16:24:05
 */
@Data
public class CarLoanLogDTO extends PageInfoExt {

	private static final long serialVersionUID = 1L;

	/**ORDER_NUMBER*/
	private String orderNumber;

	/**OPERATION_ACTION*/
	private String operationAction;

	/**CREATION_TIME*/
	private java.util.Date creationTime;
	private String creationTimeSta;
	private String creationTimeEnd;
	private String status;
	private String reqjson;

}