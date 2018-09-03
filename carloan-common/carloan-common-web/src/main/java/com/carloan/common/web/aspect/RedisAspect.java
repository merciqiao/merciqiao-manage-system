package com.carloan.common.web.aspect;

import com.carloan.common.redisTemplate.service.RedisUtils;
import com.carloan.common.utils.SpringUtil;
import com.carloan.common.web.annotation.RedisCache;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: RedisAspect
 * @description:
 *
 * 定义redis缓存AOP
 *
 * @date 2018/7/18：16:44
 */
@Component
@Aspect
public class RedisAspect {
    Logger logger = LoggerFactory.getLogger(RedisAspect.class);



    @Around("@annotation(redisCache)")
    public Object doValid(ProceedingJoinPoint joinPoint, RedisCache redisCache) throws Throwable {
        RedisUtils  redisUtils=(RedisUtils) SpringUtil.getObject("com.carloan.common.redisTemplate.service.RedisUtils");
        Object object=null;
        String key=this.getKey(redisCache.type(),joinPoint);
        try {
            if (!redisUtils.exists(key)) {
                object = joinPoint.proceed();
                redisUtils.set(key, object);
                logger.info("插入redis缓存OK---方法名称{},redis--key{}",joinPoint.getSignature().getName(),key);
            } else {
                object = redisUtils.get(key);
                logger.info("获取redis缓存OK---方法名称{},redis--key{}",joinPoint.getSignature().getName(),key);
            }
            }catch (Exception e){
                object = joinPoint.proceed();
            logger.info("执行异常-RedisAspect---方法名称{0},redis--key{}",joinPoint.getSignature().getName(),key);
            e.printStackTrace();
            }
        return object ;
    }


    public String getKey(String type,ProceedingJoinPoint point) throws NoSuchMethodException {
        StringBuffer sb = new StringBuffer();
        Object[] arguments = point.getArgs();
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();
        String className = point.getTarget().getClass().getName();
        sb.append(type).append(":").append(className).append(":").append(methodName);
        if (arguments != null && arguments.length != 0) {
            for (Object a : arguments) {
                sb.append(":").append(StringUtils.substringBefore(a.toString(),"@"));
            }
        }
        return sb.toString();
    }


}
