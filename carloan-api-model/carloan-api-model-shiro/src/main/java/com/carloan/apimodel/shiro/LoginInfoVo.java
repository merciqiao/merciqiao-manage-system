package com.carloan.apimodel.shiro;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginInfoVo {
    /* 用户信息 */
    public UserInfo userInfo;
    /* 角色信息 */
    public List<SysRoleVo> sysRoleVoList;
    /* 权限信息 */
    public List<RolePermissionVo> rolePermissionVoList;
    /* 菜单信息 */
    public List<SysMenuVo> sysMenuVoList;

}
