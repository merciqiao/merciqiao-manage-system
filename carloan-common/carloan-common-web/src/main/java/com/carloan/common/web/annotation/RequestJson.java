package com.carloan.common.web.annotation;

import java.lang.annotation.*;

/**
 * Created by zhangyl on 2018/6/28
 * 用来接收get请求传过来的json字符串，json字符串需要urlEncode
 * 配合
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestJson {
    /**
     * 用于绑定的请求参数名字
     */
    String value() default "";

    /**
     * 是否必须，默认是
     */
    boolean required() default true;
}
