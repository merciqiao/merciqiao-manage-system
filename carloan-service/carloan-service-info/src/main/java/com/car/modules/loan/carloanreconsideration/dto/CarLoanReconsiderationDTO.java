package com.car.modules.loan.carloanreconsideration.dto;

/**
 *@Description:车贷复议表
 *@author root
 *@version 1.0,
 *@date 2018-05-28 01:51:28
 */
public class CarLoanReconsiderationDTO{

	private static final long serialVersionUID = 1L;

	/**主键id*/
	private Long id;

	/**订单编号*/
	private String orderNumber;

	/**合同金额*/
	private String contractAmount;

	/**产品类型*/
	private String productType;

	/**还款方式*/
	private String repaymentMethod;

	/**审批期数*/
	private String approvalPeriod;

	/**是否同意过户的勾选*/
	private String ifTransfer;

	/**审核备注*/
	private String examineRemarks;

	/**复议备注*/
	private String fuyiRemarks;

	/**创建时间*/
	private java.util.Date creationTime;

	/**修改时间*/
	private java.util.Date updateTime;

	/**审核状态*/
	private String auditeState;

	/**操作人id*/
	private Long operateUser;
	/**复议金额*/
	private String fuyiAmount;
	/**复议期限*/
	private String fuyiPeriod;

	public Long getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(Long operateUser) {
		this.operateUser = operateUser;
	}

	public String getAuditeState() {
		return auditeState;
	}

	public void setAuditeState(String auditeState) {
		this.auditeState = auditeState;
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
	 *方法: 获得contractAmount
	 *@return: java.lang.String  contractAmount
	 */
	public String getContractAmount(){
		return this.contractAmount;
	}

	/**
	 *方法: 设置contractAmount
	 *@param: java.lang.String  contractAmount
	 */
	public void setContractAmount(String contractAmount){
		this.contractAmount = contractAmount;
	}

	/**
	 *方法: 获得productType
	 *@return: java.lang.String  productType
	 */
	public String getProductType(){
		return this.productType;
	}

	/**
	 *方法: 设置productType
	 *@param: java.lang.String  productType
	 */
	public void setProductType(String productType){
		this.productType = productType;
	}

	/**
	 *方法: 获得repaymentMethod
	 *@return: java.lang.String  repaymentMethod
	 */
	public String getRepaymentMethod(){
		return this.repaymentMethod;
	}

	/**
	 *方法: 设置repaymentMethod
	 *@param: java.lang.String  repaymentMethod
	 */
	public void setRepaymentMethod(String repaymentMethod){
		this.repaymentMethod = repaymentMethod;
	}

	/**
	 *方法: 获得approvalPeriod
	 *@return: java.lang.String  approvalPeriod
	 */
	public String getApprovalPeriod(){
		return this.approvalPeriod;
	}

	/**
	 *方法: 设置approvalPeriod
	 *@param: java.lang.String  approvalPeriod
	 */
	public void setApprovalPeriod(String approvalPeriod){
		this.approvalPeriod = approvalPeriod;
	}

	/**
	 *方法: 获得ifTransfer
	 *@return: java.lang.String  ifTransfer
	 */
	public String getIfTransfer(){
		return this.ifTransfer;
	}

	/**
	 *方法: 设置ifTransfer
	 *@param: java.lang.String  ifTransfer
	 */
	public void setIfTransfer(String ifTransfer){
		this.ifTransfer = ifTransfer;
	}

	/**
	 *方法: 获得examineRemarks
	 *@return: java.lang.String  examineRemarks
	 */
	public String getExamineRemarks(){
		return this.examineRemarks;
	}

	/**
	 *方法: 设置examineRemarks
	 *@param: java.lang.String  examineRemarks
	 */
	public void setExamineRemarks(String examineRemarks){
		this.examineRemarks = examineRemarks;
	}

	/**
	 *方法: 获得fuyiRemarks
	 *@return: java.lang.String  fuyiRemarks
	 */
	public String getFuyiRemarks(){
		return this.fuyiRemarks;
	}

	/**
	 *方法: 设置fuyiRemarks
	 *@param: java.lang.String  fuyiRemarks
	 */
	public void setFuyiRemarks(String fuyiRemarks){
		this.fuyiRemarks = fuyiRemarks;
	}

	/**
	 *方法: 获得creationTime
	 *@return: java.util.Date  creationTime
	 */
	public java.util.Date getCreationTime(){
		return this.creationTime;
	}

	/**
	 *方法: 设置creationTime
	 *@param: java.util.Date  creationTime
	 */
	public void setCreationTime(java.util.Date creationTime){
		this.creationTime = creationTime;
	}

	/**
	 *方法: 获得updateTime
	 *@return: java.util.Date  updateTime
	 */
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置updateTime
	 *@param: java.util.Date  updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}

	public String getFuyiAmount() {
		return fuyiAmount;
	}

	public void setFuyiAmount(String fuyiAmount) {
		this.fuyiAmount = fuyiAmount;
	}

	public String getFuyiPeriod() {
		return fuyiPeriod;
	}

	public void setFuyiPeriod(String fuyiPeriod) {
		this.fuyiPeriod = fuyiPeriod;
	}


}