package com.carloan.feign.info;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanSurveyInfoDTO;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @classname: CarLoanSurveyInfoServiceHystrix
 * @description: 定义  car_loan_survey_info,微服务断路器
 * 一个微服务的超时失败可能导致瀑布式连锁反映Hystrix通过自主反馈实现的断路器，
 * 防止了这种情况发生调用失败达到一个特定的阀值(5秒之内发生20次失败是Hystrix定义的缺省值), 链路就会被处于open状态，
 * 之后所有所有对服务B的调用都不会被执行，
 * 取而代之的是由断路器提供的一个表示链路open的Fallback消息.  Hystrix提供了相应机制
 *
 * @author:  zhouzhiwei
 */
@Component
@Log
public class  CarLoanSurveyInfoServiceHystrix implements  CarLoanSurveyInfoServicefeign{

		@Override
		public ResponseResult<Object> searchCarLoanSurveyInfo(@RequestParam("survey_contacts_id") String survey_contacts_id) {
			return GetResponseResult.result();

		}

		@Override
		public ResponseResult<Object> insertCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam) {
			return GetResponseResult.result();
		}

		@Override
		public ResponseResult<Object> updateCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam) {
			return GetResponseResult.result();

		}

		@Override
		public ResponseResult<Object> saveCarLoanSurveyInfo(@RequestParam("order_number") String order_number,@RequestParam("otherRemark") String otherRemark,@RequestParam("contactsInfo_id") String contactsInfo_id,@RequestParam("ycContent") String ycContent) {
			return GetResponseResult.result();

		}


}
