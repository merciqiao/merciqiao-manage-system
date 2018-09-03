package com.carloan.service.provider02.tcccourse.service;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.tcc.TccCourse;
import com.carloan.service.provider02.tcccourse.dto.TccCourseDTO;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TccCourseServiceCancel")
@Slf4j
public class TccCourseServiceCancel implements ITccCourseService,CompensableContextAware {
    private CompensableContext compensableContext;
    @Override
    @Transactional
    public ResponseResult update(TccCourse obj) throws IllegalStateException {
        Object value = this.compensableContext.getVariable("num");
        log.info("执行cancel");
        return null;
    }

    @Override
    public void setCompensableContext(CompensableContext compensableContext) {
        this.compensableContext = compensableContext;
    }
}
