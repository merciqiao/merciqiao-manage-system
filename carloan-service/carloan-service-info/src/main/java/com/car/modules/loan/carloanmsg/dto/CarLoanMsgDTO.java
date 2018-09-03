package com.car.modules.loan.carloanmsg.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *@Description:车辆信息
 *@author Administrator
 *@version 1.0,
 */
@Getter
@Setter
public class CarLoanMsgDTO{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	private Long id;

	/**订单编号*/
	private String orderNumber;

	/**承租人姓名*/
	private String lesseeName;

	/**身份证号*/
	private String idCard;

	/**车辆品牌*/
	private String carBrand;

	/**车系*/
	private String carType;

	/**车辆型号及配置*/
	private String carModelConfig;

	/**车牌号*/
	private String carNumber;

	/**车架号*/
	private String carFrameNumber;

	/**初登日期*/
	private String carNumberDate;

	/**出厂日期*/
	private String manufactureDate;

	/**车身颜*/
	private String carColor;

	/**交强险到期日*/
	private String strongRiskDueDate;

	/**发动机号*/
	private String engineNumber;

	/**车辆的生产厂商*/
	private String carManufacturers;

	/**购置数量*/
	private String purchaseNumber;

	/**公里数*/
	private String carDrivingKilometres;

	/**车辆过户次数*/
	private String numberOfTransfer;

	/**评估师姓名*/
	private String appraiserName;

	/**评估备注*/
	private String appraiserNote;

	/**整体描述*/
	private String description;

	/**创建时间*/
	private java.util.Date creationTime;

	/**修改时间*/
	private java.util.Date updateTime;


	/**审核状态*/
	private String auditeState;

	/**操作人id*/
	private Long operateUser;


	private Long carinfoid;

}