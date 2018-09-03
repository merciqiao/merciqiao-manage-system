package com.carloan.service.master.sysdict.rest;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.service.master.sysdict.dto.SysDictDTO;
import com.carloan.service.master.sysdict.service.SysDictService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/api/sysDict")
@Slf4j
public class SysDictRest {


@Autowired
private SysDictService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysDictDTO> querySysDictByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<SysDictDTO>result=new ResponseResult<>();
			try{
				SysDictDTO entity=service.querySysDictByPrimaryKey(ID);
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
	@RequestMapping(value = "/getSysDictList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public Object querySysDictList(@RequestBody SysDictDTO obj)throws Exception{
		      return service.searchSysDict(obj);
			}

/**
 * 根据对象查询信息返回单个实体
 *
 * @return
 */
		@ResponseBody
		@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
		@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult<SysDictDTO> queryLike(@RequestBody SysDictDTO obj)throws Exception{
				ResponseResult<SysDictDTO>result=new ResponseResult<>();
				try{
				SysDictDTO entity=service.queryLikeSysDict(obj);
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
		public ResponseResult create(@RequestBody SysDictDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.insertSysDict(obj);
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
		public ResponseResult update(@RequestBody SysDictDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.updateSysDict(obj);
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


		@RequestMapping(value="/get/count",method=RequestMethod.POST)
		public ResponseResult count(@RequestParam("dictCode") String dictCode){
			ResponseResult result=new ResponseResult();
			try{
				int count=service.getCount(dictCode);
				result.setStatus(Status.SUCCESS);
				result.setCount(count);
				return result;
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;
			}
		}






}