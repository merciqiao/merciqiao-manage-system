package com.carloan.api.model.admin;


import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_role
 *@author root
 *@version 1.0,
 *@date 2018-07-06 15:26:11
 */
@Getter
@Setter
public class SysRoleVo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private java.lang.Long id;

	/**ROLE_NAME*/
	@ApiModelProperty(value="ROLE_NAME")
	private java.lang.String roleName;

	/**ROLE_CODE*/
	@ApiModelProperty(value="ROLE_CODE")
	private java.lang.String roleCode;

	/**ROLE_TYPE*/
	@ApiModelProperty(value="ROLE_TYPE")
	private java.lang.String roleType;

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