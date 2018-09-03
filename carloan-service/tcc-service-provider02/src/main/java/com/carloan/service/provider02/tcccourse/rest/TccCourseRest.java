package com.carloan.service.provider02.tcccourse.rest;

import java.util.List;


import com.carloan.apimodel.tcc.TccCourse;
import com.carloan.service.provider02.tcccourse.service.ITccCourseService;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.Compensable;
import org.bytesoft.compensable.CompensableContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.provider02.tcccourse.dto.TccCourseDTO;
import com.carloan.service.provider02.tcccourse.service.TccCourseService;
import io.swagger.annotations.Api;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/tccCourse")
@Slf4j
@Api(tags = {"tcc_course"})
@Compensable(interfaceClass = ITccCourseService.class,
        confirmableKey = "TccCourseServiceConfirm",
        cancellableKey = "TccCourseServiceCancel")
public class TccCourseRest implements ITccCourseService,CompensableContextAware {


    @Autowired
    private TccCourseService service;
    @Autowired
    Mapper mapper;
    private CompensableContext compensableContext;

    /**
     * 修改一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    @Transactional
    public ResponseResult update(@RequestBody TccCourse obj) throws IllegalStateException {
        ResponseResult result = new ResponseResult();
        try {
            this.compensableContext.setVariable("num", "123");
            TccCourseDTO dto=mapper.map(obj,TccCourseDTO.class);

            service.updateTccCourse(dto);
            result.setStatus(Status.SUCCESS);
            result.setMessage("修改成功");
            log.info("执行try");
            //throw new IllegalStateException("异常222");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            //throw new IllegalStateException("异常222");
            return result;
        }
    }

    @Override
    public void setCompensableContext(CompensableContext compensableContext) {
        this.compensableContext = compensableContext;
    }
}