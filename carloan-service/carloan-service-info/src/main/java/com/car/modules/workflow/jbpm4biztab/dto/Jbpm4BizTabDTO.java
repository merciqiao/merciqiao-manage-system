package com.car.modules.workflow.jbpm4biztab.dto;

/**
 *@Description:jbpm4_biz_tab
 *@author root
 *@version 1.0,
 *@date 2018-06-27 05:16:35
 */
public class Jbpm4BizTabDTO {

	private static final long serialVersionUID = 1L;

	/**主键ID*/
	private Long id;

	/**BIZ_TAB_NAME*/
	private String bizTabName;

	/**BIZ_TYPE*/
	private String bizType;

	/**BIZ_INF_ID*/
	private String bizInfId;

	/**BIZ_INF_NAME*/
	private String bizInfName;

	/**BIZ_TASK_TYPE*/
	private String bizTaskType;

	/**PRO_INSTANCE_ID*/
	private String proInstanceId;

	/**START_PRO_USERID*/
	private String startProUserid;

	/**PRO_INSTANCE_STATE*/
	private String proInstanceState;

	/**TASK_STATE*/
	private String taskState;

	/**VALIDATE_STATE*/
	private String validateState;

	/**OWNER_ID*/
	private String ownerId;

	/**ORG_ID*/
	private String orgId;

	/**创建时间*/
	private java.util.Date createTime;

	/**修改时间*/
	private java.util.Date modifyTime;

	/**CREATE_BY*/
	private String createBy;

	/**MODIFY_BY*/
	private String modifyBy;

	/**REMARK*/
	private String remark;

	/**IS_HIDDEN*/
	private String isHidden;

	/**BIZ_INF_NO*/
	private String bizInfNo;

	/**超时提醒时间*/
	private java.util.Date overTime;

	/**提醒时间*/
	private java.util.Date remindTime;

	/**是否结束标示*/
	private Integer isOver;

	public Integer getIsOver() {
		return isOver;
	}

	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
	}






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
	 *方法: 获得bizTabName
	 *@return: java.lang.String  bizTabName
	 */
	public String getBizTabName(){
		return this.bizTabName;
	}

	/**
	 *方法: 设置bizTabName
	 *@param: java.lang.String  bizTabName
	 */
	public void setBizTabName(String bizTabName){
		this.bizTabName = bizTabName;
	}

	/**
	 *方法: 获得bizType
	 *@return: java.lang.String  bizType
	 */
	public String getBizType(){
		return this.bizType;
	}

	/**
	 *方法: 设置bizType
	 *@param: java.lang.String  bizType
	 */
	public void setBizType(String bizType){
		this.bizType = bizType;
	}

	/**
	 *方法: 获得bizInfId
	 *@return: java.lang.String  bizInfId
	 */
	public String getBizInfId(){
		return this.bizInfId;
	}

	/**
	 *方法: 设置bizInfId
	 *@param: java.lang.String  bizInfId
	 */
	public void setBizInfId(String bizInfId){
		this.bizInfId = bizInfId;
	}

	/**
	 *方法: 获得bizInfName
	 *@return: java.lang.String  bizInfName
	 */
	public String getBizInfName(){
		return this.bizInfName;
	}

	/**
	 *方法: 设置bizInfName
	 *@param: java.lang.String  bizInfName
	 */
	public void setBizInfName(String bizInfName){
		this.bizInfName = bizInfName;
	}

	/**
	 *方法: 获得bizTaskType
	 *@return: java.lang.String  bizTaskType
	 */
	public String getBizTaskType(){
		return this.bizTaskType;
	}

	/**
	 *方法: 设置bizTaskType
	 *@param: java.lang.String  bizTaskType
	 */
	public void setBizTaskType(String bizTaskType){
		this.bizTaskType = bizTaskType;
	}

	/**
	 *方法: 获得proInstanceId
	 *@return: java.lang.String  proInstanceId
	 */
	public String getProInstanceId(){
		return this.proInstanceId;
	}

	/**
	 *方法: 设置proInstanceId
	 *@param: java.lang.String  proInstanceId
	 */
	public void setProInstanceId(String proInstanceId){
		this.proInstanceId = proInstanceId;
	}

	/**
	 *方法: 获得startProUserid
	 *@return: java.lang.String  startProUserid
	 */
	public String getStartProUserid(){
		return this.startProUserid;
	}

	/**
	 *方法: 设置startProUserid
	 *@param: java.lang.String  startProUserid
	 */
	public void setStartProUserid(String startProUserid){
		this.startProUserid = startProUserid;
	}

	/**
	 *方法: 获得proInstanceState
	 *@return: java.lang.String  proInstanceState
	 */
	public String getProInstanceState(){
		return this.proInstanceState;
	}

	/**
	 *方法: 设置proInstanceState
	 *@param: java.lang.String  proInstanceState
	 */
	public void setProInstanceState(String proInstanceState){
		this.proInstanceState = proInstanceState;
	}

	/**
	 *方法: 获得taskState
	 *@return: java.lang.String  taskState
	 */
	public String getTaskState(){
		return this.taskState;
	}

	/**
	 *方法: 设置taskState
	 *@param: java.lang.String  taskState
	 */
	public void setTaskState(String taskState){
		this.taskState = taskState;
	}

	/**
	 *方法: 获得validateState
	 *@return: java.lang.String  validateState
	 */
	public String getValidateState(){
		return this.validateState;
	}

	/**
	 *方法: 设置validateState
	 *@param: java.lang.String  validateState
	 */
	public void setValidateState(String validateState){
		this.validateState = validateState;
	}

	/**
	 *方法: 获得ownerId
	 *@return: java.lang.String  ownerId
	 */
	public String getOwnerId(){
		return this.ownerId;
	}

	/**
	 *方法: 设置ownerId
	 *@param: java.lang.String  ownerId
	 */
	public void setOwnerId(String ownerId){
		this.ownerId = ownerId;
	}

	/**
	 *方法: 获得orgId
	 *@return: java.lang.String  orgId
	 */
	public String getOrgId(){
		return this.orgId;
	}

	/**
	 *方法: 设置orgId
	 *@param: java.lang.String  orgId
	 */
	public void setOrgId(String orgId){
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
	 *@return: java.lang.String  createBy
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置createBy
	 *@param: java.lang.String  createBy
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}

	/**
	 *方法: 获得modifyBy
	 *@return: java.lang.String  modifyBy
	 */
	public String getModifyBy(){
		return this.modifyBy;
	}

	/**
	 *方法: 设置modifyBy
	 *@param: java.lang.String  modifyBy
	 */
	public void setModifyBy(String modifyBy){
		this.modifyBy = modifyBy;
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

	/**
	 *方法: 获得isHidden
	 *@return: java.lang.String  isHidden
	 */
	public String getIsHidden(){
		return this.isHidden;
	}

	/**
	 *方法: 设置isHidden
	 *@param: java.lang.String  isHidden
	 */
	public void setIsHidden(String isHidden){
		this.isHidden = isHidden;
	}

	/**
	 *方法: 获得bizInfNo
	 *@return: java.lang.String  bizInfNo
	 */
	public String getBizInfNo(){
		return this.bizInfNo;
	}

	/**
	 *方法: 设置bizInfNo
	 *@param: java.lang.String  bizInfNo
	 */
	public void setBizInfNo(String bizInfNo){
		this.bizInfNo = bizInfNo;
	}

	/**
	 *方法: 获得overTime
	 *@return: java.util.Date  overTime
	 */
	public java.util.Date getOverTime(){
		return this.overTime;
	}

	/**
	 *方法: 设置overTime
	 *@param: java.util.Date  overTime
	 */
	public void setOverTime(java.util.Date overTime){
		this.overTime = overTime;
	}

	/**
	 *方法: 获得remindTime
	 *@return: java.util.Date  remindTime
	 */
	public java.util.Date getRemindTime(){
		return this.remindTime;
	}

	/**
	 *方法: 设置remindTime
	 *@param: java.util.Date  remindTime
	 */
	public void setRemindTime(java.util.Date remindTime){
		this.remindTime = remindTime;
	}

}