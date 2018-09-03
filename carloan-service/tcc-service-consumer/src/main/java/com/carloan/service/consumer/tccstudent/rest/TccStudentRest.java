package com.carloan.service.consumer.tccstudent.rest;

import java.util.Date;
import java.util.List;


import com.carloan.apimodel.tcc.TccCourse;
import com.carloan.apimodel.tcc.TccTeacher;
import com.carloan.feign.tcc.TccCourseServicefeign;
import com.carloan.feign.tcc.TccTeacherServicefeign;
import com.carloan.service.consumer.tccstudent.service.ITccStudentService;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.consumer.tccstudent.dto.TccStudentDTO;
import com.carloan.service.consumer.tccstudent.service.TccStudentService;
import io.swagger.annotations.Api;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/tccStudent")
@Slf4j
@Api(tags = {"tcc_student"})
@Compensable(interfaceClass = ITccStudentService.class,
        confirmableKey = "TccStudentServiceConfirm",
        cancellableKey = "TccStudentServiceCancel")
public class TccStudentRest implements ITccStudentService{


    @Autowired
    private TccStudentService service;
    @Autowired
    TccTeacherServicefeign tccTeacherServicefeign;
    @Autowired
    TccCourseServicefeign tccCourseServicefeign;
    /**
     * 修改一个业务对象
     *
     * @return
     */

    @Transactional(rollbackFor = {Exception.class})
    @ResponseBody
    @RequestMapping(value = "/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult update(@RequestBody TccStudentDTO obj) throws IllegalStateException {
        ResponseResult result = new ResponseResult();
        obj=new TccStudentDTO();
        obj.setId(1);
        obj.setCreatetime(new Date());
        service.updateTccStudent(obj);

        TccTeacher tccTeacher=new TccTeacher();
        tccTeacher.setId(1);
        tccTeacher.setCreatetime(new Date());
        ResponseResult result1= tccTeacherServicefeign.updateTccTeacher(tccTeacher);

        TccCourse tccCourse=new TccCourse();
        tccCourse.setId(1);
        tccCourse.setCreatetime(new Date());
        ResponseResult result2=tccCourseServicefeign.updateTccCourse(tccCourse);
        if(!ResponseResult.isSucess(result2)){
            throw new IllegalStateException("接口2异常");
        }
        result.setStatus(Status.SUCCESS);
        result.setMessage("修改成功");
        //throw new IllegalStateException("rest调用回滚异常");

        return result;

    }



    @Transactional(rollbackFor = {Exception.class})
    public ResponseResult update2(@RequestBody TccStudentDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        obj=new TccStudentDTO();
        obj.setId(1);
        obj.setCreatetime(new Date());
        service.updateTccStudent(obj);

        TccTeacher tccTeacher=new TccTeacher();
        tccTeacher.setId(1);
        tccTeacher.setCreatetime(new Date());
        ResponseResult result1= tccTeacherServicefeign.updateTccTeacher(tccTeacher);

        TccCourse tccCourse=new TccCourse();
        tccCourse.setId(1);
        tccCourse.setCreatetime(new Date());
        ResponseResult result2=tccCourseServicefeign.updateTccCourse(tccCourse);
        if(!ResponseResult.isSucess(result2)){
            throw new Exception("接口2异常");
        }
        result.setStatus(Status.SUCCESS);
        result.setMessage("修改成功");
        throw new Exception("rest调用回滚异常");

    }

//    /**
//     * 插入一个业务对象
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/create/v1", method = RequestMethod.POST)
//    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
//    public ResponseResult create(@RequestBody TccStudentDTO obj) throws Exception {
//        ResponseResult result = new ResponseResult();
//        try {
//            service.insertTccStudent(obj);
//            result.setStatus(Status.SUCCESS);
//            result.setMessage("新增成功");
//            return result;
//        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("执行异常,请重试");
//            return result;
//
//        }
//    }




}