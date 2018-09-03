package com.carloan.feign.shiro;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.RolePermission;
import com.carloan.apimodel.shiro.RolePermissionParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "carloan-service-shiro",path = "/shiro-api",fallback = SysResourceServiceHystrix.class)
public interface SysResourceServiceFeign {
    @RequestMapping(value = "/selectShiroRolePermission", method = RequestMethod.POST)
    public ResponseResult<RolePermission> selectShiroRolePermission(RolePermissionParam rolePermissionParam);

    @RequestMapping(value = "/selectShiroUrlPermission", method = RequestMethod.POST)
    public ResponseResult<RolePermission> selectShiroUrlPermission(RolePermissionParam rolePermissionParam);
    @RequestMapping(value = "/selectShiroUrlPermissionByUserId", method = RequestMethod.POST)
    public ResponseResult<RolePermission> selectShiroUrlPermissionByUserId(RolePermissionParam rolePermissionParam);
}



