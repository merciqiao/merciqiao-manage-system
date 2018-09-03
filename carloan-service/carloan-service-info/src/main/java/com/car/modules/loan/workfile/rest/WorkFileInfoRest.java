package com.car.modules.loan.workfile.rest;

import com.car.modules.loan.workfile.dto.WorkFileInfoDTO;
import com.car.modules.loan.workfile.service.WorkFileInfoService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.WorkFileInfoParam;
import com.github.pagehelper.PageInfo;
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
public class WorkFileInfoRest {
    @Autowired
    private WorkFileInfoService service;

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "查询质检以后的所有进件信息", notes = "", httpMethod = "POST")
    public ResponseResult<List<WorkFileInfoDTO>> query(@RequestBody WorkFileInfoParam param) throws Exception {
        ResponseResult<List<WorkFileInfoDTO>> result = new ResponseResult<>();
        try {
            PageInfo<WorkFileInfoDTO> pageInfo = service.query(param);
            result.setData(pageInfo.getList());
            result.setCount((int) pageInfo.getTotal());
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
}
