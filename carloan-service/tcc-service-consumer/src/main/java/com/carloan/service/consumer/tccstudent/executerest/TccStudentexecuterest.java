package com.carloan.service.consumer.tccstudent.executerest;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.consumer.tccstudent.dto.TccStudentDTO;
import com.carloan.service.consumer.tccstudent.feign.TccStudentServicefeign;
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
@RequestMapping(value = "/execute/api/tccStudent")
@Slf4j
public class TccStudentexecuterest {


@Autowired
private TccStudentServicefeign feiservice;


	/**
	 * 取得单个业务对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Web/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> queryTccStudentByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<Object>result=new ResponseResult<>();
			try{
				return feiservice.queryTccStudentByPrimaryKey(ID);
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
	@RequestMapping(value = "/Web/getTccStudentList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> queryTccStudentList(@RequestBody TccStudentDTO obj)throws Exception{
			ResponseResult<Object>result=new ResponseResult<>();
			try{
			return feiservice.queryTccStudentList(obj);
			}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

			}
			}


		/**
		 * 根据对象查询信息返回单个实体
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/Web/queryLike", method = RequestMethod.POST)
		@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult<Object> queryLike(@RequestBody TccStudentDTO obj)throws Exception{
				ResponseResult<Object>result=new ResponseResult<>();
				try{
				return feiservice.queryLikeTccStudent(obj);
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
		@RequestMapping(value = "/Web/create/v1", method = RequestMethod.POST)
		@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult insertTccStudent(@RequestBody TccStudentDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
					return feiservice.insertTccStudent(obj);
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
		@RequestMapping(value = "/Web/update/v1", method = RequestMethod.POST)
		@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult updateTccStudent(@RequestBody TccStudentDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
					return feiservice.updateTccStudent(obj);
				}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;
				}
				}

}