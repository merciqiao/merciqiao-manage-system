//package com.carloan.service.workflow.measureprice.eventlistener;
//
//import com.car.modules.flow.carflow.creditaudit.eventlistener.CarCreditAuditUpdateStateService;
//import com.loan.modules.befloan.common.JYBefloanConstants;
//import com.loan.modules.befloan.jbpm.eventlistener.ModifyBizTaskTypeEL;
//import org.jbpm.api.listener.EventListener;
//import org.jbpm.api.listener.EventListenerExecution;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.gateway.context.ContextLoader;
//import org.springframework.gateway.context.WebApplicationContext;
//import org.springframework.gateway.context.support.WebApplicationContextUtils;
//
//import javax.servlet.ServletContext;
//import java.text.MessageFormat;
//
///**
// * Created by MMM on 2018/06/07.
// * 补件时更新biztasktype,用于补件的单子优先显示
// */
//@Component("com.car.modules.flow.carflow.measureprice.eventlistener.CarMeasurePriceUpdateBizTaskType")
//public class CarMeasurePriceUpdateBizTaskType implements EventListener {
//    private static final Logger logger =  LoggerFactory.getLogger(ModifyBizTaskTypeEL.class);
//    @Override
//    public void notify(EventListenerExecution execution) throws Exception {
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        ServletContext servletContext = webApplicationContext.getServletContext();
//        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//        CarCreditAuditUpdateStateService service =(CarCreditAuditUpdateStateService) context.
//                getBean("com.car.modules.flow.carflow.creditaudit.eventlistener.CarCreditAuditUpdateStateService");
//
//        //进件主键ID
//        String orderNum=(String) execution.getVariable(JYBefloanConstants.BIZ_ORDER_NUM);
//        String orderType=(String) execution.getVariable(JYBefloanConstants.BIZ_ORDER_TYPE);
//        service.updateBizTaskType(orderNum,orderType);
//        logger.info(MessageFormat.format("CarMeasurePriceUpdateBizTaskType sucess,orderNum:{0}",orderNum));
//
//    }
//}
