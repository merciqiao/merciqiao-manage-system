package com.car.modules.workflow.jbpm4histtask.rest;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.car.modules.workflow.jbpm4histtask.dto.Jbpm4HistTaskDTO;
import com.car.modules.workflow.jbpm4histtask.service.Jbpm4HistTaskService;
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
@RequestMapping(value = "/api/jbpm4HistTask")
@Slf4j
@Api(tags={"jbpm4_hist_task"})
public class Jbpm4HistTaskRest {


	@Autowired
	private Jbpm4HistTaskService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Jbpm4HistTaskDTO> queryJbpm4HistTaskByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<Jbpm4HistTaskDTO> result = new ResponseResult<>();
		try {
			Jbpm4HistTaskDTO entity = service.queryJbpm4HistTaskByPrimaryKey(ID);
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
	@RequestMapping(value = "/getJbpm4HistTaskList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<List<Jbpm4HistTaskDTO>> queryJbpm4HistTaskList(@RequestBody Jbpm4HistTaskDTO obj) throws Exception {
		ResponseResult<List<Jbpm4HistTaskDTO>> result = new ResponseResult<>();
		try {
			List<Jbpm4HistTaskDTO> entity = service.searchJbpm4HistTask(obj);
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
	public ResponseResult<Jbpm4HistTaskDTO> queryLike(@RequestBody Jbpm4HistTaskDTO obj) throws Exception {
		ResponseResult<Jbpm4HistTaskDTO> result = new ResponseResult<>();
		try {
			Jbpm4HistTaskDTO entity = service.queryLikeJbpm4HistTask(obj);
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
	public ResponseResult create(@RequestBody Jbpm4HistTaskDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.insertJbpm4HistTask(obj);
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
	public ResponseResult update(@RequestBody Jbpm4HistTaskDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			service.updateJbpm4HistTask(obj);
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
	 * 取得List对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHistTaskByOrdernum", method = RequestMethod.GET)
	@ApiOperation(value = "根据订单编号查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
	public ResponseResult<List<Jbpm4HistTaskDTO>> searchHistTaskByOrdernum(@RequestParam("ordernum") String ordernum) throws Exception {
		ResponseResult<List<Jbpm4HistTaskDTO>> result = new ResponseResult<>();
		try {
			List<Jbpm4HistTaskDTO> entity = service.searchHistTaskByOrdernum(ordernum);
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


}