package com.carloan.common.web.annotation;

import java.lang.annotation.*;

/**
 * 自定义redis缓存注解、只要在service上添加该注解。数据第一次访问都会加载到redis里
 *
 *
 *
 * @author 周志伟
 *
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {
    /**
     *  SYS  系统级别
     *  INFO 业务级别
     * @return
     */
    String type() default "SYS";
}
