package com.carloan.feign.info;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.Jbpm4TaskParam;
import com.carloan.apimodel.order.Jbpm4TaskVo;
import com.carloan.apimodel.workflow.TaskEventParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @classname: Jbpm4TaskServicefeign
 * @description: 定义  jbpm4_task,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-info",path = "/api/jbpm4Task" ,fallback = Jbpm4TaskServiceHystrix.class)
public interface Jbpm4TaskServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> queryJbpm4TaskByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getJbpm4TaskList", method = RequestMethod.POST)
	public ResponseResult<Object> queryJbpm4TaskList(@RequestBody Jbpm4TaskParam obj);



	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	public ResponseResult<Jbpm4TaskVo> queryLikeJbpm4Task(@RequestBody Jbpm4TaskParam obj);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertJbpm4Task(@RequestBody Jbpm4TaskParam obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateJbpm4Task(@RequestBody Jbpm4TaskParam obj);

	/**
	 * 删除业务对象
	 * @return
	 */
	@RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
	public ResponseResult delete(@RequestBody Jbpm4TaskParam obj);


	@RequestMapping(value = "/UpdateOrderState", method = RequestMethod.POST)
	Response UpdateOrderState(@RequestBody TaskEventParam taskEventParam);


}
