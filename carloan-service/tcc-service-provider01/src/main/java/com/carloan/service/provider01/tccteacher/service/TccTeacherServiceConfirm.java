package com.carloan.service.provider01.tccteacher.service;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.tcc.TccTeacher;
import com.carloan.service.provider01.tccteacher.dto.TccTeacherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TccTeacherServiceConfirm")
@Slf4j
public class TccTeacherServiceConfirm implements ITccTeacherService{
    @Override
    @Transactional
    public ResponseResult update(TccTeacher obj) throws IllegalStateException {
        log.info("执行confirm");
        return null;
    }
}
