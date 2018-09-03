package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.jbpm.ConsignTaskVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangyl on 2018/8/2
 */
@FeignClient(value = "carloan-service-info", path = "/jbpm", fallback = Jbpm4ServiceHystrix.class)
public interface Jbpm4ServiceFeign {
    /**
     *
     * 更换派单人
     * @return
     */
    @RequestMapping(value = "/updateAssignee", method = RequestMethod.POST)
    ResponseResult<Boolean> updateAssignee(@RequestBody ConsignTaskVO consignedTaskVO);
    /**
     *
     * 定时派单
     * @return
     */
    @RequestMapping(value = "/dispatchJob/{bizType}/{activityName}", method = RequestMethod.PUT)
    ResponseResult<Boolean> dispatchJob(@PathVariable("bizType") String bizType, @PathVariable("activityName") String activityName);

}
