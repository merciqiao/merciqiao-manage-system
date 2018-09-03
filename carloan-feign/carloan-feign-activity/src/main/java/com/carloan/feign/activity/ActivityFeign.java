package com.carloan.feign.activity;

import com.carloan.apimodel.activiti.dto.ActivitiInfoVO;
import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "carloan-service-activiti",path = "/activity-api")
public interface ActivityFeign {
    /**
     * 发起工作流
     * @param activitiParamVO
     * @return
     */
    @RequestMapping(value = "/workflow.start", method = RequestMethod.POST)
    ResponseResult<ActivitiInstanceInfoVO> startprocess(@RequestBody ActivitiInfoVO activitiParamVO);

    @RequestMapping(value = "/workflow.do", method = RequestMethod.POST)
    Response doworkflow(@RequestBody ActivitiInstanceInfoVO instance);
}

