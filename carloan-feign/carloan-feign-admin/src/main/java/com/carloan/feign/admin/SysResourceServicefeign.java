package com.carloan.feign.admin;

import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysResourceParam;
import com.carloan.api.model.admin.SysResourceVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.RolePermission;
import com.carloan.apimodel.shiro.RolePermissionParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @classname: SysResourceServicefeign
 * @description: 定义  sys_resource,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysResource" ,fallback = SysResourceServiceHystrix.class)
public interface SysResourceServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysResourceByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysResourceList", method = RequestMethod.POST)
	public ResponseResult<List<SysResourceVo>> querySysResourceList(@RequestBody SysResourceParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysResource(@RequestBody SysResourceVo obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysResource(@RequestBody SysResourceVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysResource(@RequestBody SysResourceVo obj);

	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	public ResponseResult deleteResourceByID(@RequestParam("id") String id);


	@RequestMapping(value = "/selectShiroUrlPermissionByUserId", method = RequestMethod.POST)
	public ResponseResult<RolePermission> selectShiroUrlPermissionByUserId(RolePermissionParam rolePermissionParam);


}
