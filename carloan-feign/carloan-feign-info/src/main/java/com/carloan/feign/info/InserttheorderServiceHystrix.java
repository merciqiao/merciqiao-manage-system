package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: InserttheorderServiceHystrix
 * @description:
 * @date 2018/6/25：14:00
 */
@Component
@Log
public class InserttheorderServiceHystrix implements  InserttheorderServiceFeign {
    @Override
    public ResponseResult<String> insertInfo(String message) {
        ResponseResult responseResult=new ResponseResult();
        responseResult.setStatus(Status.HYSTRIX_FAILED);
        responseResult.setMessage("调用接口失败：[carloan-service-info]");
        log.info("调用接口失败：[carloan-service-info]");
        return responseResult;

    }
}
