package com.car.modules.util;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: GetResponseResult
 * @description:
 * @date 2018/7/3：14:12
 */
@Slf4j
public class GetResponseResult {



    public static ResponseResult result(){
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("调用接口失败");
        log.info("调用接口失败");
        return responseResult;

    }
}
