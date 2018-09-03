package com.car.modules.service;

import com.alibaba.fastjson.JSON;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanlog.service.CarLoanLogService;
import com.car.modules.loan.carloanprice.dto.CarLoanPriceDTO;
import com.car.modules.reqvo.ResponseTitle;
import com.car.modules.reqvo.Variable;
import com.car.modules.util.FormatUtil;
import com.car.modules.util.GetExceptionInfo;
import com.carloan.feign.admin.SysPushMqServicefeign;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Map;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: PushMqV1
 * @description:
 * @date 2018/5/30：9:20
 */
@Service
public class PushCarPrice {
    private Logger logger = LoggerFactory.getLogger(PushCarPrice.class);

    @Autowired
    private  CarLoanInfoService carLoanInfoService;
    @Autowired
    private CarLoanLogService carLoanLogService;
    @Autowired
    private SysPushMqServicefeign sysPushMqServicefeign;;
    public boolean executeAsynJob(String orderNumber, String status) throws Exception {
            String json = "";
            String errmesage = "";
            boolean isok=true;
            try {
                Map<String, String> map = carLoanInfoService.getValueMap(MessageFormat.format(Variable.V3, Variable.Assemble(orderNumber), Variable.Assemble(status)));
                ResponseTitle responseTitle = new ResponseTitle();
                CarLoanPriceDTO carLoanPriceDTO = new CarLoanPriceDTO();
                switch (status) {
                    case "304":
                        carLoanPriceDTO.setPricingMoney(MapUtils.getString(map, "PRICING_MONEY"));
                        break;
                }
                responseTitle.setOrderNumber(orderNumber);
                responseTitle.setStatus(status);
                carLoanPriceDTO.setOrderNumber(orderNumber);
                carLoanPriceDTO.setPricingRemarks(MapUtils.getString(map, "PRICING_REMARKS"));
                responseTitle.setCarLoanPriceDTO(carLoanPriceDTO);
                json = JSON.toJSONString(responseTitle);
                sysPushMqServicefeign.PushMqCarMessge(json);
                logger.info("结束任务推送，进件编号:{},状态:{},推送消息:{}",orderNumber,status,json);
            } catch (Exception e) {
                e.printStackTrace();
                errmesage = GetExceptionInfo.getExceptionInfo(e);
                logger.info("PushMqCarUserMsg任务异常,进件编号:{},状态:{}",orderNumber,status);
                isok=false;
            } finally {
                carLoanLogService.insertCarLoanLog(orderNumber, status, FormatUtil.formatJson(json), errmesage);
            }
            return isok;
    }
}