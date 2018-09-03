package com.carloan.feign.info;



import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.MyTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018-07-02.
 */
@FeignClient(value = "carloan-service-info",path = "/Monitoring-api" ,fallback = MonitoringHystrix.class)
public interface MonitoringFeign {
    @RequestMapping(value = "/findsearchMonitorTodo", method = RequestMethod.POST)
    ResponseResult<Object> findsearchMonitorTodo(@RequestBody MyTaskVo carLoanInfoParam);

    @RequestMapping(value = "/findsearchMonitorTone", method = RequestMethod.POST)
    ResponseResult<Object> findsearchMonitorTone(@RequestBody MyTaskVo carLoanInfoParam);

    @RequestMapping(value = "/findsearchMonitorEnd", method = RequestMethod.POST)
    ResponseResult<Object> findsearchMonitorEnd(@RequestBody MyTaskVo carLoanInfoParam);
}
