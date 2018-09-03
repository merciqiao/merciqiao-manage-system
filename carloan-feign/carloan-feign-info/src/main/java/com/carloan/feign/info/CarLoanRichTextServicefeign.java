package com.carloan.feign.info;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.carloan.apimodel.order.CarLoanRichTextDTO;

/**
 * @classname: CarLoanRichTextServicefeign
 * @description: 定义  car_loan_rich_text,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-info",path = "/carloanrichtext-api" ,fallback = CarLoanRichTextServiceHystrix.class)
public interface CarLoanRichTextServicefeign {

		/**
	 * 查询初审备注以及终审备注信息
	 * @return
	 */
	@RequestMapping(value = "/searchCarLoanRichText",method = RequestMethod.POST)
	public ResponseResult<Object> searchCarLoanRichText(@RequestParam("relation_number") String relation_number, @RequestParam("biz_type") String biz_type);

	/**
	 * 新增或者编辑初审终审备注信息
	 * @return
	 */
	@RequestMapping(value = "/insertCarLoanRichText",method = RequestMethod.POST)
	public ResponseResult<Object> insertCarLoanRichText(@RequestParam("relation_number") String relation_number,@RequestParam("biz_type") String biz_type,@RequestParam("Content") String Content);






}
