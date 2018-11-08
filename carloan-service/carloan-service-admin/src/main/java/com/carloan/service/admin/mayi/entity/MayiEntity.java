package com.carloan.service.admin.mayi.entity;

import java.io.Serializable;
import java.util.Date;

import com.carloan.service.admin.mayi.groups.MayiAddGroup;
import com.carloan.service.admin.mayi.groups.MayiUpdateGroup;
import javax.validation.constraints.NotNull;
/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 19:39:19
 */
public class MayiEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "id不能为空") 
	private Integer id;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "ip不能为空") 
	private String ip;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "city不能为空") 
	private String city;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "createtime不能为空") 
	private Date createtime;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "weight不能为空") 
	private Integer weight=0;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "copycount不能为空") 
	private Integer copycount=0;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "updatecount不能为空") 
	private Integer updatecount=0;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "updatetime不能为空") 
	private Date updatetime;
	//
	@NotNull(groups = { MayiUpdateGroup.class,MayiAddGroup.class }, message = "code不能为空") 
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
