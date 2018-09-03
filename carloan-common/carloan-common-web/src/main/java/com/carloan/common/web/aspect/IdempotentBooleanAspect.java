package com.carloan.common.web.aspect;

import com.alibaba.fastjson.JSONObject;
import com.carloan.common.redisTemplate.service.RedisUtils;
import com.carloan.common.utils.SpringUtil;
import com.carloan.common.web.annotation.IdempotentBoolean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * AOP 实现幂等
 */
@Component
@Aspect
@Slf4j
public class IdempotentBooleanAspect {
    @Around("@annotation(idempotentBoolean)")
    public Boolean idempotentBoolean(ProceedingJoinPoint joinPoint, IdempotentBoolean idempotentBoolean) throws Throwable{
        Boolean result=null;
        try{
            RedisUtils  redisUtils=(RedisUtils) SpringUtil.getObject("com.carloan.common.redisTemplate.service.RedisUtils");
            Object[] arguments = joinPoint.getArgs();
            JSONObject json= (JSONObject) JSONObject.toJSON(arguments[0]);
            String uuid=json.getString("uuid");
            if(uuid==null){
                throw new Exception("idempotentResponseResult uuid isnot exist");
            }
            Object objRedis= redisUtils.get("IdempotentKey-"+uuid);
            if(objRedis==null){
                result = (Boolean) joinPoint.proceed();
                if(result){
                    redisUtils.set("IdempotentKey-"+uuid,result,30L, TimeUnit.MINUTES);
                }
                return result;
            }
            else{
                return true;
            }
        }
        catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw ex;
        }
    }
}
