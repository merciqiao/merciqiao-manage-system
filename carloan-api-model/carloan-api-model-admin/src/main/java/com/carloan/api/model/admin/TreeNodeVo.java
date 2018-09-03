package com.carloan.api.model.admin;

import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class TreeNodeVo {
    private String id;
    private String name;
    private String parentId;
    private List<TreeNodeVo> children;
    private String level;
    private String orgType;
    private String validateState;
    public static   List<TreeNodeVo>  treeBuild(List<TreeNodeVo> list) {

        List<TreeNodeVo> nodeList = new ArrayList();
        for (TreeNodeVo node1 : list) {//taskDTOList 是数据库获取的List列表数据或者来自其他数据源的List

            boolean mark = false;
            for (TreeNodeVo node2 : list) {
                if (node1.getParentId() != null && node1.getParentId().equals(node2.getId())) {
                    mark = true;
                    if (node2.getChildren() == null) {
                        node2.setChildren(new ArrayList<TreeNodeVo>());
                    }
                    node2.getChildren().add(node1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }
        return nodeList;
    }
}
