package com.carloan.service.provider01.tccteacher.service;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.tcc.TccTeacher;
import com.carloan.service.provider01.tccteacher.dto.TccTeacherDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITccTeacherService {

    ResponseResult update(@RequestBody TccTeacher obj) throws IllegalStateException;
}
