package com.carloan.service.admin.mayirecord.entity;

import java.io.Serializable;
import java.util.Date;

import com.carloan.service.admin.mayirecord.groups.MayirecordAddGroup;
import com.carloan.service.admin.mayirecord.groups.MayirecordUpdateGroup;
import javax.validation.constraints.NotNull;
/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:37:38
 */
public class MayirecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@NotNull(groups = { MayirecordUpdateGroup.class,MayirecordAddGroup.class }, message = "id不能为空") 
	private Integer id;
	//
	@NotNull(groups = { MayirecordUpdateGroup.class,MayirecordAddGroup.class }, message = "ip不能为空") 
	private String ip;
	//
	@NotNull(groups = { MayirecordUpdateGroup.class,MayirecordAddGroup.class }, message = "addid不能为空") 
	private Integer addid;
	//
	@NotNull(groups = { MayirecordUpdateGroup.class,MayirecordAddGroup.class }, message = "createtime不能为空") 
	private Date createtime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：
	 */
	public void setAddid(Integer addid) {
		this.addid = addid;
	}
	/**
	 * 获取：
	 */
	public Integer getAddid() {
		return addid;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
