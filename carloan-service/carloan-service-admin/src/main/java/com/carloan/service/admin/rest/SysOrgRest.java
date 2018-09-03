package com.carloan.service.admin.rest;

import java.util.List;


import com.carloan.service.admin.sysorg.dto.SysOrgDTO;
import com.carloan.service.admin.sysorg.service.SysOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/sysOrg")
@Slf4j
@Api(tags={"sys_org"})
public class SysOrgRest {


	@Autowired
	private SysOrgService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysOrgDTO> querySysOrgByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<SysOrgDTO> result = new ResponseResult<>();
		try {
			SysOrgDTO entity = service.querySysOrgByPrimaryKey(ID);
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
	@RequestMapping(value = "/getSysOrgList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<List<SysOrgDTO>> querySysOrgList(@RequestBody SysOrgDTO obj) throws Exception {
		ResponseResult<List<SysOrgDTO>> result = new ResponseResult<>();
		try {
			List<SysOrgDTO> entity = service.searchSysOrg(obj);
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
	public ResponseResult<SysOrgDTO> queryLike(@RequestBody SysOrgDTO obj) throws Exception {
		ResponseResult<SysOrgDTO> result = new ResponseResult<>();
		try {
			SysOrgDTO entity = service.queryLikeSysOrg(obj);
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
	public ResponseResult create(@RequestBody SysOrgDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.insertSysOrg(obj);
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
	public ResponseResult update(@RequestBody SysOrgDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.updateSysOrg(obj);
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
	public ResponseResult deleteOrgByID(@RequestParam("id") String id)
	{
		ResponseResult result = new ResponseResult();
		try {
			service.deleteOrgByID(id);
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


}