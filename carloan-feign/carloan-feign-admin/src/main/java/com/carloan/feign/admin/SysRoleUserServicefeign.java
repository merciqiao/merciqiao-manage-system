package com.carloan.feign.admin;
import java.util.List;
import java.util.Map;
import com.carloan.api.model.admin.SysRoleUserParam;
import com.carloan.api.model.admin.SysRoleUserVo;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * @classname: SysRoleUserServicefeign
 * @description: 定义  sys_role_user,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-admin",path = "/api/sysRoleUser" ,fallback = SysRoleUserServiceHystrix.class)
public interface SysRoleUserServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> querySysRoleUserByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getSysRoleUserList", method = RequestMethod.POST)
	public ResponseResult<Object> querySysRoleUserList(@RequestBody SysRoleUserParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Object> queryLikeSysRoleUser(@RequestBody SysRoleUserVo obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertSysRoleUser(@RequestBody SysRoleUserVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateSysRoleUser(@RequestBody SysRoleUserVo obj);

	/**
	 * 删除对象
	 * @return
	 */
	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	public ResponseResult deleteSysRoleUserbyID(@RequestParam("ID") String ID);








}
