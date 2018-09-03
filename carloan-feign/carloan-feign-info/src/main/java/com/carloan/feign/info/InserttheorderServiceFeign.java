package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: InserttheorderServiceFeign
 * @description:
 * @date 2018/6/25：13:08
 */
@FeignClient(value = "carloan-service-info",path = "/car-info-api" ,fallback = InserttheorderServiceHystrix.class)
public interface InserttheorderServiceFeign {

    @RequestMapping(value = "/insertInfo", method = RequestMethod.POST)
    ResponseResult<String>  insertInfo( @RequestParam("message") String message);


}
