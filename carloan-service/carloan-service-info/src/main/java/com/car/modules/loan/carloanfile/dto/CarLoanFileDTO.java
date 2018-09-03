package com.car.modules.loan.carloanfile.dto;

/**
 *@Description:申请人联系人信息
 *@author root
 *@version 1.0,
 *@date 2018-05-24 07:50:11
 */
public class CarLoanFileDTO {

	private static final long serialVersionUID = 1L;

	/**主键id*/
	private Long id;

	/**订单编号*/
	private String orderNumber;

	/**附件url*/
	private String fileUrl;

	/**历史url*/
	private String historyUrl;

	/**附件环节*/
	private String fileLink;

	/**附件类型*/
	private String attachType;

	/**附件名称*/
	private String fileName;

	/**附件类型明细*/
	private String fileAppendageType;

	/**附件归属类型编号*/
	private String fileAppendixTypeNumber;
	/**附件类型*/
	private String imgcode;
	/**创建时间*/
	private java.util.Date creationTime;

	/**修改时间*/
	private java.util.Date updateTime;

	private String Suffixname;

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
	 *方法: 获得fileUrl
	 *@return: java.lang.String  fileUrl
	 */
	public String getFileUrl(){
		return this.fileUrl;
	}

	/**
	 *方法: 设置fileUrl
	 *@param: java.lang.String  fileUrl
	 */
	public void setFileUrl(String fileUrl){
		this.fileUrl = fileUrl;
	}

	/**
	 *方法: 获得historyUrl
	 *@return: java.lang.String  historyUrl
	 */
	public String getHistoryUrl(){
		return this.historyUrl;
	}

	/**
	 *方法: 设置historyUrl
	 *@param: java.lang.String  historyUrl
	 */
	public void setHistoryUrl(String historyUrl){
		this.historyUrl = historyUrl;
	}

	/**
	 *方法: 获得fileLink
	 *@return: java.lang.String  fileLink
	 */
	public String getFileLink(){
		return this.fileLink;
	}

	/**
	 *方法: 设置fileLink
	 *@param: java.lang.String  fileLink
	 */
	public void setFileLink(String fileLink){
		this.fileLink = fileLink;
	}


	public String getAttachType() {
		return attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	/**
	 *方法: 获得fileName
	 *@return: java.lang.String  fileName
	 */
	public String getFileName(){
		return this.fileName;
	}

	/**
	 *方法: 设置fileName
	 *@param: java.lang.String  fileName
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	/**
	 *方法: 获得fileAppendageType
	 *@return: java.lang.String  fileAppendageType
	 */
	public String getFileAppendageType(){
		return this.fileAppendageType;
	}

	/**
	 *方法: 设置fileAppendageType
	 *@param: java.lang.String  fileAppendageType
	 */
	public void setFileAppendageType(String fileAppendageType){
		this.fileAppendageType = fileAppendageType;
	}

	/**
	 *方法: 获得fileAppendixTypeNumber
	 *@return: java.lang.String  fileAppendixTypeNumber
	 */
	public String getFileAppendixTypeNumber(){
		return this.fileAppendixTypeNumber;
	}

	/**
	 *方法: 设置fileAppendixTypeNumber
	 *@param: java.lang.String  fileAppendixTypeNumber
	 */
	public void setFileAppendixTypeNumber(String fileAppendixTypeNumber){
		this.fileAppendixTypeNumber = fileAppendixTypeNumber;
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

	public String getImgcode() {
		return imgcode;
	}

	public void setImgcode(String imgcode) {
		this.imgcode = imgcode;
	}

	public String getSuffixname() {
		return Suffixname;
	}

	public void setSuffixname(String suffixname) {
		Suffixname = suffixname;
	}
}