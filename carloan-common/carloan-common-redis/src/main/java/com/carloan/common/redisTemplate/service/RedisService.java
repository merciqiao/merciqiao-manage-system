package com.carloan.common.redisTemplate.service;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyl on 2018/7/25
 */
public interface RedisService {
    /**
     * 设置过期时间
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    boolean expire(String key, long timeout, TimeUnit timeUnit);

    /**
     * 获取过期时间
     *
     * @param key
     * @param timeUnit
     * @return
     */
    Long getExpire(String key, TimeUnit timeUnit);

    /**
     * hash 以json格式添加
     *
     * @param key
     * @param field
     * @param value
     */
    void hmSetWithJson(String key, String field, Object value,long timeout,TimeUnit timeUnit);

    /**
     * hash 获取
     *
     * @param key
     * @param field
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T hmGetWithJson(String key, String field, Class<T> clazz);

    /**
     * 获取集合类
     * @param key
     * @param field
     * @param collectionClass 集合类行
     * @param elementClasses 集合类泛型类型
     * @param <T>
     * @return
     */
    <T> T hmGetWithJson(String key, String field, Class<?> collectionClass, Class<?>... elementClasses);

    /**
     * 删除key
     * @param key
     * @return
     */
    void delete(String key);
}
