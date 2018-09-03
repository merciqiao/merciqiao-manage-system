package com.carloan.service.provider01.tccteacher.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:tcc_teacher
 *@author root
 *@version 1.0,
 *@date 2018-07-18 16:51:51
 */
@Getter
@Setter
public class TccTeacherDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**id*/
	@ApiModelProperty(value="id")
	private Integer id;

	/**name*/
	@ApiModelProperty(value="name")
	private String name;

	/**city*/
	@ApiModelProperty(value="city")
	private String city;

	/**createtime*/
	@ApiModelProperty(value="createtime")
	private java.util.Date createtime;

}