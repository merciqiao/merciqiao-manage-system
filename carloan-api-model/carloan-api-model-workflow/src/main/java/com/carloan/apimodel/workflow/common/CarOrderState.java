package com.carloan.apimodel.workflow.common;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by MMM on 2018/06/01.
 * 车贷订单状态
 */
public enum CarOrderState {
//    2000 定价审核中-审核中
//2100 定价审核中-补件
//2200 定价审核结束-同意
//2700 定价审核结束-拒绝
//2300 审核中-审核中
//2400 审核中-补件
//3100 审核结束-同意
//3300 审核结束-拒绝
//3400 审核中-复议
//3500 审核结束-复议同意
//3500 审核结束-复议拒绝
//2500 审核中-疑似欺诈
//2600 审核结束-欺诈拒绝
//
    /* 定价-订单状态---start */
    DINGJIA_STATE_SHENHE("2000", "定价审核中-审核中"),
    DINGJIA_STATE_BUJIAN("2100", "定价审核中-补件"),
    DINGJIA_STATE_TONGYI("2200", "定价审核结束-同意"),
    DINGJIA_STATE_JUJUE("2700", "定价审核结束-拒绝"),
    /* 定价-订单状态---end */
    /* 信审-订单状态---start */
    XINSHEN_STATE_SHENHE("2300","审核中-审核中"),
    XINSHEN_STATE_BUJIAN("2400","审核中-补件"),
    XINSHEN_STATE_TONGYI("3100","审核结束-同意"),
    XINSHEN_STATE_JUJUE("3300","审核结束-拒绝"),

    XINSHEN_STATE_YISIQIZHA("2500","审核中-疑似欺诈"),
    XINSHEN_STATE_QIZHAJUJUE("2600","审核结束-欺诈拒绝"),
     /* 信审-订单状态---end */

     /* 复议-订单状态---start */
     FUYI_STATE_FUYI("3400","审核中-复议"),
     FUYI_STATE_YISIQIZHA("3500","审核结束-复议同意"),
     FUYI_STATE_QIZHAJUJUE("3600","审核结束-复议拒绝"),
     /* 复议-订单状态---end */
    ;




    private String key;
    private String value;
    private CarOrderState(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @author Administrator
     * @description: 根据key获取对应的value
     * @date 2015年1月12日 上午10:41:01
     * @return
     */
    public static String getValueByKey(String key) {
        String value = null;

        if(StringUtils.isEmpty(key)) {
            return value;
        }

        for(CarOrderState s:values()){
            if(s.getKey().equals(key)){
                value = s.getValue();
                break;
            }
        }

        return value;
    }
}
