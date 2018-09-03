package com.carloan.service.consumer.tccstudent.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:tcc_student
 *@author root
 *@version 1.0,
 *@date 2018-07-18 16:48:32
 */
@Getter
@Setter
public class TccStudentDTO implements Serializable{

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