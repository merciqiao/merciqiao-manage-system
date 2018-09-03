package com.carloan.apimodel.order;

import org.apache.commons.lang3.StringUtils;

//审批类型
public enum AuditType {

    XinShenQing("1", "新申请"),
    FuYi("2", "复议");

    private String key;
    private String value;

    private AuditType(String key, String value) {
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

    public static String getValueByKey(String key) {
        String value = null;
        if (StringUtils.isEmpty(key)) {
            return value;
        }
        for (AuditType s : values()) {
            if (s.getKey().equals(key)) {
                value = s.getValue();
                break;
            }
        }
        return value;
    }
}
