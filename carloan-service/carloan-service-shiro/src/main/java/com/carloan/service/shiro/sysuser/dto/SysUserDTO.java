package com.carloan.service.shiro.sysuser.dto;

/**
 *@Description:sys_user
 *@author root
 *@version 1.0,
 *@date 2018-06-20 23:14:46
 */
public class SysUserDTO{

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**USER_NAME*/
	private String userName;

	/**USER_NO*/
	private String userNo;

	/**LOGIN_NAME*/
	private String loginName;

	/**PASSWORD*/
	private String password;

	/**SALT*/
	private String salt;

	/**MOBILE*/
	private String mobile;

	/**EMAIL*/
	private String email;

	/**USER_IMAGE*/
	private String userImage;

	/**SEX*/
	private String sex;

	/**BIRTHDAY*/
	private String birthday;

	/**NATIONALITY*/
	private String nationality;

	/**EDUCATION*/
	private String education;

	/**JOB*/
	private String job;

	/**HOME_ADDRESS*/
	private String homeAddress;

	/**HOME_ZIPCODE*/
	private String homeZipcode;

	/**HOME_TEL*/
	private String homeTel;

	/**OFFICE_TEL*/
	private String officeTel;

	/**OFFICE_ADDRESS*/
	private String officeAddress;

	/**ORDER_BY*/
	private String orderBy;

	/**VALIDATE_STATE*/
	private String validateState;

	/**IS_LOCKED*/
	private String isLocked;

	/**VERSION*/
	private Long version;

	/**创建时间*/
	private java.util.Date createDate;

	/**CARD_NO*/
	private String cardNo;

	/**PROBATION_PERIOD*/
	private Long probationPeriod;

	/**入职日期*/
	private java.util.Date entryDate;

	/**离职日期*/
	private java.util.Date quitDate;

	/**参加工作日期*/
	private java.util.Date workDate;

	/**POLITICAL_STATUS*/
	private String politicalStatus;

	/**USER_RELATION*/
	private String userRelation;

	/**ANNUAL_LEAVE*/
	private Long annualLeave;

	/**JXZJ*/
	private String jxzj;

	/**NJQSRQ*/
	private java.util.Date njqsrq;

	/**UUID*/
	private String uuid;

	/* 组织id */
	private String orgId;

	/* 组织名称 */
	private String orgName;

	/* 父级组织id */
	private String orgParentId;

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/* 职位名称 */
	private String positionName;

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
	 *方法: 获得userName
	 *@return: java.lang.String  userName
	 */
	public String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置userName
	 *@param: java.lang.String  userName
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}

	/**
	 *方法: 获得userNo
	 *@return: java.lang.String  userNo
	 */
	public String getUserNo(){
		return this.userNo;
	}

	/**
	 *方法: 设置userNo
	 *@param: java.lang.String  userNo
	 */
	public void setUserNo(String userNo){
		this.userNo = userNo;
	}

	/**
	 *方法: 获得loginName
	 *@return: java.lang.String  loginName
	 */
	public String getLoginName(){
		return this.loginName;
	}

	/**
	 *方法: 设置loginName
	 *@param: java.lang.String  loginName
	 */
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}

	/**
	 *方法: 获得password
	 *@return: java.lang.String  password
	 */
	public String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置password
	 *@param: java.lang.String  password
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 *方法: 获得salt
	 *@return: java.lang.String  salt
	 */
	public String getSalt(){
		return this.salt;
	}

	/**
	 *方法: 设置salt
	 *@param: java.lang.String  salt
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}

	/**
	 *方法: 获得mobile
	 *@return: java.lang.String  mobile
	 */
	public String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置mobile
	 *@param: java.lang.String  mobile
	 */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	/**
	 *方法: 获得email
	 *@return: java.lang.String  email
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置email
	 *@param: java.lang.String  email
	 */
	public void setEmail(String email){
		this.email = email;
	}

	/**
	 *方法: 获得userImage
	 *@return: java.lang.String  userImage
	 */
	public String getUserImage(){
		return this.userImage;
	}

	/**
	 *方法: 设置userImage
	 *@param: java.lang.String  userImage
	 */
	public void setUserImage(String userImage){
		this.userImage = userImage;
	}

	/**
	 *方法: 获得sex
	 *@return: java.lang.String  sex
	 */
	public String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置sex
	 *@param: java.lang.String  sex
	 */
	public void setSex(String sex){
		this.sex = sex;
	}

	/**
	 *方法: 获得birthday
	 *@return: java.lang.String  birthday
	 */
	public String getBirthday(){
		return this.birthday;
	}

	/**
	 *方法: 设置birthday
	 *@param: java.lang.String  birthday
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	/**
	 *方法: 获得nationality
	 *@return: java.lang.String  nationality
	 */
	public String getNationality(){
		return this.nationality;
	}

	/**
	 *方法: 设置nationality
	 *@param: java.lang.String  nationality
	 */
	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	/**
	 *方法: 获得education
	 *@return: java.lang.String  education
	 */
	public String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置education
	 *@param: java.lang.String  education
	 */
	public void setEducation(String education){
		this.education = education;
	}

	/**
	 *方法: 获得job
	 *@return: java.lang.String  job
	 */
	public String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置job
	 *@param: java.lang.String  job
	 */
	public void setJob(String job){
		this.job = job;
	}

	/**
	 *方法: 获得homeAddress
	 *@return: java.lang.String  homeAddress
	 */
	public String getHomeAddress(){
		return this.homeAddress;
	}

	/**
	 *方法: 设置homeAddress
	 *@param: java.lang.String  homeAddress
	 */
	public void setHomeAddress(String homeAddress){
		this.homeAddress = homeAddress;
	}

	/**
	 *方法: 获得homeZipcode
	 *@return: java.lang.String  homeZipcode
	 */
	public String getHomeZipcode(){
		return this.homeZipcode;
	}

	/**
	 *方法: 设置homeZipcode
	 *@param: java.lang.String  homeZipcode
	 */
	public void setHomeZipcode(String homeZipcode){
		this.homeZipcode = homeZipcode;
	}

	/**
	 *方法: 获得homeTel
	 *@return: java.lang.String  homeTel
	 */
	public String getHomeTel(){
		return this.homeTel;
	}

	/**
	 *方法: 设置homeTel
	 *@param: java.lang.String  homeTel
	 */
	public void setHomeTel(String homeTel){
		this.homeTel = homeTel;
	}

	/**
	 *方法: 获得officeTel
	 *@return: java.lang.String  officeTel
	 */
	public String getOfficeTel(){
		return this.officeTel;
	}

	/**
	 *方法: 设置officeTel
	 *@param: java.lang.String  officeTel
	 */
	public void setOfficeTel(String officeTel){
		this.officeTel = officeTel;
	}

	/**
	 *方法: 获得officeAddress
	 *@return: java.lang.String  officeAddress
	 */
	public String getOfficeAddress(){
		return this.officeAddress;
	}

	/**
	 *方法: 设置officeAddress
	 *@param: java.lang.String  officeAddress
	 */
	public void setOfficeAddress(String officeAddress){
		this.officeAddress = officeAddress;
	}

	/**
	 *方法: 获得orderBy
	 *@return: java.lang.String  orderBy
	 */
	public String getOrderBy(){
		return this.orderBy;
	}

	/**
	 *方法: 设置orderBy
	 *@param: java.lang.String  orderBy
	 */
	public void setOrderBy(String orderBy){
		this.orderBy = orderBy;
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
	 *方法: 获得isLocked
	 *@return: java.lang.String  isLocked
	 */
	public String getIsLocked(){
		return this.isLocked;
	}

	/**
	 *方法: 设置isLocked
	 *@param: java.lang.String  isLocked
	 */
	public void setIsLocked(String isLocked){
		this.isLocked = isLocked;
	}

	/**
	 *方法: 获得version
	 *@return: java.lang.Long  version
	 */
	public Long getVersion(){
		return this.version;
	}

	/**
	 *方法: 设置version
	 *@param: java.lang.Long  version
	 */
	public void setVersion(Long version){
		this.version = version;
	}

	/**
	 *方法: 获得createDate
	 *@return: java.util.Date  createDate
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置createDate
	 *@param: java.util.Date  createDate
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}

	/**
	 *方法: 获得cardNo
	 *@return: java.lang.String  cardNo
	 */
	public String getCardNo(){
		return this.cardNo;
	}

	/**
	 *方法: 设置cardNo
	 *@param: java.lang.String  cardNo
	 */
	public void setCardNo(String cardNo){
		this.cardNo = cardNo;
	}

	/**
	 *方法: 获得probationPeriod
	 *@return: java.lang.Long  probationPeriod
	 */
	public Long getProbationPeriod(){
		return this.probationPeriod;
	}

	/**
	 *方法: 设置probationPeriod
	 *@param: java.lang.Long  probationPeriod
	 */
	public void setProbationPeriod(Long probationPeriod){
		this.probationPeriod = probationPeriod;
	}

	/**
	 *方法: 获得entryDate
	 *@return: java.util.Date  entryDate
	 */
	public java.util.Date getEntryDate(){
		return this.entryDate;
	}

	/**
	 *方法: 设置entryDate
	 *@param: java.util.Date  entryDate
	 */
	public void setEntryDate(java.util.Date entryDate){
		this.entryDate = entryDate;
	}

	/**
	 *方法: 获得quitDate
	 *@return: java.util.Date  quitDate
	 */
	public java.util.Date getQuitDate(){
		return this.quitDate;
	}

	/**
	 *方法: 设置quitDate
	 *@param: java.util.Date  quitDate
	 */
	public void setQuitDate(java.util.Date quitDate){
		this.quitDate = quitDate;
	}

	/**
	 *方法: 获得workDate
	 *@return: java.util.Date  workDate
	 */
	public java.util.Date getWorkDate(){
		return this.workDate;
	}

	/**
	 *方法: 设置workDate
	 *@param: java.util.Date  workDate
	 */
	public void setWorkDate(java.util.Date workDate){
		this.workDate = workDate;
	}

	/**
	 *方法: 获得politicalStatus
	 *@return: java.lang.String  politicalStatus
	 */
	public String getPoliticalStatus(){
		return this.politicalStatus;
	}

	/**
	 *方法: 设置politicalStatus
	 *@param: java.lang.String  politicalStatus
	 */
	public void setPoliticalStatus(String politicalStatus){
		this.politicalStatus = politicalStatus;
	}

	/**
	 *方法: 获得userRelation
	 *@return: java.lang.String  userRelation
	 */
	public String getUserRelation(){
		return this.userRelation;
	}

	/**
	 *方法: 设置userRelation
	 *@param: java.lang.String  userRelation
	 */
	public void setUserRelation(String userRelation){
		this.userRelation = userRelation;
	}

	/**
	 *方法: 获得annualLeave
	 *@return: java.lang.Long  annualLeave
	 */
	public Long getAnnualLeave(){
		return this.annualLeave;
	}

	/**
	 *方法: 设置annualLeave
	 *@param: java.lang.Long  annualLeave
	 */
	public void setAnnualLeave(Long annualLeave){
		this.annualLeave = annualLeave;
	}

	/**
	 *方法: 获得jxzj
	 *@return: java.lang.String  jxzj
	 */
	public String getJxzj(){
		return this.jxzj;
	}

	/**
	 *方法: 设置jxzj
	 *@param: java.lang.String  jxzj
	 */
	public void setJxzj(String jxzj){
		this.jxzj = jxzj;
	}

	/**
	 *方法: 获得njqsrq
	 *@return: java.util.Date  njqsrq
	 */
	public java.util.Date getNjqsrq(){
		return this.njqsrq;
	}

	/**
	 *方法: 设置njqsrq
	 *@param: java.util.Date  njqsrq
	 */
	public void setNjqsrq(java.util.Date njqsrq){
		this.njqsrq = njqsrq;
	}

	/**
	 *方法: 获得uuid
	 *@return: java.lang.String  uuid
	 */
	public String getUuid(){
		return this.uuid;
	}

	/**
	 *方法: 设置uuid
	 *@param: java.lang.String  uuid
	 */
	public void setUuid(String uuid){
		this.uuid = uuid;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgParentId() {
		return orgParentId;
	}

	public void setOrgParentId(String orgParentId) {
		this.orgParentId = orgParentId;
	}
}