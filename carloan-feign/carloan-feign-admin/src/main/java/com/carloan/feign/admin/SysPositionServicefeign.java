package com.carloan.feign.admin;

import com.carloan.api.model.admin.SysPositionParam;
import com.carloan.api.model.admin.SysPositionVo;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @classname: SysPositionServicefeign
 * @description: 定义  sys_position,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysPosition" ,fallback = SysPositionServiceHystrix.class)
public interface SysPositionServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysPositionByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysPositionList", method = RequestMethod.POST)
	public ResponseResult<Object> querySysPositionList(@RequestBody SysPositionParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysPosition(@RequestBody SysPositionVo obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysPosition(@RequestBody SysPositionVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysPosition(@RequestBody SysPositionVo obj);



	@RequestMapping(value = "/deleteSysPositionById", method = RequestMethod.POST)
	public ResponseResult<Object> deleteSysPositionById(@RequestParam("ids") String ids);



}
