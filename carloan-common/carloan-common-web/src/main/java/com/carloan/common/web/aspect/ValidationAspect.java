package com.carloan.common.web.aspect;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyl on 2018/6/29
 */
@Component
@Aspect
public class ValidationAspect {
    @Around("execution(* com.carloan.*..*Controller.*(..))")
    public Object doValid(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取BindingResult
        BindingResult bindingResult = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                bindingResult = (BindingResult) arg;
            }
        }
        // 解析BindingResult
        if (bindingResult != null) {
            if (bindingResult.hasErrors()) {
                Map<String, String> map = new HashMap<String, String>();
                String key = "";
                String msg = null;
                for (ObjectError error : bindingResult.getAllErrors()) {
                    key = error.getObjectName();
                    if (error.getArguments().length > 0) {
                        key = ((DefaultMessageSourceResolvable) error.getArguments()[0]).getCodes()[1];
                    }
//                    map.put(key, error.getDefaultMessage());
                    if (msg == null){
                        msg = error.getDefaultMessage();
                    }
                }
                if (msg == null){
                    msg = "参数错误！";
                }
                ResponseResult<Map> result=new ResponseResult<Map>();
                result.setStatus(Status.ERR_406);
                result.setMessage(msg);
//                result.setData(map);
                return result;
            }
        }
        return joinPoint.proceed();
    }
}
