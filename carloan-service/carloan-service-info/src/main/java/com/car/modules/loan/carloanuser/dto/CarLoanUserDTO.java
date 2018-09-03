package com.car.modules.loan.carloanuser.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *@Description:车贷个人信息表
 *@author root
 *@version 1.0,
 *@date 2018-05-25 01:26:23
 */
@Getter
@Setter
public class CarLoanUserDTO{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	private Long id;

	/**订单编号*/
	private String orderNumber;

	/**人姓名*/
	private String userName;

	/**性别*/
	private String sex;

	/**出生日期*/
	private String birthdayDate;

	/**联系电话*/
	private String phoneNumber;

	/**身份证号*/
	private String idCard;

	/**证件有效期*/
	private String certificateValide;

	/**户籍地址*/
	private String houseAddress;

	/**联系地址*/
	private String contactAddress;

	/**暂住证*/
	private String theporaryPermit;

	/**联系住址电话*/
	private String contactAddressPhone;

	/**联系住址电话*/
	private String startLivingTime;

	/**初来本市年份*/
	private String inCityYear;

	/**供养亲属人数*/
	private String supportNumber;

	/**婚姻状况*/
	private String maritalStatus;

	/**学历*/
	private String education;

	/**信用卡额度*/
	private String creditCardAmount;

	/**房产*/
	private String houseProperty;

	/**单位名称*/
	private String unitName;

	/**所属部门*/
	private String belongDepartment;

	/**岗位名称*/
	private String postName;

	/**单位电话*/
	private String companyPhone;

	/**单位地址*/
	private String companyAddress;

	/**单位性质*/
	private String companyNature;

	/**月基本薪金*/
	private String monthSalary;

	/**其他收入*/
	private String otherIncome;

	/**职位级别*/
	private String positionLevel;

	/**入司年限*/
	private String inCompanyYear;

	/**是否为私营业主*/
	private String isPrivateOwner;

	/**配偶姓名*/
	private String spouseName;

	/**配偶联系电话*/
	private String spousePhone;

	/**配偶学历*/
	private String spouseEducation;

	/**配偶身份证号*/
	private String spouseIdCard;

	/**配偶证件有效期*/
	private String spouseCertificateValid;

	/**配偶居住地址*/
	private String spouseLivingAddress;

	/**配偶单位名称*/
	private String spouseUnitName;

	/**配偶单位电话*/
	private String spouseCompanyPhone;

	/**配偶单位地址*/
	private String spouseCompanyAddress;

	/**配偶单位性质*/
	private String spouseCompanyNature;

	/**配偶月基本薪金*/
	private String spouseMonthSalary;

	/**配偶其他收入*/
	private String spouseOtherIncome;

	/**配偶职位级别*/
	private String spousePositionLevel;

	/**配偶入司年限*/
	private String spouseInCompanyYear;

	/**配偶是否为私营业主*/
	private String spouseIsPrivateOwner;

	/**CREATE_TIME*/
	private java.util.Date createTime;

	/**UPDATE_TIME*/
	private java.util.Date updateTime;
	private Long carinfoid;




}