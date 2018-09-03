package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.Jbpm4HistTaskParam;
import com.carloan.apimodel.order.Jbpm4HistTaskVo;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @classname: Jbpm4HistTaskServiceHystrix
 * @description: 定义  jbpm4_hist_task,微服务断路器
 * 一个微服务的超时失败可能导致瀑布式连锁反映Hystrix通过自主反馈实现的断路器，
 * 防止了这种情况发生调用失败达到一个特定的阀值(5秒之内发生20次失败是Hystrix定义的缺省值), 链路就会被处于open状态，
 * 之后所有所有对服务B的调用都不会被执行，
 * 取而代之的是由断路器提供的一个表示链路open的Fallback消息.  Hystrix提供了相应机制
 *
 * @author:  zhouzhiwei
 */
@Component
@Log
public class  Jbpm4HistTaskServiceHystrix implements  Jbpm4HistTaskServicefeign{

		@Override
		public ResponseResult<Object> queryJbpm4HistTaskByPrimaryKey(String message) {
			return GetResponseResult.result();

		}
		public ResponseResult<Object> queryJbpm4HistTaskList(@RequestBody Jbpm4HistTaskParam obj){
			return GetResponseResult.result();
		}


		@Override
		public ResponseResult<Jbpm4HistTaskVo> queryLikeJbpm4HistTask(@RequestBody Jbpm4HistTaskParam obj) {
			return GetResponseResult.result();
		}

		@Override
		public ResponseResult<String> insertJbpm4HistTask(@RequestBody Jbpm4HistTaskParam obj) {
			return GetResponseResult.result();

		}

		@Override
		public ResponseResult<String> updateJbpm4HistTask(@RequestBody Jbpm4HistTaskParam obj) {
			return GetResponseResult.result();

		}
	@Override
	public ResponseResult<Object> searchHistTaskByOrdernum(@RequestParam("ordernum") String  ordernum){
		return GetResponseResult.result();
	}


}
