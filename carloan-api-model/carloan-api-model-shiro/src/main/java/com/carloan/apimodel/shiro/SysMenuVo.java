package com.carloan.apimodel.shiro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *@Description:sys_menu
 *@author root
 *@version 1.0,
 *@date 2018-07-11 11:51:28
 */
@Getter
@Setter
public class SysMenuVo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键*/
	@ApiModelProperty(value="主键")
	private Long id;

	/**MENU_CODE*/
	@ApiModelProperty(value="MENU_CODE")
	private String menuCode;

	/**MENU_NAME*/
	@ApiModelProperty(value="MENU_NAME")
	private String menuName;

	/**MENU_ICON*/
	@ApiModelProperty(value="MENU_ICON")
	private String menuIcon;

	/**MENU_URL*/
	@ApiModelProperty(value="MENU_URL")
	private String menuUrl;

	/**PARENT_ID*/
	@ApiModelProperty(value="PARENT_ID")
	private String parentId;

	/**ORDER_BY*/
	@ApiModelProperty(value="ORDER_BY")
	private String orderBy;
	/**是否显示菜单*/
	@ApiModelProperty(value="IS_SHOW")
	private int isShow;

//	/**VALIDATE_STATE*/
//	@ApiModelProperty(value="VALIDATE_STATE")
//	private String validateState;

//	/**APP_ID*/
//	@ApiModelProperty(value="APP_ID")
//	private Long appId;

//	/**VERSION*/
//	@ApiModelProperty(value="VERSION")
//	private Long version;

//	/**RESOURCE_ID*/
//	@ApiModelProperty(value="resourceId")
//	private Long resourceId;
	/*扩展字段*/
	/* 资源url */
	private String resoure_url;
	/* 资源类型 */
	private String resoure_type;
	/* 资源标示 */
	private String permission;
	/*子菜单*/
	List<SysMenuVo> sysMenuVoChild;

}