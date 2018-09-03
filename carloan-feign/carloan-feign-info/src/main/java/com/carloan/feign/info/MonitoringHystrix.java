package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.MyTaskVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2018-07-02.
 */
@Component
@Slf4j
public class MonitoringHystrix implements MonitoringFeign {
    @Override
    public ResponseResult<Object> findsearchMonitorTodo(MyTaskVo carLoanInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("findsearchMonitorTodo.hystrix_failed");
        log.error("findsearchMonitorTodo.hystrix_failed");
        return responseResult;
    }
    @Override
    public ResponseResult<Object> findsearchMonitorTone(MyTaskVo carLoanInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("findsearchMonitorTone.hystrix_failed");
        log.error("findsearchMonitorTone.hystrix_failed");
        return responseResult;
    }
    @Override
    public ResponseResult<Object> findsearchMonitorEnd(MyTaskVo carLoanInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("findsearchMonitorEnd.hystrix_failed");
        log.error("findsearchMonitorEnd.hystrix_failed");
        return responseResult;
    }
}
