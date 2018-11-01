package com.carloan.service.admin.rest;
import java.util.List;


import com.carloan.api.model.admin.SysPositionParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.admin.sysposition.dto.SysPositionDTO;
import com.carloan.service.admin.sysposition.service.SysPositionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/sysPosition")
@Slf4j
@Api(tags={"sys_position"})
public class SysPositionRest {


@Autowired
private SysPositionService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysPositionDTO> querySysPositionByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<SysPositionDTO>result=new ResponseResult<>();
			try{
				SysPositionDTO entity=service.querySysPositionByPrimaryKey(ID);
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
	@RequestMapping(value = "/getSysPositionList", method = RequestMethod.POST)
	@ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public Object querySysPositionList(@RequestBody SysPositionParam obj)throws Exception {
		return service.searchSysPosition(obj);
	}








/**
 * 根据对象查询信息返回单个实体
 *
 * @return
 */
		@ResponseBody
		@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
		@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult<SysPositionDTO> queryLike(@RequestBody SysPositionDTO obj)throws Exception{
				ResponseResult<SysPositionDTO>result=new ResponseResult<>();
				try{
				SysPositionDTO entity=service.queryLikeSysPosition(obj);
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
		public ResponseResult create(@RequestBody SysPositionDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.insertSysPosition(obj);
				result.setStatus(Status.SUCCESS);
				result.setMessage("新增成功");
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
		public ResponseResult update(@RequestBody SysPositionDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.updateSysPosition(obj);
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
	 * 删除用户列表中用户
	 * @return
	 */
	@ResponseBody
//	@RequestMapping(value = "/deleteSysPositionById", method = RequestMethod.POST)
	@ApiOperation(value = "删除岗位列表中岗位", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult deleteSysPositionById(@RequestParam("ids") String ids)throws Exception{
		ResponseResult result=new ResponseResult();
		try{
			if(ids!=null&&!ids.equals(""))
			{
				service.deleteSysPositionByPrimaryKey(ids);
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