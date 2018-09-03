package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.Jbpm4TaskParam;
import com.carloan.apimodel.order.Jbpm4TaskVo;
import com.carloan.apimodel.workflow.TaskEventParam;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @classname: Jbpm4TaskServiceHystrix
 * @description: 定义  jbpm4_task,微服务断路器
 * 一个微服务的超时失败可能导致瀑布式连锁反映Hystrix通过自主反馈实现的断路器，
 * 防止了这种情况发生调用失败达到一个特定的阀值(5秒之内发生20次失败是Hystrix定义的缺省值), 链路就会被处于open状态，
 * 之后所有所有对服务B的调用都不会被执行，
 * 取而代之的是由断路器提供的一个表示链路open的Fallback消息.  Hystrix提供了相应机制
 * @author: zhouzhiwei
 */
@Component
@Slf4j
public class Jbpm4TaskServiceHystrix implements Jbpm4TaskServicefeign {

    @Override
    public ResponseResult<Object> queryJbpm4TaskByPrimaryKey(String message) {
        return GetResponseResult.result();

    }

    public ResponseResult<Object> queryJbpm4TaskList(@RequestBody Jbpm4TaskParam obj) {
        return GetResponseResult.result();
    }


    @Override
    public ResponseResult<Jbpm4TaskVo> queryLikeJbpm4Task(@RequestBody Jbpm4TaskParam obj) {
        return GetResponseResult.result();
    }

    @Override
    public ResponseResult<String> insertJbpm4Task(@RequestBody Jbpm4TaskParam obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult<String> updateJbpm4Task(@RequestBody Jbpm4TaskParam obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult delete(Jbpm4TaskParam obj) {
        return GetResponseResult.result();
    }

    @Override
    public Response UpdateOrderState(TaskEventParam taskEventParam) {
        Response responseResult=new Response();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("updateBackInfo.hystrix_failed");
        log.error("UpdateOrderState.hystrix_failed");
        return responseResult;
    }
}
