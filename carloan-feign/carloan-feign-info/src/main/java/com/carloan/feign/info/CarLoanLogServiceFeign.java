package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanLogDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanLogServiceFeign
 * @description:
 * @date 2018/7/10：15:18
 */
@FeignClient(value = "carloan-service-info",path = "/CarLoanLogRest-api" ,fallback = CarLoanUtilHystrix.class)
public interface CarLoanLogServiceFeign {

    @RequestMapping(value = "/get/entityList", method = RequestMethod.POST)
    ResponseResult<Object> queryEntity(@RequestBody CarLoanLogDTO carLoanLogDTO);
}
