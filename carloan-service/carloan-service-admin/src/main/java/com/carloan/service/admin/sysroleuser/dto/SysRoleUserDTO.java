package com.carloan.service.admin.sysroleuser.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_role_user
 *@author root
 *@version 1.0,
 *@date 2018-07-06 15:17:47
 */
@Getter
@Setter
public class SysRoleUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private java.lang.Long id;

	/**ROLE_ID*/
	@ApiModelProperty(value="ROLE_ID")
	private java.lang.Long roleId;

	/**TARGET_ID*/
	@ApiModelProperty(value="TARGET_ID")
	private java.lang.Long targetId;

	/**UserName*/
	@ApiModelProperty(value="UserName")
	private java.lang.String userName;

	/**APP_ID*/
	@ApiModelProperty(value="APP_ID")
	private java.lang.Long appId;

	/**TARGET_TYPE*/
	@ApiModelProperty(value="TARGET_TYPE")
	private java.lang.String targetType;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private java.lang.Long version;

	@ApiModelProperty(value="角色编码")
	private java.lang.String roleCode;

	@ApiModelProperty(value="角色名称")
	private java.lang.String roleName;


}