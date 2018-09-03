package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.Jbpm4HistTaskParam;
import com.carloan.apimodel.order.Jbpm4HistTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @classname: Jbpm4HistTaskServicefeign
 * @description: 定义  jbpm4_hist_task,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-info",path = "/api/jbpm4HistTask" ,fallback = Jbpm4HistTaskServiceHystrix.class)
public interface Jbpm4HistTaskServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> queryJbpm4HistTaskByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getJbpm4HistTaskList", method = RequestMethod.POST)
	public ResponseResult<Object> queryJbpm4HistTaskList(@RequestBody Jbpm4HistTaskParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Jbpm4HistTaskVo> queryLikeJbpm4HistTask(@RequestBody Jbpm4HistTaskParam obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertJbpm4HistTask(@RequestBody Jbpm4HistTaskParam obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateJbpm4HistTask(@RequestBody Jbpm4HistTaskParam obj);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/searchHistTaskByOrdernum", method = RequestMethod.GET)
	public ResponseResult<Object> searchHistTaskByOrdernum(@RequestParam("ordernum") String  ordernum);






}
