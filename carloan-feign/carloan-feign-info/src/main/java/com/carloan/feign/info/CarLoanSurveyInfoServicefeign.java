package com.carloan.feign.info;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanSurveyInfoDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @classname: CarLoanSurveyInfoServicefeign
 * @description: 定义  car_loan_survey_info,微服务调用层
 * 使用Spring Cloud搭建各种微服务之后，服务可以通过@FeignClient使用和发现服务场中的其他服务
 * @author:  zhouzhiwei
 */
@FeignClient(value = "carloan-service-info",path = "/carloansurveyinfo-api" ,fallback = CarLoanSurveyInfoServiceHystrix.class)
public interface CarLoanSurveyInfoServicefeign {

	/**
	 * 取得单个业务对象
	 * @return
	 */
	@RequestMapping(value = "/searchCarLoanSurveyInfo",method = RequestMethod.POST)
	public ResponseResult<Object> searchCarLoanSurveyInfo(@RequestParam("survey_contacts_id") String survey_contacts_id);

	/**
	 * 新增电核网核备注信息
	 * @return
	 */
	@RequestMapping(value = "/insertCarLoanSurveyInfo",method = RequestMethod.POST)
	public ResponseResult<Object> insertCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam);

	/**
	 * 更新电核网核备注信息
	 * @return
	 */
	@RequestMapping(value = "/updateCarLoanSurveyInfo",method = RequestMethod.POST)
	public ResponseResult<Object> updateCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam);

	/**
	 * 保存电核网核信息
	 * @return
	 */
	@RequestMapping(value = "/saveCarLoanSurveyInfo",method = RequestMethod.POST)
	public ResponseResult<Object> saveCarLoanSurveyInfo(@RequestParam("order_number") String order_number,@RequestParam("otherRemark") String otherRemark,@RequestParam("contactsInfo_id") String contactsInfo_id,@RequestParam("ycContent") String ycContent);





	}
