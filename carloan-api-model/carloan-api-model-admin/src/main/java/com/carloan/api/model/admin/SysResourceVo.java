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
public class SysResourceVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键*/
    @ApiModelProperty(value="主键")
    private java.lang.Long id;

    /**RESOURE_NAME*/
    @ApiModelProperty(value="RESOURE_NAME")
    private java.lang.String resoureName;

    /**RESOURE_TYPE*/
    @ApiModelProperty(value="RESOURE_TYPE")
    private java.lang.String resoureType;

    /**RESOURE_URL*/
    @ApiModelProperty(value="RESOURE_URL")
    private java.lang.String resoureUrl;

    /**PERMISSION*/
    @ApiModelProperty(value="PERMISSION")
    private java.lang.String permission;

    /**PARENT_ID*/
    @ApiModelProperty(value="PARENT_ID")
    private java.lang.String parentId;

    /**PARENT_IDS*/
    @ApiModelProperty(value="PARENT_IDS")
    private java.lang.String parentIds;

    /**APP_ID*/
    @ApiModelProperty(value="APP_ID")
    private java.lang.Long appId;

    /**VALIDATE_STATE*/
    @ApiModelProperty(value="VALIDATE_STATE")
    private java.lang.String validateState;

    /**VERSION*/
    @ApiModelProperty(value="VERSION")
    private java.lang.Long version;
    public static List<TreeNodeVo> ToTreeModel(List<SysResourceVo> list)
    {
        List<TreeNodeVo> treelist=new ArrayList<>();
        for (SysResourceVo vo:list) {
            TreeNodeVo treenode=new TreeNodeVo();
            treenode.setId(vo.getId().toString());
            treenode.setName(vo.getResoureName());
            treenode.setParentId(vo.getParentId());
            treelist.add(treenode);
        }
        return TreeNodeVo.treeBuild(treelist);

    }
}