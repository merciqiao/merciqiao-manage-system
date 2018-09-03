package com.carloan.service.admin.rest;

import java.util.List;


import com.carloan.api.model.admin.SysRoleMappingParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.admin.sysrolemapping.dto.SysRoleMappingDTO;
import com.carloan.service.admin.sysrolemapping.service.SysRoleMappingService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
 /*
                           _ooOoo_
                          o8888888o
                          88" . "88
                          (| -_- |)
                          O\  =  /O
                       ____/`---'\____
                     .'  \\|     |//  `.
                    /  \\|||  :  |||//  \
                   /  _||||| -:- |||||-  \
                   |   | \\\  -  /// |   |
                   | \_|  ''\---/''  |   |
                   \  .-\__  `-`  ___/-. /
                 ___`. .'  /--.--\  `. . __
              ."" '<  `.___\_<|>_/___.'  >'"".
             | | :  `- \`.;`\ _ /`;.`/ - ` : | |
             \  \ `-.   \_ __\ /__ _/   .-` /  /
        ======`-.____`-.___\_____/___.-`____.-'======
                           `=---='
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                 佛祖保佑       永无BUG
 */
/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/sysRoleMapping")
@Slf4j
@Api(tags={"sys_role_mapping"})
public class SysRoleMappingRest {


	@Autowired
	private SysRoleMappingService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysRoleMappingDTO> querySysRoleMappingByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<SysRoleMappingDTO> result = new ResponseResult<>();
		try {
			SysRoleMappingDTO entity = service.querySysRoleMappingByPrimaryKey(ID);
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
	@RequestMapping(value = "/getSysRoleMappingList", method = RequestMethod.POST)
	@ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public Object querySysRoleMappingList(@RequestBody SysRoleMappingParam obj) throws Exception {
		return service.searchSysRoleMapping(obj);
	}


	/**
	 * 根据对象查询信息返回单个实体
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysRoleMappingDTO> queryLike(@RequestBody SysRoleMappingDTO obj) throws Exception {
		ResponseResult<SysRoleMappingDTO> result = new ResponseResult<>();
		try {
			SysRoleMappingDTO entity = service.queryLikeSysRoleMapping(obj);
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
	public ResponseResult create(@RequestBody SysRoleMappingDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.insertSysRoleMapping(obj);
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
	public ResponseResult update(@RequestBody SysRoleMappingDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.updateSysRoleMapping(obj);
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
	@ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult deleteSysRoleMapping(@RequestParam("ids") String ids)
	{
		ResponseResult result = new ResponseResult();
		try {
			boolean isdel= service.deleteSysRoleMapping(ids);
			if(isdel){
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