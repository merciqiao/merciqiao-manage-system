package com.car.modules.loan.biz.asynjob.service;

import com.carloan.apimodel.common.Response;
import com.carloan.feign.workflow.WorkFlowFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.car.modules.loan.biz.asynjob.service.JbpmStartXSProAsynService")
public class JbpmStartXSProAsynService implements IBizAsynJobService{
    @Autowired
    private WorkFlowFeign workFlowFeign;
    private Logger logger = LoggerFactory.getLogger(SendIntoInfoAsyBiz.class);

    @Override()
    public boolean executeAsynJob(String bizKeyId) throws Exception {
        logger.info("==========JbpmStartProAsynService=====start==bizKeyId:" + bizKeyId);
        Response result = new Response();
        result = workFlowFeign.startProcessByOrderId_XinShen(bizKeyId);
        logger.info("==========JbpmStartProAsynService=====end===bizKeyId:" + bizKeyId);
        return Response.isSucess(result);
    }
}
