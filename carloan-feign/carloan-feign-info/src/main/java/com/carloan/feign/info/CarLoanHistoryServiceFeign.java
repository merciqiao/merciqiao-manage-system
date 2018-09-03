package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanHistoryDetailDTO;
import com.carloan.apimodel.order.CarLoanUserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "carloan-service-info",path = "/car-history-info",fallback = CarLoanHistoryServiceHystrix.class)
public interface CarLoanHistoryServiceFeign {

    @RequestMapping(value = "/queryCarLoanPhoneHistory",method = RequestMethod.POST)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanPhoneHistory(@RequestParam("orderNumber") String orderNumber);

    @RequestMapping(value = "/getCarNumber",method = RequestMethod.POST)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanCarNumberHistory(@RequestParam("orderNumber") String orderNumber);

    @RequestMapping(value = "/getCarIdCard",method = RequestMethod.POST)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanIdCardHistory(@RequestParam("orderNumber") String orderNumber);

    @RequestMapping(value = "/getCarFrameNumbe",method = RequestMethod.POST)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanCarFrameNumberHistory(@RequestParam("orderNumber") String orderNumber);

    @RequestMapping(value = "/queryCarLoanOne",method = RequestMethod.POST)
    public CarLoanUserVo queryCarLoanOne(@RequestParam("orderNumber")String orderNumber);
}
