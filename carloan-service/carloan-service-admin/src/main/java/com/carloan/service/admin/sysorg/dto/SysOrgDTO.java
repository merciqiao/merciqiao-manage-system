package com.carloan.service.admin.sysorg.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_org
 *@author root
 *@version 1.0,
 *@date 2018-07-06 09:52:41
 */
@Getter
@Setter
public class SysOrgDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**ID*/
	@ApiModelProperty(value="ID")
	private java.lang.Long id;

	/**ORG_CODE*/
	@ApiModelProperty(value="ORG_CODE")
	private java.lang.String orgCode;

	/**ORG_NAME*/
	@ApiModelProperty(value="ORG_NAME")
	private java.lang.String orgName;

	/**ORG_TYPE*/
	@ApiModelProperty(value="ORG_TYPE")
	private java.lang.String orgType;

	/**PARENT_ID*/
	@ApiModelProperty(value="PARENT_ID")
	private java.lang.String parentId;

	/**PARENT_IDS*/
	@ApiModelProperty(value="PARENT_IDS")
	private java.lang.String parentIds;

	/**ORDER_BY*/
	@ApiModelProperty(value="ORDER_BY")
	private java.lang.String orderBy;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

	/**IS_VIRTUAL*/
	@ApiModelProperty(value="IS_VIRTUAL")
	private java.lang.String isVirtual;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private java.lang.Long version;

	/**APP_FLAG*/
	@ApiModelProperty(value="APP_FLAG")
	private java.lang.String appFlag;

	/**IS_LEEF*/
	@ApiModelProperty(value="IS_LEEF")
	private java.lang.String isLeef;

	/**AREA_CODES*/
	@ApiModelProperty(value="AREA_CODES")
	private java.lang.String areaCodes;

	/**AREA_ADRESS*/
	@ApiModelProperty(value="AREA_ADRESS")
	private java.lang.String areaAdress;

	/**ORG_LEVEL*/
	@ApiModelProperty(value="ORG_LEVEL")
	private java.lang.String orgLevel;

	/**EFFECTIVE_DATE*/
	@ApiModelProperty(value="EFFECTIVE_DATE")
	private java.util.Date effectiveDate;

	/**CREATE_TIME*/
	@ApiModelProperty(value="CREATE_TIME")
	private java.util.Date createTime;

	/**UUID*/
	@ApiModelProperty(value="UUID")
	private java.lang.String uuid;

	/**remark*/
	@ApiModelProperty(value="remark")
	private java.lang.String remark;

}