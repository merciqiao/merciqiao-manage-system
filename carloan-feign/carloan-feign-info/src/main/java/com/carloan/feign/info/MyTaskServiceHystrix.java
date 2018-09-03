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
public class MyTaskServiceHystrix implements MyTaskServiceFeign {
    @Override
    public ResponseResult<Object> findMyTaskTodoList(MyTaskVo carLoanInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("findMyTaskTodoList.hystrix_failed");
        log.error("findMyTaskTodoList.hystrix_failed");
        return responseResult;
    }
    @Override
    public ResponseResult<Object> findMyTaskDonerList(MyTaskVo carLoanInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("findMyTaskDonerList.hystrix_failed");
        log.error("findMyTaskDonerList.hystrix_failed");
        return responseResult;
    }
    @Override
    public ResponseResult<Object> findMyTaskEndList(MyTaskVo carLoanInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("findMyTaskEndList.hystrix_failed");
        log.error("findMyTaskEndList.hystrix_failed");
        return responseResult;
    }
    @Override
    public ResponseResult<Object> updateCarStartEndTime(String inid) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("updateCarStartEndTime.hystrix_failed");
        log.error("updateCarStartEndTime.hystrix_failed");
        return responseResult;
    }
}
