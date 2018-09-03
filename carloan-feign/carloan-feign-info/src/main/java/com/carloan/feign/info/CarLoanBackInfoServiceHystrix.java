package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanBackInfoParam;
import com.carloan.apimodel.order.CarLoanBackInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CarLoanBackInfoServiceHystrix implements CarLoanBackInfoServiceFeign{
    @Override
    public ResponseResult<CarLoanBackInfoVo> queryEntity(String orderId,String ordertypecode) {
        return GetResponseResult.result();
    }

    @Override
    public Response updateBackInfo(CarLoanBackInfoParam carLoanBackInfoParam) {
        Response responseResult=new Response();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("updateBackInfo.hystrix_failed");
        log.error("updateBackInfo.hystrix_failed");
        return responseResult;
    }

    @Override
    public Response insertCarLoanBackInfo(CarLoanBackInfoParam carLoanBackInfoParam) {
        Response responseResult=new Response();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("insertCarLoanBackInfo.hystrix_failed");
        log.error("insertCarLoanBackInfo.hystrix_failed");
        return responseResult;
    }
}
