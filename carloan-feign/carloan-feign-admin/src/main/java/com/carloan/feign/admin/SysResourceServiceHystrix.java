package com.carloan.feign.admin;

import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysResourceParam;
import com.carloan.api.model.admin.SysResourceVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.RolePermission;
import com.carloan.apimodel.shiro.RolePermissionParam;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @classname: SysResourceServiceHystrix
 * @description: 定义  sys_resource,微服务断路器
 * 一个微服务的超时失败可能导致瀑布式连锁反映Hystrix通过自主反馈实现的断路器，
 * 防止了这种情况发生调用失败达到一个特定的阀值(5秒之内发生20次失败是Hystrix定义的缺省值), 链路就会被处于open状态，
 * 之后所有所有对服务B的调用都不会被执行，
 * 取而代之的是由断路器提供的一个表示链路open的Fallback消息.  Hystrix提供了相应机制
 * @author: zhouzhiwei
 */
@Component("com.carloan.feign.admin.SysResourceServiceHystrix")
@Log
public class SysResourceServiceHystrix implements SysResourceServicefeign {

    @Override
    public ResponseResult<Object> querySysResourceByPrimaryKey(String message) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult<List<SysResourceVo>> querySysResourceList(@RequestBody SysResourceParam obj) {
        return GetResponseResult.result();
    }


    @Override
    public ResponseResult<Object> queryLikeSysResource(@RequestBody SysResourceVo obj) {
        return GetResponseResult.result();
    }

    @Override
    public ResponseResult<String> insertSysResource(@RequestBody SysResourceVo obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult<String> updateSysResource(@RequestBody SysResourceVo obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult deleteResourceByID(@RequestParam("id") String id) {
        return GetResponseResult.result();
    }

    @Override
    public ResponseResult<RolePermission> selectShiroUrlPermissionByUserId(RolePermissionParam rolePermissionParam) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("selectShiroUrlPermissionByUserId.hystrix_failed");
        return responseResult;
    }

}
