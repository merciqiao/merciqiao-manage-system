package com.carloan.apimodel.order;

/**
 * Created by Administrator on 2018/7/13.
 */
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuditTabs {
    //流程轨迹
    public static final String logInfoObj="logInfoObj";
    //历史匹配
    public static final String matchInfoObj="matchInfoObj";
    //车辆信息
    public static final String carInfoObj="carInfoObj";
    //客户订单信息
    public static final String customerInfoObj="customerInfoObj";
    //电核网核
    public static final String  surveyInfoObj="surveyInfoObj";
    //审核意见
    public static final String  auditInfoObj="auditInfoObj";
    //定价结论
    public static final String  auditCarPriceObj="auditCarPriceObj";
    //反欺诈项
    public static final String  antiFraudObj="antiFraudObj";
    //客户复议
    public static final String  custorReconsiderObj="custorReconsiderObj";
}
