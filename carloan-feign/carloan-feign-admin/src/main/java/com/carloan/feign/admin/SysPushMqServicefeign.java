package com.carloan.feign.admin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: SysPushMqServicefeign
 * @description:
 * @date 2018/8/17：11:17
 */
@FeignClient(value = "carloan-rabbitmq",path = "/api/car" ,fallback = SysPushMqServicefeignHystrix.class)
public interface SysPushMqServicefeign {

    @RequestMapping(value = "/PushMqCarMessge", method = RequestMethod.POST)
    public Object PushMqCarMessge(@RequestParam("messageStr") String messageStr);
}
