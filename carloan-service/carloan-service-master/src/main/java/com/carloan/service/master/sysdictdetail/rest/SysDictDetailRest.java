package com.carloan.service.master.sysdictdetail.rest;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.service.master.sysdictdetail.dto.SysDictDetailDTO;
import com.carloan.service.master.sysdictdetail.service.SysDictDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
@RequestMapping(value = "/api/sysDictDetail")
@Slf4j
@Api(tags={"sys_dict_detail"})
public class SysDictDetailRest {


@Autowired
private SysDictDetailService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysDictDetailDTO> querySysDictDetailByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<SysDictDetailDTO>result=new ResponseResult<>();
			try{
				SysDictDetailDTO entity=service.querySysDictDetailByPrimaryKey(ID);
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
	@RequestMapping(value = "/getSysDictDetailList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public Object querySysDictDetailList(@RequestBody SysDictDetailDTO obj)throws Exception{
			return service.searchSysDictDetail(obj);
			}








/**
 * 根据对象查询信息返回单个实体
 *
 * @return
 */
		@ResponseBody
		@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
		@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult<SysDictDetailDTO> queryLike(@RequestBody SysDictDetailDTO obj)throws Exception{
				ResponseResult<SysDictDetailDTO>result=new ResponseResult<>();
				try{
				SysDictDetailDTO entity=service.queryLikeSysDictDetail(obj);
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
		public ResponseResult create(@RequestBody SysDictDetailDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.insertSysDictDetail(obj);
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
		public ResponseResult update(@RequestBody SysDictDetailDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.updateSysDictDetail(obj);
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






	@ResponseBody
	@RequestMapping(value = "/searchCodeSysDictDetail", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<List<SysDictDetailDTO>> searchCodeSysDictDetail(@RequestParam("code") String  code)throws Exception{
		ResponseResult<List<SysDictDetailDTO>>result=new ResponseResult<>();
		try{
			List<SysDictDetailDTO> entity=service.searchCodeSysDictDetail(code);
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








}