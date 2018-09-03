package com.carloan.feign.admin;

import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysOrgParam;
import com.carloan.api.model.admin.SysOrgVo;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @classname: SysOrgServicefeign
 * @description: 定义  sys_org,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysOrg" ,fallback = SysOrgServiceHystrix.class)
public interface SysOrgServicefeign {

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysOrgByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 *
	 * @return
	 */
	@RequestMapping(value = "/getSysOrgList", method = RequestMethod.POST)
	public ResponseResult<List<SysOrgVo>> querySysOrgList(@RequestBody SysOrgParam obj);


	/**
	 * 根据对象查询信息返回单个实体
	 *
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysOrg(@RequestBody SysOrgVo obj);


	/**
	 * 创建业务对象
	 *
	 * @return
	 */
	@RequestMapping(value = "/create/v1", method = RequestMethod.POST)
	public ResponseResult insertSysOrg(@RequestBody SysOrgVo obj);

	/**
	 * 修改业务对象
	 *
	 * @return
	 */
	@RequestMapping(value = "/update/v1", method = RequestMethod.POST)
	public ResponseResult updateSysOrg(@RequestBody SysOrgVo obj);

	/**
	 * 删除个业务对象
	 * @return
	 */
	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	public ResponseResult deleteOrgByID(@RequestParam("id") String id);


}