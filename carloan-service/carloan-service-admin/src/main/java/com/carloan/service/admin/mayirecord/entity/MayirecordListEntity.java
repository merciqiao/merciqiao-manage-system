package com.carloan.service.admin.mayirecord.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:37:38
 */
public class MayirecordListEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int page;
    private int rows;
    private int first;
	//
	private Integer id;
	//
	private String ip;
	//
	private Integer addid;
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
