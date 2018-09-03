package com.carloan.service.consumer.tccstudent.service;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.service.consumer.tccstudent.dto.TccStudentDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITccStudentService {
    public ResponseResult update(@RequestBody TccStudentDTO obj) throws IllegalStateException;
}
