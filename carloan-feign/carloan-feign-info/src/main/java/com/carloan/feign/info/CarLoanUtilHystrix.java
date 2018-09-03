package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanLogDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanUtilHystrix
 * @description:
 * @date 2018/7/10：15:48
 */
@Component
public class CarLoanUtilHystrix implements CarLoanLogServiceFeign,CarLoanSurveyContactsServicrfeign {
    public ResponseResult<Object> queryEntity(@RequestBody CarLoanLogDTO carLoanLogDTO) {
        return GetResponseResult.result();
    }

    public ResponseResult<Object> queryEntityList(String msg) {
        return GetResponseResult.result();
    }
}
