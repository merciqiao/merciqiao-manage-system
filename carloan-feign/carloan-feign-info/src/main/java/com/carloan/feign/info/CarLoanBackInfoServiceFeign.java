package com.carloan.feign.info;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanBackInfoParam;
import com.carloan.apimodel.order.CarLoanBackInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "carloan-service-info",path = "/CarLoanBackInfoRest-api" ,fallback = CarLoanBackInfoServiceHystrix.class)
public interface CarLoanBackInfoServiceFeign {
    @RequestMapping(value = "/get/entity",method = RequestMethod.POST)
    ResponseResult<CarLoanBackInfoVo> queryEntity(@RequestParam("orderId") String orderId,@RequestParam("ordertypecode") String ordertypecode);

    @RequestMapping(value = "/updateBackInfo",method = RequestMethod.POST)
    Response updateBackInfo(@RequestBody CarLoanBackInfoParam carLoanBackInfoParam);
    @RequestMapping(value = "/insertCarLoanBackInfo",method = RequestMethod.POST)
    Response insertCarLoanBackInfo(@RequestBody CarLoanBackInfoParam carLoanBackInfoParam);
}
