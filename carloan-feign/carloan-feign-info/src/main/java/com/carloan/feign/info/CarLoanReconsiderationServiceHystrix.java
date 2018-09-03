package com.carloan.feign.info;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Status;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @classname: CarLoanReconsiderationServiceHystrix
 * @description: 定义  车贷复议表,微服务断路器
 * 一个微服务的超时失败可能导致瀑布式连锁反映Hystrix通过自主反馈实现的断路器，
 * 防止了这种情况发生调用失败达到一个特定的阀值(5秒之内发生20次失败是Hystrix定义的缺省值), 链路就会被处于open状态，
 * 之后所有所有对服务B的调用都不会被执行，
 * 取而代之的是由断路器提供的一个表示链路open的Fallback消息.  Hystrix提供了相应机制
 *
 * @author:  zhouzhiwei
 */
@Component
@Log
public class  CarLoanReconsiderationServiceHystrix implements  CarLoanReconsiderationServicefeign{

		@Override
		public ResponseResult<Object> queryCarLoanReconsiderationByPrimaryKey(String message) {
			return GetResponseResult.result();

		}
	    @Override
		public ResponseResult<Object> getCarLoanReconsiderationList(@RequestParam("ordernum") String ordernum){
			return GetResponseResult.result();
		}




}
