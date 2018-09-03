package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangyl on 2018/8/8
 */
@FeignClient(value = "carloan-service-info", path = "/asyn", fallback = Jbpm4ServiceHystrix.class)
public interface CarBizAsynJobTaskFeign {
    /**
     * 启动异步定时任务
     *
     * @return
     */
    @RequestMapping(value = "/executeAsynJob/{jobState}", method = RequestMethod.PUT)
    ResponseResult<Integer> executeAsynJob(@PathVariable("jobState") int jobState);
}
