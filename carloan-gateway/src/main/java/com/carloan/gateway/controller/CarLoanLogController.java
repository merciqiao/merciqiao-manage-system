package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanLogDTO;
import com.carloan.feign.info.CarLoanLogServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanLogController
 * @description:
 * @date 2018/7/13：10:53
 */
@RestController
@RequestMapping(value="/web-CarLoanLogRest-api")
@Slf4j
@Api(tags = {"进件日志接口查询-zhouzhiwei"})
public class CarLoanLogController {
    @Autowired
    private CarLoanLogServiceFeign carLoanLogServiceFeign;


    /**
     * 取得单个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryEntityCarLogList", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询进件日志信息", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> queryEntityCarLogList(@RequestBody CarLoanLogDTO carLoanLogDTO)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            result =carLoanLogServiceFeign.queryEntity(carLoanLogDTO);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

}
