package com.carloan.service.admin.messageboard.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-04 16:20:40
 */
public class MessageboardListEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int page;
    private int rows;
    private int first;
	//
	private Integer id;
	//
	private String name;
	//
	private String city;
	//
	private Integer age;
	//
	private String gender;
	//
	private String qq;
	//
	private Integer type;
	//
	private String text;
	//
	private String replytext;
	//
	private Date createtime;
 	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
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
