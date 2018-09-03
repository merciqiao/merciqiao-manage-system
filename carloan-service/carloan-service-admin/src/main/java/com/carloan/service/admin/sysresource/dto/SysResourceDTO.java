package com.carloan.service.admin.sysresource.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_resource
 *@author root
 *@version 1.0,
 *@date 2018-07-18 10:24:09
 */
@Getter
@Setter
public class SysResourceDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private java.lang.Long id;

	/**RESOURE_NAME*/
	@ApiModelProperty(value="RESOURE_NAME")
	private java.lang.String resoureName;

	/**RESOURE_TYPE*/
	@ApiModelProperty(value="RESOURE_TYPE")
	private java.lang.String resoureType;

	/**RESOURE_URL*/
	@ApiModelProperty(value="RESOURE_URL")
	private java.lang.String resoureUrl;

	/**PERMISSION*/
	@ApiModelProperty(value="PERMISSION")
	private java.lang.String permission;

	/**PARENT_ID*/
	@ApiModelProperty(value="PARENT_ID")
	private java.lang.String parentId;

	/**PARENT_IDS*/
	@ApiModelProperty(value="PARENT_IDS")
	private java.lang.String parentIds;

	/**APP_ID*/
	@ApiModelProperty(value="APP_ID")
	private java.lang.Long appId;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private java.lang.Long version;

}