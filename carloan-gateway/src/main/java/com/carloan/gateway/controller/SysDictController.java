package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.master.sysdict.SysDictDTO;
import com.carloan.apimodel.master.sysdict.SysDictDetailDTO;
import com.carloan.common.redisTemplate.service.RedisUtils;
import com.carloan.feign.master.feign.SysDictDetailServicefeign;
import com.carloan.feign.master.feign.SysDictServicefeign;
import io.swagger.annotations.Api;
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
 *
 * 此接口为外部提供调用,通过注册中心获取相关业务接口标识，通过[feign]rest形式调用服务方接口
 */

@RestController
@RequestMapping(value = "/execute/api/sysDict")
@Slf4j
@Api(tags = {"数据字典-zhouzhiwei"})
public class SysDictController {


@Autowired
private SysDictServicefeign feiservice;

	@Autowired
	private SysDictDetailServicefeign sysDictDetailServicefeign;

	@Autowired
	private RedisUtils redisUtils;
/*
	*//**
	 * 取得单个业务对象
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping(value = "/Web/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> querySysDictByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<Object>result=new ResponseResult<>();
			try{
				return feiservice.querySysDictByPrimaryKey(ID);
			}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

			}
		}*/

	/**
	 * 取得List业务对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Web/getSysDictList", method = RequestMethod.POST)
	@ApiOperation(value = "SYSDICT-分页查询", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> querySysDictList(@RequestBody SysDictDTO obj)throws Exception{
			ResponseResult<Object>result=new ResponseResult<>();
			try{
			return feiservice.querySysDictList(obj);
			}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

			}
			}


	/*	*//**
		 * 根据对象查询信息返回单个实体
		 * @return
		 *//*
		@ResponseBody
		@RequestMapping(value = "/Web/queryLike", method = RequestMethod.POST)
		@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult<Object> queryLike(@RequestBody SysDictDTO obj)throws Exception{
				ResponseResult<Object>result=new ResponseResult<>();
				try{
				return feiservice.queryLikeSysDict(obj);
				}catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;

				}
				}*/



		/**
		 * 插入一个业务对象
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/Web/create/v1", method = RequestMethod.POST)
		@ApiOperation(value = "SYSDICT-新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult insertSysDict(@RequestBody SysDictDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
					ResponseResult responseResult= feiservice.count(obj.getDictCode());
					if (responseResult.getCount()>0){
						throw new Exception(obj.getDictCode()+"该编码已经存在");
					}
					return feiservice.insertSysDict(obj);
				}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage(ex.getMessage());
				return result;

				}
				}
		/**
		 * 修改一个业务对象
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/Web/update/v1", method = RequestMethod.POST)
		@ApiOperation(value = "SYSDICT-修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult updateSysDict(@RequestBody SysDictDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
					return feiservice.updateSysDict(obj);
				}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;
				}
				}




	/**
	 * 取得单个业务对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Web/get/v1/Detail/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "SYS_DICT_DETAIL-根据ID查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> querySysDictDetailByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
		ResponseResult<Object>result=new ResponseResult<>();
		try{
			return sysDictDetailServicefeign.querySysDictDetailByPrimaryKey(ID);
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}

	/**
	 * 取得List业务对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Web/getSysDictDetailList", method = RequestMethod.POST)
	@ApiOperation(value = "SYS_DICT_DETAIL-分页查询", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> querySysDictDetailList(@RequestBody SysDictDetailDTO obj)throws Exception{
		ResponseResult<Object>result=new ResponseResult<>();
		try{
			return sysDictDetailServicefeign.querySysDictDetailList(obj);
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
	@RequestMapping(value = "/Web/create/DictDetai/v1", method = RequestMethod.POST)
	@ApiOperation(value = "SYS_DICT_DETAIL-新增对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult insertSysDictDetail(@RequestBody SysDictDetailDTO obj)throws Exception{
		ResponseResult result=new ResponseResult();
		try{
			return sysDictDetailServicefeign.insertSysDictDetail(obj);
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
	@RequestMapping(value = "/Web/update/DictDetai/v1", method = RequestMethod.POST)
	@ApiOperation(value = "SYS_DICT_DETAIL-修改对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult updateSysDictDetail(@RequestBody SysDictDetailDTO obj)throws Exception{
		ResponseResult result=new ResponseResult();
		try{
			return sysDictDetailServicefeign.updateSysDictDetail(obj);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}







	@ResponseBody
	@RequestMapping(value = "/Web/searchCodeSysDictDetail", method = RequestMethod.POST)
	@ApiOperation(value = "根据code查询返回LiST", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> searchCodeSysDictDetail(@RequestParam("code") String  code)throws Exception{
		ResponseResult<Object>result=new ResponseResult<>();
		try{
			return sysDictDetailServicefeign.searchCodeSysDictDetail(code);
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}

















}