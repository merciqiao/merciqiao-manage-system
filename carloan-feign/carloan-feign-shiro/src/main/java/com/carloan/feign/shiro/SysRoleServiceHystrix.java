package com.carloan.feign.shiro;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.SysRole;
import com.carloan.apimodel.shiro.SysRoleParam;
import org.springframework.stereotype.Component;

@Component
public class SysRoleServiceHystrix implements SysRoleServiceFeign{
    @Override
    public ResponseResult<SysRole> getSysRoleByUserId(SysRoleParam sysRoleParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("getSysRoleByUserId.hystrix_failed");
        return responseResult;
    }
}
