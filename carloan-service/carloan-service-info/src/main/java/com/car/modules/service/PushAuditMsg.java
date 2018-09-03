package com.car.modules.service;

import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.carloan.apimodel.order.CarAuditState;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushAuditMsg {
    @Autowired
    private PushCarPrice pushCarPrice;
    @Autowired
    private PushCarUserMsg pushCarUserMsg;
    @Autowired
    private CarLoanInfoService carLoanInfoService;
    public Boolean PushMsg(String orderid) throws Exception {
        CarLoanInfoDTO carloan=carLoanInfoService.queryCarLoanInfoByPrimaryKey(orderid);
        String status= CarAuditState.getIntoStateByAuditState(carloan.getAuditeState());
        String orderNumber=carloan.getOrderNumber();
        String[] carStatus = new String[]{"301", "304", "305"};
        String[] carUserStatus = new String[]{"401", "403", "404","406", "407", "408"};
        if (StringUtils.startsWithAny(status, carStatus)) {
          return   this.pushCarPrice.executeAsynJob(orderNumber, status);
        } else if (StringUtils.startsWithAny(status, carUserStatus)) {
         return    this.pushCarUserMsg.executeAsynJob(orderNumber, status);
        }
        return true;
    }
}
