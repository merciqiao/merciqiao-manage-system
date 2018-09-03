package com.carloan.service.master.sysdictdetail.dto;

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

	/**主键*/
	@ApiModelProperty(value="主键")
	private Long id;

	/**DICT_ID*/
	@ApiModelProperty(value="DICT_ID")
	private Long dictId;

	/**DICT_DETAIL_NAME*/
	@ApiModelProperty(value="DICT_DETAIL_NAME")
	private String dictDetailName;

	/**DICT_DETAIL_VALUE*/
	@ApiModelProperty(value="DICT_DETAIL_VALUE")
	private String dictDetailValue;

	/**ORDER_BY*/
	@ApiModelProperty(value="ORDER_BY")
	private String orderBy;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private String validateState;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private Long version;

	/**CREATION_TIME*/
	@ApiModelProperty(value="CREATION_TIME")
	private java.util.Date creationTime;

}