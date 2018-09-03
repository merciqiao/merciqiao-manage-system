package com.carloan.apimodel.shiro;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RolePermission {
    /**资源URL*/
    private String resoureUrl;
    /**资源类型*/
    private String resoureType;
    /*角色编码*/
    private String role_code;
    /*权限标示*/
    private String permission;
    /*资源名称*/
    private String resoureName;

}
