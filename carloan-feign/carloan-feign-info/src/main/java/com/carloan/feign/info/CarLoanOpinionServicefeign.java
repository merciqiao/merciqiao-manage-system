package com.carloan.feign.info;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanOpinionParam;
import com.carloan.apimodel.order.CarLoanOpinionVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @classname: CarLoanOpinionServicefeign
 * @description: 定义  初审终审(审核意见表),微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-info",path = "/api/carLoanOpinion" ,fallback = CarLoanOpinionServiceHystrix.class)
public interface CarLoanOpinionServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	public ResponseResult<Object> queryCarLoanOpinionByPrimaryKey(@PathVariable("ID") String ID);


	/**
	 * 根据对象查询信息返回单个实体
	 * @return
	 */
	@RequestMapping(value = "/queryLike", method = RequestMethod.GET)
	public ResponseResult<Object> queryLikeCarLoanOpinion(@RequestParam("ordernum") String ordernum,@RequestParam("actName") String actName,@RequestParam("status") String status);


	/**
	 * 创建业务对象
	 * @return
	 */
	@RequestMapping(value="/create/v1",method=RequestMethod.POST)
	public ResponseResult insertCarLoanOpinion(@RequestBody CarLoanOpinionVo obj);

	/**
	 * 修改业务对象
	 * @return
	 */
	@RequestMapping(value="/update/v1",method=RequestMethod.POST)
	public ResponseResult updateCarLoanOpinion(@RequestBody CarLoanOpinionVo obj);







}
