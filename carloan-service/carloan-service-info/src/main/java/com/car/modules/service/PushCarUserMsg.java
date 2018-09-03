package com.car.modules.service;

import com.alibaba.fastjson.JSON;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanlog.service.CarLoanLogService;
import com.car.modules.loan.carloanopinion.dto.CarLoanOpinionDTO;
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
 * @classname: PushMqCarUserMsg
 * @description:
 * @date 2018/5/30：14:38
 */
@Service
public class PushCarUserMsg {
    private Logger logger = LoggerFactory.getLogger(PushCarUserMsg.class);

    @Autowired
    private CarLoanInfoService carLoanInfoService;
    @Autowired
    private CarLoanLogService carLoanLogService;
    @Autowired
    private SysPushMqServicefeign sysPushMqServicefeign;;
    public boolean executeAsynJob(String orderNumber, String status) throws Exception {
            String errmesage = "";
            String json = "";
            try {
                Map<String, String> map = carLoanInfoService.getValueMap(MessageFormat.format(Variable.V5, Variable.Assemble(orderNumber), Variable.Assemble(status), Variable.Assemble("LOANPAYTYPE")));
                ResponseTitle responseTitle = new ResponseTitle();
                CarLoanOpinionDTO carLoanOpinionDTO = new CarLoanOpinionDTO();
                switch (status) {
                    case "403":
                        carLoanOpinionDTO.setApprovalPeriod(MapUtils.getString(map, "APPROVAL_PERIOD"));
                        carLoanOpinionDTO.setCurrentExaminationPost(MapUtils.getString(map, "CURRENT_EXAMINATION_POST"));
                        carLoanOpinionDTO.setContractAmount(MapUtils.getString(map, "CONTRACT_AMOUNT"));
                        carLoanOpinionDTO.setProductSeries(MapUtils.getString(map, "PRODUCT_SERIES"));
                        carLoanOpinionDTO.setRepaymentMethod(MapUtils.getString(map, "REPAYMENT_METHOD"));
                        break;
                }
                responseTitle.setOrderNumber(orderNumber);
                responseTitle.setStatus(status);
                carLoanOpinionDTO.setOrderNumber(orderNumber);
                carLoanOpinionDTO.setExamineRemarks(MapUtils.getString(map, "EXAMINE_REMARKS"));
                responseTitle.setCarLoanOpinionDTO(carLoanOpinionDTO);
                json = JSON.toJSONString(responseTitle);
                sysPushMqServicefeign.PushMqCarMessge(json);
                logger.info("========结束任务推送====PushMqCarUserMsg==");
            } catch (Exception e) {
                errmesage = GetExceptionInfo.getExceptionInfo(e);
                logger.info("PushMqCarUserMsg任务异常====="+errmesage);
            } finally {
                carLoanLogService.insertCarLoanLog(orderNumber, status, FormatUtil.formatJson(json), errmesage);
            }
            return true;
    }

}
