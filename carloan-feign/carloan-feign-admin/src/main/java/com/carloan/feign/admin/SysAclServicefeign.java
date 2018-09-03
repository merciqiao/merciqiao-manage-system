package com.carloan.feign.admin;

import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysAclParam;
import com.carloan.api.model.admin.SysAclVo;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;




/**
 * @classname: SysAclServicefeign
 * @description: 定义  sys_acl,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysAcl" ,fallback = SysAclServiceHystrix.class)
public interface SysAclServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysAclByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysAclList", method = RequestMethod.POST)
	public ResponseResult<Object> querySysAclList(@RequestBody SysAclParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysAcl(@RequestBody SysAclVo obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysAcl(@RequestBody SysAclVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysAcl(@RequestBody SysAclVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/delete/v1",method=RequestMethod.POST)
	public ResponseResult deleteSysAcl(@RequestParam("ids") String ids);





}
