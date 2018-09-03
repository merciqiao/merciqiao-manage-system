package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanInfoParam;
import com.carloan.apimodel.order.CarLoanInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: InserttheorderServiceHystrix
 * @description:
 * @date 2018/6/25：14:00
 */
@Component("com.carloan.feign.info.CarLoanInfoServiceHystrix")
@Slf4j
public class CarLoanInfoServiceHystrix implements  CarLoanInfoServiceFeign {
    @Override
    public ResponseResult<CarLoanInfoVo> queryCarLoanInfoByPrimaryKey(CarLoanInfoParam carLoanInfoParam) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("queryCarLoanInfoByPrimaryKey.hystrix_failed");
        log.error("queryCarLoanInfoByPrimaryKey.hystrix_failed");
        return responseResult;
    }

    @Override
    public Response updateCarLoanInfoAuditState(CarLoanInfoParam carLoanInfoParam) {
        Response responseResult=new Response();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("updateCarLoanInfoAuditState.hystrix_failed");
        log.error("updateCarLoanInfoAuditState.hystrix_failed");
        return responseResult;
    }

    @Override
    public ResponseResult<Object> queryEntity(String order_number) {
        return GetResponseResult.result();
    }
}
