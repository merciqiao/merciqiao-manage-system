package com.car.modules.service;

import com.car.modules.exceptionpackage.OrderNumException;
import com.car.modules.exceptionpackage.ProductException;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanlog.service.CarLoanLogService;
import com.car.modules.loan.carloanmsg.service.CarLoanMsgService;
import com.car.modules.loan.carloanreconsideration.service.CarLoanReconsiderationService;
import com.car.modules.loan.carloanuser.service.CarLoanUserService;
import com.car.modules.reqvo.Variable;
import com.car.modules.util.FormatUtil;
import com.car.modules.util.GetExceptionInfo;
import com.car.modules.util.JsonTobean;
import com.carloan.apimodel.workflow.TransitionParam;
import net.sf.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: OnMessageService
 * @description:
 * @date 2018/6/25：11:34
 */
@Service
public class OnMessageService {

    private Logger logger = LoggerFactory.getLogger(OnMessageService.class);

    @Autowired
    private CarLoanInfoService carLoanInfoService;
    @Autowired
    private CarLoanMsgService carLoanMsgService;
    @Autowired
    private CarLoanUserService carLoanUserService;
    @Autowired
    private CarLoanLogService carLoanLogService;
    @Autowired
    private CarLoanReconsiderationService carLoanReconsiderationService;




    /**
     * 单独封装成方法，rest与MQ可共使用
     * @param mesage
     */
    public void onMessage(String mesage) {
        String errmesage = "",status = "",orderNumber= "";
        int count=0;
        try {
            FormatUtil.ifgetJson(mesage);
            status= JsonTobean.gerValue(mesage,"status");
            orderNumber= JsonTobean.gerValue(mesage,"orderNumber");
            TransitionParam transitionParam = new TransitionParam();transitionParam.setOrderNum(orderNumber);
            switch (status){
                case "300":
                    count= carLoanInfoService.count(MessageFormat.format(Variable.CAR_LOAN_INFO,  Variable.Assemble(orderNumber)));
                    if (count>0){
                        throw new OrderNumException(MessageFormat.format(Variable.V1,orderNumber));
                    }
                    carLoanMsgService.insertCarLoanMsg(JsonTobean.getReqPriceVo(mesage));
                    break;
                case "302":
                    carLoanMsgService.insertCarLoanFile(JsonTobean.getReqPriceVo(mesage).getCarLoanFileDTOList(),"定价补件",orderNumber);
                    break;
                case "400":
                    count= carLoanInfoService.count( MessageFormat.format(Variable.CAR_LOAN_INFO,Variable.Assemble(orderNumber)));
                    if (count==1){
                    carLoanUserService.insertCarLoanUser(JsonTobean.getReqUserInIfVo(mesage));
                    }else {
                        throw new OrderNumException(MessageFormat.format(Variable.V10,orderNumber));
                    }
                    break;
                case "402":
                    carLoanMsgService.insertCarLoanFile(JsonTobean.getReqPriceVo(mesage).getCarLoanFileDTOList(),"客户信息补件",orderNumber);
                    break;
                case "405":
                    carLoanReconsiderationService.insertCarLoanReconsideration(JsonTobean.getReqFuYiVo(mesage));
                    break;
            }

        }catch (ProductException e) {
            e.printStackTrace();
            errmesage = e.getMessage();
        }catch (OrderNumException e) {
            e.printStackTrace();
            errmesage = e.getMessage();
        }catch (JSONException e) {
            e.printStackTrace();
            errmesage = e.getMessage();
        }catch (Exception e){
            e.printStackTrace();
            errmesage= GetExceptionInfo.getExceptionInfo(e);
        }finally {
            try {
                carLoanLogService.insertCarLoanLog(orderNumber, status, FormatUtil.formatJson(mesage), errmesage);
            }catch (Exception e){
            }
        }


    }
}
