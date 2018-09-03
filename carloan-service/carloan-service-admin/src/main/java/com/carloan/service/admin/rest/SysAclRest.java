package com.carloan.service.admin.rest;

import java.util.List;


import com.carloan.api.model.admin.SysAclParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.admin.sysacl.dto.SysAclDTO;
import com.carloan.service.admin.sysacl.service.SysAclService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/sysAcl")
@Slf4j
@Api(tags={"sys_acl"})
public class SysAclRest {


@Autowired
private SysAclService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysAclDTO> querySysAclByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<SysAclDTO>result=new ResponseResult<>();
			try{
				SysAclDTO entity=service.querySysAclByPrimaryKey(ID);
				result.setStatus(Status.SUCCESS);
				result.setData(entity);
				result.setMessage("查询成功");
				return result;
			}catch (Exception ex) {
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
	@RequestMapping(value = "/getSysAclList", method = RequestMethod.POST)
	@ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<List<SysAclDTO>> querySysAclList(@RequestBody SysAclParam obj)throws Exception{
			ResponseResult<List<SysAclDTO>>result=new ResponseResult<>();
			try{
			List<SysAclDTO> entity=service.searchSysAcl(obj);
			result.setStatus(Status.SUCCESS);
			result.setData(entity);
			result.setMessage("查询成功");
			return result;
			}catch (Exception ex) {
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
		public ResponseResult<SysAclDTO> queryLike(@RequestBody SysAclDTO obj)throws Exception{
				ResponseResult<SysAclDTO>result=new ResponseResult<>();
				try{
				SysAclDTO entity=service.queryLikeSysAcl(obj);
				result.setStatus(Status.SUCCESS);
				result.setData(entity);
				result.setMessage("查询成功");
				return result;
				}catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;

				}
				}

		/**
		 * 插入一个业务对象
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/create/v1", method = RequestMethod.POST)
		@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult create(@RequestBody SysAclDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.insertSysAcl(obj);
				result.setStatus(Status.SUCCESS);
				result.setMessage("保存成功");
				return result;
				}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;

				}
				}
		/**
		 * 修改一个业务对象
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/update/v1", method = RequestMethod.POST)
		@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult update(@RequestBody SysAclDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.updateSysAcl(obj);
				result.setStatus(Status.SUCCESS);
				result.setMessage("修改成功");
				return result;
				}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;
				}
				}
	/**
	 * 修改一个业务对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	@ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult deleteSysAcl(@RequestParam("ids") String ids)throws Exception{
		ResponseResult result=new ResponseResult();
		try{
			if(ids!=null&&!ids.equals(""))
			{
				service.deleteSysAcl(ids);
				result.setMessage("删除成功");
				result.setStatus(Status.SUCCESS);
			}
			else
			{
				result.setMessage("删除失败");
				result.setStatus(Status.FAILED);
			}
			return result;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}







}