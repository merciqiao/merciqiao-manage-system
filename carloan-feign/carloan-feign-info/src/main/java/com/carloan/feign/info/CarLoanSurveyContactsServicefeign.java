package com.carloan.feign.info;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanSurveyContactsDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @classname: CarLoanSurveyContactsServicefeign
 * @description: 定义  car_loan_survey_contacts,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-info",path = "/carloansurveycontacts-api" ,fallback = CarLoanSurveyContactsServiceHystrix.class)
public interface CarLoanSurveyContactsServicefeign {

	/**
	 * 查询电核网核联系人列表
	 * @return
	 */
	@RequestMapping(value = "/searchCarLoanSurveyContacts",method = RequestMethod.POST)
	public ResponseResult<Object> searchCarLoanSurveyContacts(@RequestParam("order_number") String order_number);
	/**
	 * 查询电核网核联系人详细信息
	 * @return
	 */
	@RequestMapping(value = "/searchCarLoanSurveyContactsInfo",method = RequestMethod.POST)
	public ResponseResult<Object> searchCarLoanSurveyContactsInfo(@RequestParam("contactsInfo_id") String contactsInfo_id);

	/**
	 * 新增电核网核联系人信息
	 * @return
	 */
	@RequestMapping(value = "/insertCarLoanSurveyContacts",method = RequestMethod.POST)
	public ResponseResult<Object> insertCarLoanSurveyContacts(@RequestBody CarLoanSurveyContactsDTO carLoanSurveyContactsParam);

	/**
	 * 更新电核网核联系人
	 * @return
	 */
	@RequestMapping(value = "/updateCarLoanSurveyContacts",method = RequestMethod.POST)
	public ResponseResult<Object> updateCarLoanSurveyContacts(@RequestBody CarLoanSurveyContactsDTO CarLoanSurveyContactsInfoParam);

	/**
	 * 删除电核网核联系人
	 * @return
	 */
	@RequestMapping(value = "/deleteCarLoanSurveyContacts",method = RequestMethod.POST)
	public ResponseResult<Object> deleteCarLoanSurveyContacts(@RequestBody CarLoanSurveyContactsDTO CarLoanSurveyContactsInfoParam);






}
