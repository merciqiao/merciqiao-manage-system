package com.carloan.apimodel.master.sysdict;

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
public class SysDictDTO extends PageInfoExt {

	private static final long serialVersionUID = 1L;

	/**DICT_CODE*/
	@ApiModelProperty(value="DICT_CODE")
	private String dictCode;

	/**DICT_NAME*/
	@ApiModelProperty(value="DICT_NAME")
	private String dictName;


}