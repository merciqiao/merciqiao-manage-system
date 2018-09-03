package com.carloan.feign.shiro;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.shiro.UserInfoParam;
import org.springframework.stereotype.Component;

@Component
public class SysUserServiceHystrix implements SysUserServiceFeign{
    @Override
    public ResponseResult<UserInfo> getUserInfoByLoginName(UserInfoParam userInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("getUserInfoByLoginName.hystrix_failed");
        return responseResult;
    }

    @Override
    public ResponseResult<LoginInfoVo> getLoginInfoByUserId(String userId) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("getLoginInfoByUserId.hystrix_failed");
        return responseResult;
    }
}
