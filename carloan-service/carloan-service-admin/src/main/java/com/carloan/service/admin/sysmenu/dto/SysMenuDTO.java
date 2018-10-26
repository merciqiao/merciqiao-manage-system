package com.carloan.service.admin.sysmenu.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:sys_menu
 *@author root
 *@version 1.0,
 *@date 2018-07-18 10:24:16
 */
@Getter
@Setter
public class SysMenuDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private java.lang.Long id;

	/**MENU_CODE*/
	@ApiModelProperty(value="MENU_CODE")
	private java.lang.String menuCode;

	/**MENU_NAME*/
	@ApiModelProperty(value="MENU_NAME")
	private java.lang.String menuName;

	/**MENU_ICON*/
	@ApiModelProperty(value="MENU_ICON")
	private java.lang.String menuIcon;

	/**MENU_URL*/
	@ApiModelProperty(value="MENU_URL")
	private java.lang.String menuUrl;

	/**PARENT_ID*/
	@ApiModelProperty(value="PARENT_ID")
	private java.lang.String parentId;

	/**ORDER_BY*/
	@ApiModelProperty(value="ORDER_BY")
	private java.lang.String orderBy;

	/**VALIDATE_STATE*/
	@ApiModelProperty(value="VALIDATE_STATE")
	private java.lang.String validateState;

	/**APP_ID*/
	@ApiModelProperty(value="APP_ID")
	private java.lang.Long appId;

	/**VERSION*/
	@ApiModelProperty(value="VERSION")
	private java.lang.Long version;

	/**RESOURCE_ID*/
	@ApiModelProperty(value="RESOURCE_ID")
	private java.lang.Long resourceId;

	private java.lang.String resourceName;
	/**菜单是否显示*/
	@ApiModelProperty(value="IS_SHOW")
	private int isShow;
	/*扩展字段*/
	/* 资源url */
	private String resoure_url;
	/* 资源类型 */
	private String resoure_type;
	/* 资源标示 */
	private String permission;

}