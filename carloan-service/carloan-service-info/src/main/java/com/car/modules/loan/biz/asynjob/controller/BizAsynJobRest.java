package com.car.modules.loan.biz.asynjob.controller;

import com.car.modules.loan.biz.asynjob.service.BizAsynJobService;
import com.carloan.apimodel.biz.BizAsynJobVO;
import com.carloan.apimodel.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by zhangyl on 2018/8/8
 */
@RestController
@RequestMapping("/asyn")
@Api(tags = "异步任务处理")
public class BizAsynJobRest {
    @Autowired
    private BizAsynJobService bizAsynJobService;

    @ApiOperation(value = "添加异步调用任务")
    @RequestMapping(value = "insertBizAsynJob", method = RequestMethod.POST)
    public ResponseResult<Integer> insertBizAsynJob(@Valid @RequestBody BizAsynJobVO bizAsynJobVO, BindingResult bindingResult) {
        ResponseResult responseResult = new ResponseResult();
        int result = bizAsynJobService.insert(bizAsynJobVO);
        responseResult.setData(result);
        return responseResult;
    }

    @RequestMapping(value = "executeAsynJob/{jobState}", method = RequestMethod.PUT)
    public ResponseResult<Integer> executeAstnJob(@PathVariable("jobState") int jobState) {
        bizAsynJobService.executeAsynJob(jobState);
        return new ResponseResult();
    }
}
