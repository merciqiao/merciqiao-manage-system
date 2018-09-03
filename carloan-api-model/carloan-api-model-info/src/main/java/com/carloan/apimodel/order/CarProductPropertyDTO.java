package com.carloan.apimodel.order;

public class CarProductPropertyDTO {
    private static final long serialVersionUID = 1L;

    /**主键ID*/
    private java.lang.Long id;

    /**进件产品实例ID*/
    private java.lang.Long fkIntoProductId;

    /**编码*/
    private java.lang.String code;

    /**最小值*/
    private java.lang.String minValue;

    /**最大值*/
    private java.lang.String maxValue;

    /**默认值*/
    private java.lang.String defaultValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkIntoProductId() {
        return fkIntoProductId;
    }

    public void setFkIntoProductId(Long fkIntoProductId) {
        this.fkIntoProductId = fkIntoProductId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
