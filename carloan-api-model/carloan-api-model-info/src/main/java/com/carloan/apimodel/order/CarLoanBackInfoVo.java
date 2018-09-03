package com.carloan.apimodel.order;

/**
 *@Description:car_loan_back_info
 *@author root
 *@version 1.0,
 *@date 2018-06-04 04:21:08
 */
public class CarLoanBackInfoVo {

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**FK_INTO_CUST_REF_ID*/
	private Long fkIntoCustRefId;

	/**VALIDATE_STATE*/
	private String validateState;

	/**创建时间*/
	private java.util.Date createTime;

	/**修改时间*/
	private java.util.Date modifyTime;

	/**CREATE_BY*/
	private String createBy;

	/**MODIFY_BY*/
	private String modifyBy;

	/**STATUS*/
	private String status;

	/**EXT1*/
	private String ext1;

	/**EXT2*/
	private String ext2;

	/**ATTACH_NUMBER*/
	private String attachNumber;

	/**订单类型code*/
	private Integer ordertypecode;

	/**订单类型名称*/
	private String ordertypename;

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
	 *方法: 获得fkIntoCustRefId
	 *@return: java.lang.Long  fkIntoCustRefId
	 */
	public Long getFkIntoCustRefId(){
		return this.fkIntoCustRefId;
	}

	/**
	 *方法: 设置fkIntoCustRefId
	 *@param: java.lang.Long  fkIntoCustRefId
	 */
	public void setFkIntoCustRefId(Long fkIntoCustRefId){
		this.fkIntoCustRefId = fkIntoCustRefId;
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
	 *方法: 获得status
	 *@return: java.lang.String  status
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置status
	 *@param: java.lang.String  status
	 */
	public void setStatus(String status){
		this.status = status;
	}

	/**
	 *方法: 获得ext1
	 *@return: java.lang.String  ext1
	 */
	public String getExt1(){
		return this.ext1;
	}

	/**
	 *方法: 设置ext1
	 *@param: java.lang.String  ext1
	 */
	public void setExt1(String ext1){
		this.ext1 = ext1;
	}

	/**
	 *方法: 获得ext2
	 *@return: java.lang.String  ext2
	 */
	public String getExt2(){
		return this.ext2;
	}

	/**
	 *方法: 设置ext2
	 *@param: java.lang.String  ext2
	 */
	public void setExt2(String ext2){
		this.ext2 = ext2;
	}

	/**
	 *方法: 获得attachNumber
	 *@return: java.lang.String  attachNumber
	 */
	public String getAttachNumber(){
		return this.attachNumber;
	}

	/**
	 *方法: 设置attachNumber
	 *@param: java.lang.String  attachNumber
	 */
	public void setAttachNumber(String attachNumber){
		this.attachNumber = attachNumber;
	}

	/**
	 *方法: 获得ordertypecode
	 *@return: java.lang.Integer  ordertypecode
	 */
	public Integer getOrdertypecode(){
		return this.ordertypecode;
	}

	/**
	 *方法: 设置ordertypecode
	 *@param: java.lang.Integer  ordertypecode
	 */
	public void setOrdertypecode(Integer ordertypecode){
		this.ordertypecode = ordertypecode;
	}

	/**
	 *方法: 获得ordertypename
	 *@return: java.lang.String  ordertypename
	 */
	public String getOrdertypename(){
		return this.ordertypename;
	}

	/**
	 *方法: 设置ordertypename
	 *@param: java.lang.String  ordertypename
	 */
	public void setOrdertypename(String ordertypename){
		this.ordertypename = ordertypename;
	}

}