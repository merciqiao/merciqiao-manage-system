package com.carloan.feign.admin;

import java.util.List;
import java.util.Map;

import com.carloan.api.model.admin.SysMenuParam;
import com.carloan.api.model.admin.SysMenuVo;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * @classname: SysMenuServicefeign
 * @description: 定义  sys_menu,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysMenu" ,fallback = SysMenuServiceHystrix.class)
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
	public ResponseResult<List<SysMenuVo>> querySysMenuList(@RequestBody SysMenuParam obj);



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

	@RequestMapping(value="/delete/v1",method=RequestMethod.POST)
	public ResponseResult deleteSysMenu(@RequestParam("ids") String ids);





}
