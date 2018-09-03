package com.carloan.service.provider01.tccteacher.rest;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.tcc.TccTeacher;
import com.carloan.service.provider01.tccteacher.dto.TccTeacherDTO;
import com.carloan.service.provider01.tccteacher.service.ITccTeacherService;
import com.carloan.service.provider01.tccteacher.service.TccTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.compensable.Compensable;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/tccTeacher")
@Slf4j
@Api(tags = {"tcc_teacher"})
@Compensable(interfaceClass = ITccTeacherService.class,
        confirmableKey = "TccTeacherServiceConfirm",
        cancellableKey = "TccTeacherServiceCancel")
public class TccTeacherRest implements ITccTeacherService {


    @Autowired
    private TccTeacherService service;
    @Autowired
    Mapper mapper;

    /**
     * 修改一个业务对象
     *
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult update(@RequestBody TccTeacher objParam) throws IllegalStateException {
        ResponseResult result = new ResponseResult();
        try {
            TccTeacherDTO dto=mapper.map(objParam,TccTeacherDTO.class);

            service.updateTccTeacher(dto);
            result.setStatus(Status.SUCCESS);
            result.setMessage("修改成功");
            log.info("执行try");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


}