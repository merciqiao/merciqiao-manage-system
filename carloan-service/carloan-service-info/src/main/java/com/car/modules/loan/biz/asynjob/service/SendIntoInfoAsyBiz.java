package com.car.modules.loan.biz.asynjob.service;

import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanlog.service.CarLoanLogService;
import com.car.modules.service.PushAuditMsg;
import com.carloan.apimodel.order.CarAuditState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.car.modules.loan.biz.asynjob.service.SendIntoInfoAsyBiz")
public class SendIntoInfoAsyBiz implements IBizAsynJobService{
    @Autowired
    private CarLoanInfoService carLoanInfoService;
    @Autowired
    private PushAuditMsg  pushAuditMsg;
    private Logger logger = LoggerFactory.getLogger(SendIntoInfoAsyBiz.class);
    @Override()
    public boolean executeAsynJob(String bizKeyId)throws Exception {
        logger.info("==========SendIntoInfoAsyBiz=====start==bizKeyId:"+bizKeyId);
       boolean result= pushAuditMsg.PushMsg(bizKeyId);
        logger.info("==========SendIntoInfoAsyBiz=====end===bizKeyId:"+bizKeyId);
        return result;
    }
}
