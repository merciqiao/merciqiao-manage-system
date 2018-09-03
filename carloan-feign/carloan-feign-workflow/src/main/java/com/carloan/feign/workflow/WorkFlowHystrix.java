package com.carloan.feign.workflow;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.workflow.TaskEventParam;
import com.carloan.apimodel.workflow.TransitionParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@Slf4j
public class WorkFlowHystrix implements WorkFlowFeign{
    @Override
    public Response startProcessByOrderId_XinShen(@RequestParam("orderId") String orderId) {
        String msg="WorkFlowHystrix.startProcessByOrderId_XinShen.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response startProcessByOrderId_DingJia(@RequestParam("orderId") String orderId) {
        String msg="WorkFlowHystrix.startProcessByOrderId_DingJia.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response startProcessByOrderId_FuYi(@RequestParam("orderId") String orderId) {
        String msg= "WorkFlowHystrix.startProcessByOrderId_FuYi.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response updateOrderState_XinShen(@RequestBody TaskEventParam taskEventParam) {
        String msg= "WorkFlowHystrix.updateOrderState_XinShen.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response updateOrderState_DingJia(@RequestBody TaskEventParam taskEventParam) {
        String msg= "WorkFlowHystrix.updateOrderState_DingJia.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response updateOrderState_FuYi(@RequestBody TaskEventParam taskEventParam) {
        String msg= "WorkFlowHystrix.updateOrderState_FuYi.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response doTransition_XinShen(@RequestBody TransitionParam transitionParam) {
        String msg= "WorkFlowHystrix.doTransition_XinShen.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response doTransition_DingJia(@RequestBody TransitionParam transitionParam) {
        String msg= "WorkFlowHystrix.doTransition_DingJia.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response doTransition_FuYi(@RequestBody TransitionParam transitionParam) {
        String msg= "WorkFlowHystrix.doTransition_FuYi.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response doTransition_XinShen_Attach(@RequestBody TransitionParam transitionParam) {
        String msg= "WorkFlowHystrix.doTransition_XinShen_Attach.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }

    @Override
    public Response doTransition_DingJia_Attach(@RequestBody TransitionParam transitionParam) {
        String msg= "WorkFlowHystrix.doTransition_DingJia_Attach.hystrix_failed";
        return GetResponseResult.getResponse(msg);
    }
}
