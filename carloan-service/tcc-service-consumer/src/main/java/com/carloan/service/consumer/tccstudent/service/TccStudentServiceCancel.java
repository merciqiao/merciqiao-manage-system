package com.carloan.service.consumer.tccstudent.service;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.service.consumer.tccstudent.dto.TccStudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TccStudentServiceCancel")
@Slf4j
public class TccStudentServiceCancel implements ITccStudentService{
    @Override
    @Transactional
    public ResponseResult update(TccStudentDTO obj) throws IllegalStateException {
        log.info("执行cancel");
        return null;
    }
}
