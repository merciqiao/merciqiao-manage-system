package com.carloan.common.web.adive;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.common.web.exception.JbpmException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangyl on 2018/6/29
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = JbpmException.class)
    public Response jbpmExeception(JbpmException ex){
        Response result=new Response();
        result.setStatus(Status.FAILED);
        if(StringUtils.isNotEmpty(ex.getMsg())){
            result.setMessage(ex.getMsg());
        }
        logger.error("jbpm流程异常",ex.getErrorCode()+":"+ex.getMsg(),ex);
        return result;
    }
    @ExceptionHandler(value = RuntimeException.class)
    public Response defaultErrorHandler(RuntimeException ex)  {
        return defaultErrorHandler(null,ex);
    }
    @ExceptionHandler(value = Exception.class)
    public Response defaultErrorHandler(HttpServletRequest req, Exception ex)  {
        Response result=new Response();
        result.setMessage(ex.getMessage());
        if (ex instanceof UnauthenticatedException) {
            result.setMessage("token错误");
        } else if (ex instanceof UnauthorizedException) {
            result.setMessage("用户无权限");
        } else {
            result.setMessage(ex.getMessage());
        }
        result.setStatus(Status.FAILED);
        logger.error(ex.getMessage(),ex);
        return result;
    }
}
