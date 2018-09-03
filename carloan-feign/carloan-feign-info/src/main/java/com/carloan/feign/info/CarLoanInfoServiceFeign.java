package com.carloan.feign.info;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanInfoParam;
import com.carloan.apimodel.order.CarLoanInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @projectname 项目名称: ${project_name}
 * @classname: InserttheorderServiceFeign
 * @description:
 * @date 2018/6/25：13:08
 */
@FeignClient(value = "carloan-service-info",path = "/CarLoanInfoRest-api" ,fallback = CarLoanInfoServiceHystrix.class)
public interface CarLoanInfoServiceFeign {

    @RequestMapping(value = "/queryCarLoanInfoByPrimaryKey", method = RequestMethod.POST)
    ResponseResult<CarLoanInfoVo> queryCarLoanInfoByPrimaryKey(@RequestBody CarLoanInfoParam carLoanInfoParam);

    @RequestMapping(value = "/updateCarLoanInfoAuditState", method = RequestMethod.POST)
    Response updateCarLoanInfoAuditState(@RequestBody CarLoanInfoParam carLoanInfoParam);

    @RequestMapping(value = "/get/entity", method = RequestMethod.POST)
    ResponseResult<Object> queryEntity(@RequestParam("order_number") String order_number);
}
