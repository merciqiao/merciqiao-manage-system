package com.carloan.service.admin.sysrolemapping.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_role_mapping
 *@author root
 *@version 1.0,
 *@date 2018-07-18 11:03:12
 */
@Getter
@Setter
public class SysRoleMappingDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键ID*/
	@ApiModelProperty(value="主键ID")
	private java.lang.Long id;

	/**ROLE_CODE*/
	@ApiModelProperty(value="ROLE_CODE")
	private java.lang.String roleCode;

	/**MAPPING_ROLE_CODE*/
	@ApiModelProperty(value="MAPPING_ROLE_CODE")
	private java.lang.String mappingRoleCode;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

}