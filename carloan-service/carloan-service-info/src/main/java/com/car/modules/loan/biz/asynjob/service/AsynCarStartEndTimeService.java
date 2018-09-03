package com.car.modules.loan.biz.asynjob.service;

import com.car.modules.jbpm.service.MyTaskService;
import com.carloan.apimodel.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("com.car.modules.loan.biz.asynjob.service.AsynCarStartEndTimeService")
public class AsynCarStartEndTimeService implements IBizAsynJobService {

    @Autowired
    private MyTaskService taskService;
    private Logger logger = LoggerFactory.getLogger(AsynCarStartEndTimeService.class);

    @Override()
    public boolean executeAsynJob(String bizKeyId) throws Exception {
        logger.info("==========AsynCarStartEndTimeService=====start==bizKeyId:" + bizKeyId);
        Response result = new Response();
        Map<String, Object> searchParams = new HashMap<String, Object>();
        searchParams.put("in_id", bizKeyId);
        taskService.updateCarStartEndTime(searchParams);
        logger.info("==========AsynCarStartEndTimeService=====end===bizKeyId:" + bizKeyId);
        return true;
    }
}
