package com.carloan.apimodel.common;

public enum Status {
    SUCCESS("SUCCESS", "200"),//成功
    MISSING("NOTFOUND", "404"),//没找到接口
    TIMEOUT("TIMEOUT", "408"),//请求超时
    BAD_REQUEST("BAD_REQUEST","499"),//请求失败
    FAILED("FAILED", "500"), //服务器失败
    HYSTRIX_FAILED("HYSTRIX_FAILED", "501"),//走了断路器
    /**
     * 参数错误
     */
    ERR_406("参数错误", "406"),
    ERR_403("认证失效", "403"),
    ;

    ;
    String name;
    String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Status(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static String toValue(Status status) {
        return status.getValue();
    }

    public static Status fromValue(String v) {
        return valueOf(v);
    }
}