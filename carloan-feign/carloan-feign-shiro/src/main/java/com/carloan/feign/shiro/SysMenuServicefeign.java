package com.carloan.feign.shiro;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.SysMenuVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @classname: SysMenuServicefeign
 * @description: 定义  sys_menu,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-shiro",path = "/api/sysMenu" ,fallback = SysMenuServiceHystrix.class)
public interface SysMenuServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysMenuByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysMenuList", method = RequestMethod.POST)
	public ResponseResult<Object> querySysMenuList(@RequestBody SysMenuVo obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysMenu(@RequestBody SysMenuVo obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysMenu(@RequestBody SysMenuVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysMenu(@RequestBody SysMenuVo obj);


	@RequestMapping(value = "/querySysMenuByUserId", method = RequestMethod.POST)
	ResponseResult<SysMenuVo> querySysMenuByUserId(@RequestParam("userId") String userId);




}
