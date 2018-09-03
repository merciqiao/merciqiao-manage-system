package com.carloan.apimodel.workflow.common;

/**
 * Created by MMM on 2018/06/02.
 * 车贷流程常量
 */
public class CarFlowConst {
    public static final String CONST_STARTFLOW_CAR_DINGJIA="com.car.modules.flow.carflow.measureprice.StartFlowCarMeasurePriceService";
    public static final String CONST_STARTFLOW_CAR_XINSHEN="com.car.modules.flow.carflow.creditaudit.StartFlowCarCreditAuditService";
    public static final String CONST_STARTFLOW_CAR_FUYI="com.car.modules.flow.carflow.reconsiderncase.StartFlowCarReconsidernCaseService";

    /*车贷流程类型*/
    /**
     * 车贷信审
     */
    public static final String CAR_TASKTYPE_XINSHEN = "3000";
    /**
     * 车贷定价
     */
    public static final String CAR_TASKTYPE_DINGJIA = "3001";
    /**
     * 车贷复议
     */
    public static final String CAR_TASKTYPE_FUYI = "3002";

    /**
     * 车贷流程节点
     */
    public static final String PRICE="定价";
    public static final String RECONSIDERATION = "复议";

    public static final String AUDIT = "审核";
    public static final String LAST_AUDIT = "复核";
    public static final String SUPPLEMENT_MATERAIL = "客服补充资料";
    public static final String ANTI_FRAUD="反欺诈";
}
