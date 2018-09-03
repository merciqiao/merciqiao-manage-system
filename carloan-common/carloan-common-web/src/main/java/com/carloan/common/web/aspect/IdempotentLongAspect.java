package com.carloan.common.web.aspect;

import com.alibaba.fastjson.JSONObject;
import com.carloan.apimodel.common.Response;
import com.carloan.common.redisTemplate.service.RedisUtils;
import com.carloan.common.utils.SpringUtil;
import com.carloan.common.web.annotation.IdempotentLong;
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
public class IdempotentLongAspect {
    @Around("@annotation(idempotentLong)")
    public Long idempotentBoolean(ProceedingJoinPoint joinPoint, IdempotentLong idempotentLong) throws Throwable{
        Long result=null;
        try{
            RedisUtils  redisUtils=(RedisUtils) SpringUtil.getObject("com.carloan.common.redisTemplate.service.RedisUtils");
            Object[] arguments = joinPoint.getArgs();
            JSONObject json= (JSONObject) JSONObject.toJSON(arguments[0]);
            String uuid=json.getString("uuid");
            if(uuid==null){
                throw new Exception("idempotentResponse uuid isnot exist");
            }
            Object objRedis= redisUtils.get("IdempotentKey-"+uuid);
            if(objRedis==null){
                result = (Long) joinPoint.proceed();
                if(result!=null&&result>0){
                    //成功,则将成功结果写入redis
                    redisUtils.set("IdempotentKey-"+uuid,result,30L, TimeUnit.MINUTES);
                }
                return result;
            }
            else{
                return (Long)objRedis;
            }

        }
        catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw ex;
        }
    }
}
