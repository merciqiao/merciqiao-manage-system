package com.carloan.apimodel.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: GetResponseResult
 * @description:
 * @date 2018/7/3：15:13
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
    public static Response getResponse(String msg){
        Response response=new Response();
        response.setStatus(Status.HYSTRIX_FAILED);
        response.setMessage(msg);
        log.error(msg);
        return response;
    }
}
