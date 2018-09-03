package com.car.modules.loan.carloancalphonelog.dto;

/**
 *@Description:car_loan_cal_phone_log
 *@author root
 *@version 1.0,
 *@date 2018-06-07 23:29:04
 */
public class CarLoanCalPhoneLogDTO {

	private static final long serialVersionUID = 1L;

	/**主键id*/
	private Long id;

	/**订单编号*/
	private String orderNumber;

	/**电核列表联系人ID*/
	private Long surveyContactsId;

	/**CHECK_TIME*/
	private java.util.Date checkTime;

	/**CHECK_STATUS*/
	private String checkStatus;

	/**EXAMINE_STAGE*/
	private String examineStage;

	/**OWNER_ID*/
	private Long ownerId;

	/**ORG_ID*/
	private Long orgId;

	/**创建时间*/
	private java.util.Date createTime;

	/**修改时间*/
	private java.util.Date modifyTime;

	/**CREATE_BY*/
	private Long createBy;

	/**REMARK*/
	private String remark;

	/**
	 *方法: 获得id
	 *@return: java.lang.Long  id
	 */
	public Long getId(){
		return this.id;
	}

	/**
	 *方法: 设置id
	 *@param: java.lang.Long  id
	 */
	public void setId(Long id){
		this.id = id;
	}

	/**
	 *方法: 获得orderNumber
	 *@return: java.lang.String  orderNumber
	 */
	public String getOrderNumber(){
		return this.orderNumber;
	}

	/**
	 *方法: 设置orderNumber
	 *@param: java.lang.String  orderNumber
	 */
	public void setOrderNumber(String orderNumber){
		this.orderNumber = orderNumber;
	}

	/**
	 *方法: 获得surveyContactsId
	 *@return: java.lang.Long  surveyContactsId
	 */
	public Long getSurveyContactsId(){
		return this.surveyContactsId;
	}

	/**
	 *方法: 设置surveyContactsId
	 *@param: java.lang.Long  surveyContactsId
	 */
	public void setSurveyContactsId(Long surveyContactsId){
		this.surveyContactsId = surveyContactsId;
	}

	/**
	 *方法: 获得checkTime
	 *@return: java.util.Date  checkTime
	 */
	public java.util.Date getCheckTime(){
		return this.checkTime;
	}

	/**
	 *方法: 设置checkTime
	 *@param: java.util.Date  checkTime
	 */
	public void setCheckTime(java.util.Date checkTime){
		this.checkTime = checkTime;
	}

	/**
	 *方法: 获得checkStatus
	 *@return: java.lang.String  checkStatus
	 */
	public String getCheckStatus(){
		return this.checkStatus;
	}

	/**
	 *方法: 设置checkStatus
	 *@param: java.lang.String  checkStatus
	 */
	public void setCheckStatus(String checkStatus){
		this.checkStatus = checkStatus;
	}

	/**
	 *方法: 获得examineStage
	 *@return: java.lang.String  examineStage
	 */
	public String getExamineStage(){
		return this.examineStage;
	}

	/**
	 *方法: 设置examineStage
	 *@param: java.lang.String  examineStage
	 */
	public void setExamineStage(String examineStage){
		this.examineStage = examineStage;
	}

	/**
	 *方法: 获得ownerId
	 *@return: java.lang.Long  ownerId
	 */
	public Long getOwnerId(){
		return this.ownerId;
	}

	/**
	 *方法: 设置ownerId
	 *@param: java.lang.Long  ownerId
	 */
	public void setOwnerId(Long ownerId){
		this.ownerId = ownerId;
	}

	/**
	 *方法: 获得orgId
	 *@return: java.lang.Long  orgId
	 */
	public Long getOrgId(){
		return this.orgId;
	}

	/**
	 *方法: 设置orgId
	 *@param: java.lang.Long  orgId
	 */
	public void setOrgId(Long orgId){
		this.orgId = orgId;
	}

	/**
	 *方法: 获得createTime
	 *@return: java.util.Date  createTime
	 */
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置createTime
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	/**
	 *方法: 获得modifyTime
	 *@return: java.util.Date  modifyTime
	 */
	public java.util.Date getModifyTime(){
		return this.modifyTime;
	}

	/**
	 *方法: 设置modifyTime
	 *@param: java.util.Date  modifyTime
	 */
	public void setModifyTime(java.util.Date modifyTime){
		this.modifyTime = modifyTime;
	}

	/**
	 *方法: 获得createBy
	 *@return: java.lang.Long  createBy
	 */
	public Long getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置createBy
	 *@param: java.lang.Long  createBy
	 */
	public void setCreateBy(Long createBy){
		this.createBy = createBy;
	}

	/**
	 *方法: 获得remark
	 *@return: java.lang.String  remark
	 */
	public String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置remark
	 *@param: java.lang.String  remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}

}