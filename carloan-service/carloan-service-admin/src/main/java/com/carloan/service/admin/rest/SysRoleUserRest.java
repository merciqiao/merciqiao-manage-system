package com.carloan.service.admin.rest;
import java.util.List;


import com.carloan.api.model.admin.SysRoleUserParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.admin.sysroleuser.dto.SysRoleUserDTO;
import com.carloan.service.admin.sysroleuser.service.SysRoleUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/sysRoleUser")
@Slf4j
@Api(tags={"sys_role_user"})
public class SysRoleUserRest {


	@Autowired
	private SysRoleUserService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysRoleUserDTO> querySysRoleUserByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<SysRoleUserDTO> result = new ResponseResult<>();
		try {
			SysRoleUserDTO entity = service.querySysRoleUserByPrimaryKey(ID);
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
	@RequestMapping(value = "/getSysRoleUserList", method = RequestMethod.POST)
	@ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public Object querySysRoleUserList(@RequestBody SysRoleUserParam obj) throws Exception {
		return service.searchSysRoleUser(obj);
	}


	/**
	 * 根据对象查询信息返回单个实体
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysRoleUserDTO> queryLike(@RequestBody SysRoleUserDTO obj) throws Exception {
		ResponseResult<SysRoleUserDTO> result = new ResponseResult<>();
		try {
			SysRoleUserDTO entity = service.queryLikeSysRoleUser(obj);
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
	public ResponseResult create(@RequestBody SysRoleUserDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.insertSysRoleUser(obj);
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
	public ResponseResult update(@RequestBody SysRoleUserDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.updateSysRoleUser(obj);
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
	public ResponseResult deleteSysRoleUserbyID(@RequestParam("ID") String ID) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			if(service.deleteSysRoleUserbyID(ID))
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