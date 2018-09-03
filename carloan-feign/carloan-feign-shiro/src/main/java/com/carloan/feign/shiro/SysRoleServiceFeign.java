package com.carloan.feign.shiro;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.SysRole;
import com.carloan.apimodel.shiro.SysRoleParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "carloan-service-shiro",path = "/shiro-api",fallback = SysRoleServiceHystrix.class)
public interface SysRoleServiceFeign {
    /**
     * 根据userid查询角色集合
     * @param sysRoleParam
     * @return
     */
    @RequestMapping(value = "/getSysRoleByUserId", method = RequestMethod.POST)
    ResponseResult<SysRole> getSysRoleByUserId(@RequestBody SysRoleParam sysRoleParam);
}
