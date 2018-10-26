package com.carloan.feign.admin;
import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysUserParam;
import com.carloan.api.model.admin.SysUserVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.shiro.UserInfoParam;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @classname: SysUserServiceHystrix
 * @description: 定义  sys_user,微服务断路器
 * 一个微服务的超时失败可能导致瀑布式连锁反映Hystrix通过自主反馈实现的断路器，
 * 防止了这种情况发生调用失败达到一个特定的阀值(5秒之内发生20次失败是Hystrix定义的缺省值), 链路就会被处于open状态，
 * 之后所有所有对服务B的调用都不会被执行，
 * 取而代之的是由断路器提供的一个表示链路open的Fallback消息.  Hystrix提供了相应机制
 *
 * @author:  zhouzhiwei
 */
@Component("com.carloan.feign.admin.SysUserServiceHystrix")
@Log
public class  SysUserServiceHystrix implements  SysUserServicefeign {

	@Override
	public ResponseResult<SysUserVo> querySysUserByPrimaryKey(String message) {
		return GetResponseResult.result();

	}

	@Override
	public ResponseResult<Object> querySysUserList(@RequestBody SysUserParam obj) {
		return GetResponseResult.result();
	}


	@Override
	public ResponseResult<Object> queryLikeSysUser(@RequestBody SysUserVo obj) {
		return GetResponseResult.result();
	}

	@Override
	public ResponseResult<String> insertSysUser(@RequestBody SysUserVo obj) {
		return GetResponseResult.result();

	}

	@Override
	public ResponseResult<String> updateSysUser(@RequestBody SysUserVo obj) {
		return GetResponseResult.result();

	}
	@Override
	public ResponseResult<Object> delSysUserByUserId(@RequestParam("ids") String ids) {
		return GetResponseResult.result();

	}
	@Override
	public ResponseResult<Object> checkOldPassWord(@RequestParam("LoginName") String LoginName,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword) {
		return GetResponseResult.result();

	}
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
