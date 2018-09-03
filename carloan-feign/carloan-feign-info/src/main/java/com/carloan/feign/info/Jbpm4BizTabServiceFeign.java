package com.carloan.feign.info;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.Jbpm4BizTabParam;
import com.carloan.apimodel.order.Jbpm4BizTabVo;
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
@FeignClient(value = "carloan-service-info",path = "/car-info-api" ,fallback = Jbpm4BizTabServiceHystrix.class)
public interface Jbpm4BizTabServiceFeign {

    @RequestMapping(value = "/insertJbpm4BizTab", method = RequestMethod.POST)
    Response insertJbpm4BizTab(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam);
    @RequestMapping(value = "/findTaskInfoByOrderNum",method = RequestMethod.POST)
    ResponseResult<Jbpm4BizTabVo> findTaskInfoByOrderNum(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam);
    @RequestMapping(value = "/updateJbpm4BizTabOver",method = RequestMethod.POST)
    Response updateJbpm4BizTabOver(@RequestParam("pro_instance_id") String pro_instance_id);
    @RequestMapping(value = "/saveJbpm4BizTab",method = RequestMethod.POST)
    Response saveJbpm4BizTab(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam);
    @RequestMapping(value = "/findJbpm4BizTabExist",method = RequestMethod.POST)
    Response findJbpm4BizTabExist(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam);
}
