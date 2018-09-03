package com.carloan.feign.info;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarAntifraudOpnitionVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * @classname: CarAntifraudOpnitionServicefeign
 * @description: 定义  反欺诈审核意见表,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-info",path = "/api/carAntifraudOpnition" ,fallback = CarAntifraudOpnitionServiceHystrix.class)
public interface CarAntifraudOpnitionServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> queryCarAntifraudOpnitionByPrimaryKey(@PathVariable("ID") String ID);

	/**
	 * 取得List业务对象
	 * @return
	 */
	@RequestMapping(value = "/getCarAntifraudOpnitionList", method = RequestMethod.GET)
	public ResponseResult<Object> queryCarAntifraudOpnitionList(@RequestParam("orderid") String orderid,@RequestParam("status") String status);



	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertCarAntifraudOpnition(@RequestBody CarAntifraudOpnitionVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateCarAntifraudOpnition(@RequestBody CarAntifraudOpnitionVo obj);







}
