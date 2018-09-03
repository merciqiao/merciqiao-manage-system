package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.WorkFileInfoDTO;
import com.carloan.apimodel.order.WorkFileInfoParam;
import com.carloan.feign.info.WorkFileInfoServicefeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/workfile")
@Slf4j
@Api(tags = {"工作件查询-xiao"})
public class WorkFileInfoController {
    @Autowired
    private WorkFileInfoServicefeign feiservice;

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "查询质检以后的所有进件信息", notes = "", httpMethod = "POST")
    public ResponseResult<List<WorkFileInfoDTO>> query(@RequestBody WorkFileInfoParam obj) throws Exception {
        ResponseResult<List<WorkFileInfoDTO>> result = new ResponseResult<>();
        try {
            return feiservice.query(obj);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
}
