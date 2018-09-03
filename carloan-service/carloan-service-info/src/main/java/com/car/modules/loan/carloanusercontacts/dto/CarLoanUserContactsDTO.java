package com.car.modules.loan.carloanusercontacts.dto;

import java.util.Date;

/**
 *@Description:申请人联系人信息
 *@author root
 *@version 1.0,
 */
public class CarLoanUserContactsDTO{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	private Long id;

	/**个人信息表ID*/
	private String orderNumber;

	/**订单编号*/
	private String carLoanUserId;

	/**和本人关系*/
	private String relationship;

	/**姓名*/
	private String name;

	/**联系电话*/
	private String contactNumber;

	/**联系人家庭住址或单位住址*/
	private String homeOrOfficeAddresses;

	/**工作单位名称*/
	private String workUnit;

	/**创建时间*/
	private Date creationTime;

	/**修改时间*/
	private Date updateTime;

	private Long carinfoid;

	public Long getCarinfoid() {
		return carinfoid;
	}

	public void setCarinfoid(Long carinfoid) {
		this.carinfoid = carinfoid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCarLoanUserId() {
		return carLoanUserId;
	}

	public void setCarLoanUserId(String carLoanUserId) {
		this.carLoanUserId = carLoanUserId;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getHomeOrOfficeAddresses() {
		return homeOrOfficeAddresses;
	}

	public void setHomeOrOfficeAddresses(String homeOrOfficeAddresses) {
		this.homeOrOfficeAddresses = homeOrOfficeAddresses;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}