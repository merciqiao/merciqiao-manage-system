package com.carloan.service.admin.sysacl.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_acl
 *@author root
 *@version 1.0,
 *@date 2018-07-18 10:23:50
 */
@Getter
@Setter
public class SysAclDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private java.lang.Long id;

	/**ROLE_ID*/
	@ApiModelProperty(value="ROLE_ID")
	private java.lang.Long roleId;

	/**RESOURE_ID*/
	@ApiModelProperty(value="RESOURE_ID")
	private java.lang.Long resoureId;

	/**ACCESSIBILITY*/
	@ApiModelProperty(value="ACCESSIBILITY")
	private java.lang.Long accessibility;

	/**APP_ID*/
	@ApiModelProperty(value="APP_ID")
	private java.lang.Long appId;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private java.lang.Long version;
	private String[] resourceids;

}