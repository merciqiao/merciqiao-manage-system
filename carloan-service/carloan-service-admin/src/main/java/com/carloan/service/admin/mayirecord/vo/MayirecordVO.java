package com.carloan.service.admin.mayirecord.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:37:38
 */
public class MayirecordVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String ip;
	//
	private Integer addid;
	//
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
