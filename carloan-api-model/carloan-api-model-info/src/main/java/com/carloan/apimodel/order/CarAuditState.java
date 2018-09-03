package com.carloan.apimodel.order;

import org.apache.commons.lang3.StringUtils;

public enum CarAuditState {
    //信审阶段状态
    CAR_AUDIT_2000("2000", "定价审核中-审核中"),
    CAR_AUDIT_2100("2100", "定价审核中-补件"),
    CAR_AUDIT_2200("2200", "定价审核结束-同意"),
    CAR_AUDIT_2700("2700", "定价审核结束-拒绝"),

    CAR_AUDIT_2300("2300", "审核中-审核中"),
    CAR_AUDIT_2400("2400", "审核中-补件"),
    CAR_AUDIT_3100("3100", "审核结束-同意"),
    CAR_AUDIT_3300("3300", "审核结束-拒绝"),
    CAR_AUDIT_3400("3400", "审核中-复议"),
    CAR_AUDIT_3500("3500", "审核结束-复议同意"),
    CAR_AUDIT_3600("3600", "审核结束-复议拒绝"),

    CAR_AUDIT_2500("2500", "审核中-疑似欺诈"),
    CAR_AUDIT_2600("2600", "审核结束-欺诈拒绝"),

    //与进件系统交互状态
    CAR_INTO_301("301", "信审推送定价门店补件"),
    CAR_INTO_302("302", "门店定价补件申请"),
    CAR_INTO_304("304", "信审推送门店定价审核同意"),
    CAR_INTO_305("305", "信审推送门店定价审核拒绝"),
    CAR_INTO_401("401", "客户信息补件"),
    CAR_INTO_403("403", "客户信息审核同意"),
    CAR_INTO_404("404", "客户信息审核拒绝"),
    CAR_INTO_406("406", "客户信息复议审核同意"),
    CAR_INTO_407("407", "客户信息复议审核拒绝"),
    CAR_INTO_408("408", "欺诈审核拒绝");


    private String key;
    private String value;

    private CarAuditState(String key, String value) {
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

        for(CarAuditState s:values()){
            if(s.getKey().equals(key)){
                value = s.getValue();
                break;
            }
        }

        return value;
    }
    public static String getIntoStateByAuditState(String auditstate)
    {
        String intostate="";
        if(CarAuditState.CAR_AUDIT_2100.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_301.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_2200.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_304.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_2700.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_305.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_2400.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_401.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_3100.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_403.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_3300.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_404.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_2600.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_408.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_3500.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_406.getKey();
        }
        else if(CarAuditState.CAR_AUDIT_3600.getKey().equals(auditstate))
        {
            intostate=CarAuditState.CAR_INTO_407.getKey();
        }
        return intostate;
    }
}
