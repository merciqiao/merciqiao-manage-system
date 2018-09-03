package com.carloan.api.model.admin;

import com.carloan.apimodel.common.PageInfoExt;
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
public class SysUserParam extends PageInfoExt implements Serializable {

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


	/**MOBILE*/
	@ApiModelProperty(value="MOBILE")
	private java.lang.String mobile;


	/**SEX*/
	@ApiModelProperty(value="SEX")
	private java.lang.String sex;


	/**JOB*/
	@ApiModelProperty(value="JOB")
	private java.lang.String job;

	private Long orgid;
	private Long positionid;
}