package com.carloan.service.admin.ycyscore.entity;

import com.carloan.apimodel.common.PageInfoExt;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2019-03-09 14:21:07
 */
@Getter
@Setter
public class YcyscoretotalEntity extends PageInfoExt implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String ip;
	private String city;
	private Integer score;
	private Date createtime;
	private Date updatetime;
	private Integer isdelete;
}
