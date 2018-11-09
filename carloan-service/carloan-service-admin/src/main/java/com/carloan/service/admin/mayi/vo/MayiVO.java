package com.carloan.service.admin.mayi.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 19:39:19
 */
public class MayiVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String ip;
	//
	private String city;
	//
	private Date createtime;
	//
	private Integer weight;
	//
	private Integer copycount;
	//
	private Integer updatecount;
	//
	private Date updatetime;
	//
	private String code;

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
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：
	 */
	public String getCity() {
		return city;
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
	/**
	 * 设置：
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	/**
	 * 获取：
	 */
	public Integer getWeight() {
		return weight;
	}
	/**
	 * 设置：
	 */
	public void setCopycount(Integer copycount) {
		this.copycount = copycount;
	}
	/**
	 * 获取：
	 */
	public Integer getCopycount() {
		return copycount;
	}
	/**
	 * 设置：
	 */
	public void setUpdatecount(Integer updatecount) {
		this.updatecount = updatecount;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdatecount() {
		return updatecount;
	}
	/**
	 * 设置：
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：
	 */
	public String getCode() {
		return code;
	}
}
