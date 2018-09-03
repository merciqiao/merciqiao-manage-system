package com.carloan.service.admin.sysuser.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_user
 *@author root
 *@version 1.0,
 *@date 2018-07-06 15:17:35
 */
@Getter
@Setter
public class SysUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private java.lang.Long id;

	/**USER_NAME*/
	@ApiModelProperty(value="USER_NAME")
	private java.lang.String userName;

	/**USER_NO*/
	@ApiModelProperty(value="USER_NO")
	private java.lang.String userNo;

	/**LOGIN_NAME*/
	@ApiModelProperty(value="LOGIN_NAME")
	private java.lang.String loginName;

	/**PASSWORD*/
	@ApiModelProperty(value="PASSWORD")
	private java.lang.String password;

	/**SALT*/
	@ApiModelProperty(value="SALT")
	private java.lang.String salt;

	/**MOBILE*/
	@ApiModelProperty(value="MOBILE")
	private java.lang.String mobile;

	/**EMAIL*/
	@ApiModelProperty(value="EMAIL")
	private java.lang.String email;

	/**USER_IMAGE*/
	@ApiModelProperty(value="USER_IMAGE")
	private java.lang.String userImage;

	/**SEX*/
	@ApiModelProperty(value="SEX")
	private java.lang.String sex;

	/**BIRTHDAY*/
	@ApiModelProperty(value="BIRTHDAY")
	private java.lang.String birthday;

	/**NATIONALITY*/
	@ApiModelProperty(value="NATIONALITY")
	private java.lang.String nationality;

	/**EDUCATION*/
	@ApiModelProperty(value="EDUCATION")
	private java.lang.String education;

	/**JOB*/
	@ApiModelProperty(value="JOB")
	private java.lang.String job;

	/**HOME_ADDRESS*/
	@ApiModelProperty(value="HOME_ADDRESS")
	private java.lang.String homeAddress;

	/**HOME_ZIPCODE*/
	@ApiModelProperty(value="HOME_ZIPCODE")
	private java.lang.String homeZipcode;

	/**HOME_TEL*/
	@ApiModelProperty(value="HOME_TEL")
	private java.lang.String homeTel;

	/**OFFICE_TEL*/
	@ApiModelProperty(value="OFFICE_TEL")
	private java.lang.String officeTel;

	/**OFFICE_ADDRESS*/
	@ApiModelProperty(value="OFFICE_ADDRESS")
	private java.lang.String officeAddress;

	/**ORDER_BY*/
	@ApiModelProperty(value="ORDER_BY")
	private java.lang.String orderBy;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

	/**IS_LOCKED*/
	@ApiModelProperty(value="IS_LOCKED")
	private java.lang.String isLocked;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private java.lang.Long version;

	/**创建时间*/
	@ApiModelProperty(value="创建时间")
	private java.util.Date createDate;

	/**CARD_NO*/
	@ApiModelProperty(value="CARD_NO")
	private java.lang.String cardNo;

	/**PROBATION_PERIOD*/
	@ApiModelProperty(value="PROBATION_PERIOD")
	private java.lang.Long probationPeriod;

	/**入职日期*/
	@ApiModelProperty(value="入职日期")
	private java.util.Date entryDate;

	/**离职日期*/
	@ApiModelProperty(value="离职日期")
	private java.util.Date quitDate;

	/**参加工作日期*/
	@ApiModelProperty(value="参加工作日期")
	private java.util.Date workDate;

	/**POLITICAL_STATUS*/
	@ApiModelProperty(value="POLITICAL_STATUS")
	private java.lang.String politicalStatus;

	/**USER_RELATION*/
	@ApiModelProperty(value="USER_RELATION")
	private java.lang.String userRelation;

	/**ANNUAL_LEAVE*/
	@ApiModelProperty(value="ANNUAL_LEAVE")
	private java.lang.Long annualLeave;

	/**JXZJ*/
	@ApiModelProperty(value	="JXZJ")
	private java.lang.String jxzj;

	/**NJQSRQ*/
	@ApiModelProperty(value="NJQSRQ")
	private java.util.Date njqsrq;

	/**UUID*/
	@ApiModelProperty(value="UUID")
	private java.lang.String uuid;

	private Long orgid;
	private Long positionid;

	private String orgname;
	private String positionname;

}