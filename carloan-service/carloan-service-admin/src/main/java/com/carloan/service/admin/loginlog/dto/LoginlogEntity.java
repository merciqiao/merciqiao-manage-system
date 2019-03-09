package com.carloan.service.admin.loginlog.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-01 22:54:18
 */
@Getter
@Setter
public class LoginlogEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private String city;

	private String ip;

	private Date createtime;

	private String type;


}
