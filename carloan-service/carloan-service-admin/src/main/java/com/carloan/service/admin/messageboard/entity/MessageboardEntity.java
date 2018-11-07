package com.carloan.service.admin.messageboard.entity;

import java.io.Serializable;
import java.util.Date;

import com.carloan.service.admin.messageboard.groups.MessageboardAddGroup;
import com.carloan.service.admin.messageboard.groups.MessageboardUpdateGroup;
import javax.validation.constraints.NotNull;
/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-04 16:20:40
 */
public class MessageboardEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "id不能为空")
	private Integer id;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "name不能为空")
	private String name;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "city不能为空")
	private String city;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "age不能为空")
	private Integer age;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "gender不能为空")
	private String gender;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "qq不能为空")
	private String qq;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "type不能为空")
	private Integer type;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "text不能为空")
	private String text;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "replytext不能为空")
	private String replytext;
	//
	//@NotNull(groups = { MessageboardUpdateGroup.class,MessageboardAddGroup.class }, message = "createtime不能为空")
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
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * 获取：
	 */
	public String getText() {
		return text;
	}
	/**
	 * 设置：
	 */
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	/**
	 * 获取：
	 */
	public String getReplytext() {
		return replytext;
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
