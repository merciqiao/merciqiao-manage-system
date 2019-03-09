package com.carloan.service.admin.ycyscore.entity;

import java.io.Serializable;
import java.util.Date;

import com.carloan.apimodel.common.PageInfoExt;
import com.carloan.service.admin.ycyscore.groups.YcyscoreAddGroup;
import com.carloan.service.admin.ycyscore.groups.YcyscoreUpdateGroup;
import javax.validation.constraints.NotNull;
/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2019-03-09 14:21:07
 */
public class YcyscoreEntity extends PageInfoExt implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "id不能为空")
	private Integer id;
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "city不能为空")
	private String city;
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "ip不能为空")
	private String ip;
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "name不能为空")
	private String name;
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "score不能为空")
	private Integer score;
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "wxname不能为空")
	private String wxname;
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "createtime不能为空")
	private Date createtime;
	//
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "updatetime不能为空")
	private Date updatetime;
	//次数
	//@NotNull(groups = { YcyscoreUpdateGroup.class,YcyscoreAddGroup.class }, message = "times不能为空")
	private Integer times;

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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * 获取：
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * 设置：
	 */
	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	/**
	 * 获取：
	 */
	public String getWxname() {
		return wxname;
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
	 * 设置：次数
	 */
	public void setTimes(Integer times) {
		this.times = times;
	}
	/**
	 * 获取：次数
	 */
	public Integer getTimes() {
		return times;
	}
}
