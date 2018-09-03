package com.carloan.feign.shiro;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.shiro.UserInfoParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "carloan-service-shiro",path = "/shiro-api",fallback = SysUserServiceHystrix.class)
public interface SysUserServiceFeign {
    /**
     * 根据username查询用户信息
     * @param userInfoParam
     * @return
     */
    @RequestMapping(value = "/getUserInfoByLoginName", method = RequestMethod.POST)
    ResponseResult<UserInfo> getUserInfoByLoginName(@RequestBody UserInfoParam userInfoParam);
    @RequestMapping(value = "/getLoginInfoByUserId",method = RequestMethod.POST)
    ResponseResult<LoginInfoVo> getLoginInfoByUserId(@RequestParam("userId") String userId);
}
