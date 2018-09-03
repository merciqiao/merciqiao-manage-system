package com.carloan.service.shiro.sysrole.dto;


/**
 *@Description:sys_role
 *@author root
 *@version 1.0,
 *@date 2018-06-22 02:10:07
 */
public class SysRoleDTO {

	private static final long serialVersionUID = 1L;

	/**主键*/
	private Long id;

	/**ROLE_NAME*/
	private String roleName;

	/**ROLE_CODE*/
	private String roleCode;

	/**ROLE_TYPE*/
	private String roleType;

	/**APP_ID*/
	private Long appId;

	/**VALIDATE_STATE*/
	private String validateState;

	/**VERSION*/
	private Long version;

	/*----扩展字段-----*/

	private Long target_id;
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
	 *方法: 获得roleName
	 *@return: java.lang.String  roleName
	 */
	public String getRoleName(){
		return this.roleName;
	}

	/**
	 *方法: 设置roleName
	 *@param: java.lang.String  roleName
	 */
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	/**
	 *方法: 获得roleCode
	 *@return: java.lang.String  roleCode
	 */
	public String getRoleCode(){
		return this.roleCode;
	}

	/**
	 *方法: 设置roleCode
	 *@param: java.lang.String  roleCode
	 */
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}

	/**
	 *方法: 获得roleType
	 *@return: java.lang.String  roleType
	 */
	public String getRoleType(){
		return this.roleType;
	}

	/**
	 *方法: 设置roleType
	 *@param: java.lang.String  roleType
	 */
	public void setRoleType(String roleType){
		this.roleType = roleType;
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

	public Long getTarget_id() {
		return target_id;
	}

	public void setTarget_id(Long target_id) {
		this.target_id = target_id;
	}
}