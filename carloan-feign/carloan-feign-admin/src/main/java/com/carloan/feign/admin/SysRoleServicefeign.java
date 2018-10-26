package com.carloan.feign.admin;
import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysRoleParam;
import com.carloan.api.model.admin.SysRoleVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.SysRole;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * @classname: SysRoleServicefeign
 * @description: 定义  sys_role,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysRole" ,fallback = SysRoleServiceHystrix.class)
public interface SysRoleServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysRoleByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysRoleList", method = RequestMethod.POST)
	public ResponseResult<Object> querySysRoleList(@RequestBody SysRoleParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysRole(@RequestBody SysRoleVo obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysRole(@RequestBody SysRoleVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysRole(@RequestBody SysRoleVo obj);
	/**
	 * 删除对象
	 * @return
	 */
	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	public ResponseResult deleteSysRolebyID(@RequestParam("ID") String ID);


	/**
	 * 根据userid查询角色集合
	 * @param sysRoleParam
	 * @return
	 */
	@RequestMapping(value = "/getSysRoleByUserId", method = RequestMethod.POST)
	ResponseResult<SysRole> getSysRoleByUserId(@RequestBody com.carloan.apimodel.shiro.SysRoleParam sysRoleParam);





}
