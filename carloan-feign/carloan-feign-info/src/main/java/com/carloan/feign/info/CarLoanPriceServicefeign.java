package com.carloan.feign.info;

import java.util.List;
import java.util.Map;
import java.util.Objects;


import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanPriceParam;
import com.carloan.apimodel.order.CarLoanPriceVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * @classname: CarLoanPriceServicefeign
 * @description: 定义  定价审核意见表,微服务调用层
 */
@FeignClient(value = "carloan-service-info",path = "/api/carLoanPrice" ,fallback = CarLoanPriceServiceHystrix.class)
public interface CarLoanPriceServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> queryCarLoanPriceByPrimaryKey(@PathVariable("ID") String ID);


	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLoanPriceinfo", method = RequestMethod.GET)
	//public ResponseResult<Object> queryLoanPriceinfo(@RequestParam("msg") String msg);
	public ResponseResult<Object> queryLoanPriceinfo(@RequestParam("ordernum") String ordernum,@RequestParam("status") String status);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult addCarLoanPrice(@RequestBody CarLoanPriceVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult ModifyCarLoanPrice(@RequestBody CarLoanPriceVo obj);







}
