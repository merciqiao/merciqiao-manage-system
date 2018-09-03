package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanSurveyContactsServicrfeigm
 * @description:
 * @date 2018/7/12：13:34
 */
@FeignClient(value = "carloan-service-info",path = "/CarLoanUserContactsRest-api" ,fallback = CarLoanUtilHystrix.class)
public interface CarLoanSurveyContactsServicrfeign {

    @RequestMapping(value = "/get/entity", method = RequestMethod.POST)
    ResponseResult<Object> queryEntityList(@RequestParam("order_number") String order_number);

}
