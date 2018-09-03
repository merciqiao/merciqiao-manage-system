package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanHistoryDetailDTO;
import com.carloan.apimodel.order.CarLoanUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CarLoanHistoryServiceHystrix implements CarLoanHistoryServiceFeign{
    @Override
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanPhoneHistory(String orderNumber) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("queryCarLoanPhoneHistory调用接口失败");
        log.info("queryCarLoanPhoneHistory调用接口失败");
        return responseResult;
    }

    @Override
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanCarNumberHistory(String orderNumber) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("queryCarLoanCarNumberHistory调用接口失败");
        log.info("queryCarLoanCarNumberHistory调用接口失败");
        return responseResult;
    }

    @Override
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanIdCardHistory(String orderNumber) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("queryCarLoanIdCardHistory调用接口失败");
        log.info("queryCarLoanIdCardHistory调用接口失败");
        return responseResult;
    }

    @Override
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanCarFrameNumberHistory(String orderNumber) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("queryCarLoanCarFrameNumberHistory调用接口失败");
        log.info("queryCarLoanCarFrameNumberHistory调用接口失败");
        return responseResult;
    }

    @Override
    public CarLoanUserVo queryCarLoanOne(String orderNumber) {
        return null;
    }
}
