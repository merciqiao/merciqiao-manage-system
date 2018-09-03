package com.carloan.feign.info;



import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.MyTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018-07-02.
 */
@FeignClient(value = "carloan-service-info",path = "/myTask-api" ,fallback = MyTaskServiceHystrix.class)
public interface MyTaskServiceFeign {
    @RequestMapping(value = "/findMyTaskTodoList", method = RequestMethod.POST)
    ResponseResult<Object> findMyTaskTodoList(@RequestBody MyTaskVo carLoanInfoParam);

    @RequestMapping(value = "/findMyTaskDonerList", method = RequestMethod.POST)
    ResponseResult<Object> findMyTaskDonerList(@RequestBody MyTaskVo carLoanInfoParam);

    @RequestMapping(value = "/findMyTaskEndList", method = RequestMethod.POST)
    ResponseResult<Object> findMyTaskEndList(@RequestBody MyTaskVo carLoanInfoParam);

    @RequestMapping(value = "/updateCarStartEndTime", method = RequestMethod.POST)
    public ResponseResult<Object> updateCarStartEndTime(@RequestParam("inid") String inid);
}
