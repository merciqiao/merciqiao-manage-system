package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.WorkFileInfoDTO;
import com.carloan.apimodel.order.WorkFileInfoParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "carloan-service-info", path = "/api/workfile", fallback = WorkFileInfoHystrix.class)
public interface WorkFileInfoServicefeign {

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    ResponseResult<List<WorkFileInfoDTO>> query(@RequestBody WorkFileInfoParam param);

}
