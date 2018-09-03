package com.carloan.feign.workflow;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.workflow.TaskEventParam;
import com.carloan.apimodel.workflow.TransitionParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "carloan-service-workflow",path = "/workflow-api",fallback = WorkFlowHystrix.class)
public interface WorkFlowFeign {
    //发起流程 start

    @RequestMapping(value = "/startProcessByOrderId_XinShen", method = RequestMethod.POST)
    Response startProcessByOrderId_XinShen(@RequestParam("orderId") String orderId);

    @RequestMapping(value = "/startProcessByOrderId_DingJia", method = RequestMethod.POST)
    Response startProcessByOrderId_DingJia(@RequestParam("orderId") String orderId);

    @RequestMapping(value = "/startProcessByOrderId_FuYi", method = RequestMethod.POST)
    Response startProcessByOrderId_FuYi(@RequestParam("orderId") String orderId);

    //发起流程 end

    //更新状态事件 start
    @RequestMapping(value = "/updateState_XinShen", method = RequestMethod.POST)
    Response updateOrderState_XinShen(@RequestBody TaskEventParam taskEventParam);
    @RequestMapping(value = "/updateOrderState_DingJia",method = RequestMethod.POST)
    Response updateOrderState_DingJia(@RequestBody TaskEventParam taskEventParam);

    @RequestMapping(value = "/updateOrderState_FuYi",method = RequestMethod.POST)
    Response updateOrderState_FuYi(@RequestBody TaskEventParam taskEventParam);
    //更新状态事件 end

    //流程流转 start
    @RequestMapping(value = "/doTransition_XinShen",method = RequestMethod.POST)
    Response doTransition_XinShen(@RequestBody TransitionParam transitionParam);
    @RequestMapping(value = "/doTransition_DingJia",method = RequestMethod.POST)
    Response doTransition_DingJia(@RequestBody TransitionParam transitionParam);
    @RequestMapping(value = "/doTransition_FuYi",method = RequestMethod.POST)
    Response doTransition_FuYi(@RequestBody TransitionParam transitionParam);
    @RequestMapping(value = "/doTransition_XinShen_Attach",method = RequestMethod.POST)
    Response doTransition_XinShen_Attach(@RequestBody TransitionParam transitionParam);
    @RequestMapping(value = "/doTransition_DingJia_Attach",method = RequestMethod.POST)
    Response doTransition_DingJia_Attach(@RequestBody TransitionParam transitionParam);
    //流程流转 end
}
