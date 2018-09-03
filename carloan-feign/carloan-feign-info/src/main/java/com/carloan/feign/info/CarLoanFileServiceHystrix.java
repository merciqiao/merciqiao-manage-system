package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanFileServiceHystrix
 * @description:
 * @date 2018/7/4：14:49
 */
@Component
public class CarLoanFileServiceHystrix implements CarLoanFileServiceFeign {
    @Override
    public ResponseResult<Object> queryEntity(String order_number) {
        return GetResponseResult.result();
    }

}
