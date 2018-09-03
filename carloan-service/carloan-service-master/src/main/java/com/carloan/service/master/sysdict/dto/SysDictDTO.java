package com.carloan.service.master.sysdict.dto;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 *@Description:sys_dict
 *@author root
 *@version 1.0,
 *@date 2018-07-24 13:19:18
 */
@Getter
@Setter
public class SysDictDTO extends PageInfoExt{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private java.lang.Long id;

	/**DICT_CODE*/
	@ApiModelProperty(value="DICT_CODE")
	private java.lang.String dictCode;

	/**DICT_NAME*/
	@ApiModelProperty(value="DICT_NAME")
	private java.lang.String dictName;

	/**DICT_TYPE*/
	@ApiModelProperty(value="DICT_TYPE")
	private java.lang.String dictType;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private java.lang.Long version;

}