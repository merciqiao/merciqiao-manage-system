package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanUserServiceHystrix
 * @description:
 * @date 2018/7/3：13:54
 */
@Component
@Slf4j
public class CarLoanUserServiceHystrix implements CarLoanUserServiceFeign {
    @Override
    public ResponseResult<Object> queryEntity(String order_number) {
        return GetResponseResult.result();
    }
}
