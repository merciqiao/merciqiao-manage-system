package com.carloan.feign.admin;
import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysUserParam;
import com.carloan.api.model.admin.SysUserVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.shiro.UserInfoParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * @classname: SysUserServicefeign
 * @description: 定义  sys_user,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysUser" ,fallback = SysUserServiceHystrix.class)
public interface SysUserServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<SysUserVo> querySysUserByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysUserList", method = RequestMethod.POST)
	public ResponseResult<Object> querySysUserList(@RequestBody SysUserParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysUser(@RequestBody SysUserVo obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysUser(@RequestBody SysUserVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysUser(@RequestBody SysUserVo obj);

	@RequestMapping(value = "/delSysUserByUserId", method = RequestMethod.POST)
	public ResponseResult<Object> delSysUserByUserId(@RequestParam("ids") String ids);

	@RequestMapping(value = "/checkOldPassWord", method = RequestMethod.POST)
	public ResponseResult<Object> checkOldPassWord(@RequestParam("LoginName") String LoginName,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword);

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
