package com.carloan.feign.activity;

import com.carloan.apimodel.activiti.dto.ActivitiInfoVO;
import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActivityHystrix implements ActivityFeign{
    @Override
    public ResponseResult<ActivitiInstanceInfoVO> startprocess(ActivitiInfoVO activitiParamVO) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("startprocess.hystrix_failed");
        log.error("startprocess.hystrix_failed");
        return responseResult;
    }

    @Override
    public Response doworkflow(ActivitiInstanceInfoVO instance) {
        Response responseResult=new Response();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("doworkflow.hystrix_failed");
        log.error("doworkflow.hystrix_failed");
        return responseResult;
    }
}
