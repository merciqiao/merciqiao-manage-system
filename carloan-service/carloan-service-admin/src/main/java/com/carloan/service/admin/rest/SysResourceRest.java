package com.carloan.service.admin.rest;

import java.util.ArrayList;
import java.util.List;


import com.carloan.api.model.admin.SysResourceParam;
import com.carloan.apimodel.shiro.RolePermission;
import com.carloan.apimodel.shiro.RolePermissionParam;
import com.carloan.common.utils.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.admin.sysresource.dto.SysResourceDTO;
import com.carloan.service.admin.sysresource.service.SysResourceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/sysResource")
@Slf4j
@Api(tags={"sys_resource"})
public class SysResourceRest {


	@Autowired
	private SysResourceService service;
	@Autowired
	MapperUtil mapperUtil;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysResourceDTO> querySysResourceByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<SysResourceDTO> result = new ResponseResult<>();
		try {
			SysResourceDTO entity = service.querySysResourceByPrimaryKey(ID);
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
	@RequestMapping(value = "/getSysResourceList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<List<SysResourceDTO>> querySysResourceList(@RequestBody SysResourceParam obj) throws Exception {
		ResponseResult<List<SysResourceDTO>> result = new ResponseResult<>();
		try {
			List<SysResourceDTO> entity = service.searchSysResource(obj);
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
	 * 根据对象查询信息返回单个实体
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysResourceDTO> queryLike(@RequestBody SysResourceDTO obj) throws Exception {
		ResponseResult<SysResourceDTO> result = new ResponseResult<>();
		try {
			SysResourceDTO entity = service.queryLikeSysResource(obj);
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
	public ResponseResult create(@RequestBody SysResourceDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.insertSysResource(obj);
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
	public ResponseResult update(@RequestBody SysResourceDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.updateSysResource(obj);
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

	@ResponseBody
	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	public ResponseResult deleteResourceByID(@RequestParam("id") String id)
	{
		ResponseResult result = new ResponseResult();
		try {
			service.deleteResourceByID(id);
			result.setStatus(Status.SUCCESS);
			result.setMessage("删除成功");
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}

	}
	/**
	 * 根据userid查询shiro的权限
	 * @param rolePermissionParam
	 * @return
	 */
	@ApiOperation(value="根据userid查询shiro的权限",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
	@RequestMapping(value = "/selectShiroUrlPermissionByUserId",method = RequestMethod.POST)
	public ResponseResult<RolePermission> selectShiroUrlPermissionByUserId(@RequestBody RolePermissionParam rolePermissionParam) throws Exception {
		ResponseResult<RolePermission> result = new ResponseResult<>();
		try {
			List<RolePermission> rolePermissionList=new ArrayList<>();

			SysResourceDTO sysResourceDTO=new SysResourceDTO();
			sysResourceDTO.setUserId(rolePermissionParam.getUserId());
			sysResourceDTO.setResoureType(rolePermissionParam.getResoureType());
			List<SysResourceDTO> sysRoleDTOList= service.selectShiroUrlPermissionByUserId(sysResourceDTO);
			rolePermissionList=mapperUtil.map(sysRoleDTOList,RolePermission.class);
			result.setStatus(Status.SUCCESS);
			result.setDataList(rolePermissionList);
			result.setMessage("查询成功");

			return result;
		}
		catch (Exception ex){
			log.error(ex.getMessage(),ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}

}