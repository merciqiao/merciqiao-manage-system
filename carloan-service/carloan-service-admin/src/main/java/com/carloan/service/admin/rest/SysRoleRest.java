package com.carloan.service.admin.rest;

import java.util.List;


import com.carloan.api.model.admin.SysRoleParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.admin.sysrole.dto.SysRoleDTO;
import com.carloan.service.admin.sysrole.service.SysRoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/sysRole")
@Slf4j
@Api(tags={"sys_role"})
public class SysRoleRest {


	@Autowired
	private SysRoleService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysRoleDTO> querySysRoleByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<SysRoleDTO> result = new ResponseResult<>();
		try {
			SysRoleDTO entity = service.querySysRoleByPrimaryKey(ID);
			result.setStatus(Status.SUCCESS);
			result.setData(entity);
			result.setMessage("查询成功");
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}


	/**
	 * 取得List对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getSysRoleList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public Object querySysRoleList(@RequestBody SysRoleParam obj) throws Exception {
		return service.searchSysRole(obj);
	}


	/**
	 * 根据对象查询信息返回单个实体
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysRoleDTO> queryLike(@RequestBody SysRoleDTO obj) throws Exception {
		ResponseResult<SysRoleDTO> result = new ResponseResult<>();
		try {
			SysRoleDTO entity = service.queryLikeSysRole(obj);
			result.setStatus(Status.SUCCESS);
			result.setData(entity);
			result.setMessage("查询成功");
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}

	/**
	 * 插入一个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/create/v1", method = RequestMethod.POST)
	@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult create(@RequestBody SysRoleDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.insertSysRole(obj);
			result.setStatus(Status.SUCCESS);
			result.setMessage("新增成功");
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}

	/**
	 * 修改一个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update/v1", method = RequestMethod.POST)
	@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult update(@RequestBody SysRoleDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.updateSysRole(obj);
			result.setStatus(Status.SUCCESS);
			result.setMessage("修改成功");
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}
	/**
	 * 删除对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	@ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult deleteSysRolebyID(@RequestParam("ID") String ID) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
		 	if(service.deleteSysRoleById(ID))
			{
				result.setStatus(Status.SUCCESS);
				result.setMessage("修改成功");
			}
			else {
				result.setStatus(Status.FAILED);
				result.setMessage("修改失败");
			}
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}


}