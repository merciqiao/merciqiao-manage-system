package com.carloan.apimodel.tcc;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *@Description:tcc_course
 *@author root
 *@version 1.0,
 *@date 2018-07-18 16:54:13
 */
@Getter
@Setter
public class TccCourse implements Serializable{

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