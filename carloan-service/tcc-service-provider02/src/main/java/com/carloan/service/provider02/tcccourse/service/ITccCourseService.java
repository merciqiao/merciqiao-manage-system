package com.carloan.service.provider02.tcccourse.service;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.tcc.TccCourse;
import com.carloan.service.provider02.tcccourse.dto.TccCourseDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITccCourseService {
    ResponseResult update(@RequestBody TccCourse obj) throws IllegalStateException;
}
