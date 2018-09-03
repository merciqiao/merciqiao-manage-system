package com.carloan.api.model.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/18.
 */
@Getter
@Setter
public class SysMenuVo implements Serializable {

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
    /**菜单是否显示*/
    @ApiModelProperty(value="IS_SHOW")
    private int isShow;
    public static List<TreeNodeVo> ToTreeModel(List<SysMenuVo> list)
    {
        List<TreeNodeVo> treelist=new ArrayList<>();
        for (SysMenuVo vo:list) {
            TreeNodeVo treenode=new TreeNodeVo();
            treenode.setId(vo.getId().toString());
            treenode.setName(vo.getMenuName());
            treenode.setParentId(vo.getParentId());
            treelist.add(treenode);
        }
        return TreeNodeVo.treeBuild(treelist);

    }
}
