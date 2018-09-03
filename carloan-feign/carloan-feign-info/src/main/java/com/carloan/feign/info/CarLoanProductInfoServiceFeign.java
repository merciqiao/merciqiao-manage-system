package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanHistoryDetailDTO;
import com.carloan.apimodel.order.CarLoanProductDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "carloan-service-info",path = "/car-product-info",fallback = CarLoanProductInfoServiceHystrix.class)
public interface CarLoanProductInfoServiceFeign {

    @RequestMapping(value = "/querySysDictList",method = RequestMethod.POST)
    public List<Map> querySysDictList(@RequestParam("code") String code);

    @RequestMapping(value = "/queryCarProductData",method = RequestMethod.POST)
    ResponseResult<CarLoanProductDTO> queryCarProductData();
}
