package com.carloan.feign.shiro;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.RolePermission;
import com.carloan.apimodel.shiro.RolePermissionParam;
import org.springframework.stereotype.Component;

@Component
public class SysResourceServiceHystrix implements SysResourceServiceFeign{
    @Override
    public ResponseResult<RolePermission> selectShiroRolePermission(RolePermissionParam rolePermissionParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("selectShiroRolePermission.hystrix_failed");
        return responseResult;
    }
    @Override
    public ResponseResult<RolePermission> selectShiroUrlPermission(RolePermissionParam rolePermissionParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("selectShiroUrlPermission.hystrix_failed");
        return responseResult;
    }
    @Override
    public ResponseResult<RolePermission> selectShiroUrlPermissionByUserId(RolePermissionParam rolePermissionParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("selectShiroUrlPermissionByUserId.hystrix_failed");
        return responseResult;
    }
}



