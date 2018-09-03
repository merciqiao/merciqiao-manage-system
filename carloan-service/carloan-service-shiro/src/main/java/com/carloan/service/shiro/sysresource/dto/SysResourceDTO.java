package com.carloan.service.shiro.sysresource.dto;

/**
 *@Description:sys_resource
 *@author root
 *@version 1.0,
 *@date 2018-06-22 09:09:44
 */
public class SysResourceDTO {

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**RESOURE_NAME*/
	private String resoureName;

	/**RESOURE_TYPE*/
	private String resoureType;

	/**RESOURE_URL*/
	private String resoureUrl;

	/**PERMISSION*/
	private String permission;

	/**PARENT_ID*/
	private String parentId;

	/**PARENT_IDS*/
	private String parentIds;

	/**APP_ID*/
	private Long appId;

	/**VALIDATE_STATE*/
	private String validateState;

	/**VERSION*/
	private Long version;

	/*扩展字段*/
	/*角色编码*/
	private String role_code;
	/*用户id*/
	private Long userId;

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
	 *方法: 获得resoureName
	 *@return: java.lang.String  resoureName
	 */
	public String getResoureName(){
		return this.resoureName;
	}

	/**
	 *方法: 设置resoureName
	 *@param: java.lang.String  resoureName
	 */
	public void setResoureName(String resoureName){
		this.resoureName = resoureName;
	}

	/**
	 *方法: 获得resoureType
	 *@return: java.lang.String  resoureType
	 */
	public String getResoureType(){
		return this.resoureType;
	}

	/**
	 *方法: 设置resoureType
	 *@param: java.lang.String  resoureType
	 */
	public void setResoureType(String resoureType){
		this.resoureType = resoureType;
	}

	/**
	 *方法: 获得resoureUrl
	 *@return: java.lang.String  resoureUrl
	 */
	public String getResoureUrl(){
		return this.resoureUrl;
	}

	/**
	 *方法: 设置resoureUrl
	 *@param: java.lang.String  resoureUrl
	 */
	public void setResoureUrl(String resoureUrl){
		this.resoureUrl = resoureUrl;
	}

	/**
	 *方法: 获得permission
	 *@return: java.lang.String  permission
	 */
	public String getPermission(){
		return this.permission;
	}

	/**
	 *方法: 设置permission
	 *@param: java.lang.String  permission
	 */
	public void setPermission(String permission){
		this.permission = permission;
	}

	/**
	 *方法: 获得parentId
	 *@return: java.lang.String  parentId
	 */
	public String getParentId(){
		return this.parentId;
	}

	/**
	 *方法: 设置parentId
	 *@param: java.lang.String  parentId
	 */
	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	/**
	 *方法: 获得parentIds
	 *@return: java.lang.String  parentIds
	 */
	public String getParentIds(){
		return this.parentIds;
	}

	/**
	 *方法: 设置parentIds
	 *@param: java.lang.String  parentIds
	 */
	public void setParentIds(String parentIds){
		this.parentIds = parentIds;
	}

	/**
	 *方法: 获得appId
	 *@return: java.lang.Long  appId
	 */
	public Long getAppId(){
		return this.appId;
	}

	/**
	 *方法: 设置appId
	 *@param: java.lang.Long  appId
	 */
	public void setAppId(Long appId){
		this.appId = appId;
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

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}