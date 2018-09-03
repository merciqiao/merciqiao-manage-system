package com.carloan.common.web.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解,实现操作数据幂等性,操作过返回Long
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IdempotentLong {

}
