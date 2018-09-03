package com.carloan.apimodel.shiro;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RolePermissionVo {
    /*资源名称*/
    private String resoureName;
    /*权限标示,根据权限标示区分按钮,有权限标示的显示*/
    private String permission;

}
