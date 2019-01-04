package com.carloan.service.admin.msg.entity;

import com.carloan.apimodel.common.PageInfoExt;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-12-15 22:29:54
 */
public class MsgEntity extends PageInfoExt implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "id不能为空")
	private Integer id;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "name不能为空")
	private String name;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "city不能为空")
	private String city;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "type不能为空")
	private String type;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "age不能为空")
	private Integer age;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "gender不能为空")
	private Integer gender;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "qq不能为空")
	private Integer qq;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "createtime不能为空")
	private Date createtime;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "updatetime不能为空")
	private Date updatetime;
	//
	//@NotNull(groups = { MsgUpdateGroup.class,MsgAddGroup.class }, message = "isdelte不能为空")
	private Integer isdelte;

	private Integer[] ids;

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}





	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	private Date startdate;

	private Date enddate;

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}



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
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * 获取：
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * 设置：
	 */
	public void setQq(Integer qq) {
		this.qq = qq;
	}
	/**
	 * 获取：
	 */
	public Integer getQq() {
		return qq;
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
	 * 设置：
	 */
	public void setIsdelte(Integer isdelte) {
		this.isdelte = isdelte;
	}
	/**
	 * 获取：
	 */
	public Integer getIsdelte() {
		return isdelte;
	}
}
