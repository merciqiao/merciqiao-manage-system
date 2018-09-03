package com.carloan.apimodel.master.sysdict;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *@Description:sys_dict_detail
 *@author root
 *@version 1.0,
 *@date 2018-07-24 14:04:12
 */
@Getter
@Setter
public class SysDictDetailDTO extends PageInfoExt {

	private static final long serialVersionUID = 1L;


	/**DICT_ID*/
	@ApiModelProperty(value="DICT_ID")
	private Long dictId;

	/**DICT_DETAIL_NAME*/
	@ApiModelProperty(value="DICT_DETAIL_NAME")
	private String dictDetailName;

	/**DICT_DETAIL_VALUE*/
	@ApiModelProperty(value="DICT_DETAIL_VALUE")
	private String dictDetailValue;


}