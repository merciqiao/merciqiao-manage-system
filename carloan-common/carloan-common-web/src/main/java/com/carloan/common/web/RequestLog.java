package com.carloan.common.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * Created by MMM on 2018/03/01.
 * controller方法拦截器,记录接口方法调用和耗时
 */
@Slf4j
public class RequestLog extends HandlerInterceptorAdapter {
    /**
     * 前置检查
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String ip = request.getRemoteAddr();
        long startTime = System.currentTimeMillis();
        request.setAttribute("requeststarttime", startTime);
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取用户token
            Method method = handlerMethod.getMethod();
            String logStr= MessageFormat.format("user ip:{0},target:{1}"
                    ,ip,method.getDeclaringClass().getName() + "." + method.getName());
            log.info(logStr);
        }

        return true;
    }

    /**
     * controller处理完成
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            long startTime = (Long) request.getAttribute("requeststarttime");

            long endTime = System.currentTimeMillis();

            long executeTime = endTime - startTime;

            // log it
//        if (executeTime > 1000) {
//            log.info("[" + method.getDeclaringClass().getName() + "." + method.getName() + "] run time : "
//                    + executeTime + "ms");
//        } else {
//            log.info("[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] rum time : "
//                    + executeTime + "ms");
//        }
            log.info("[" + method.getDeclaringClass().getName() + "." + method.getName() + "] run time : "
                    + executeTime + "ms");
        }


    }

    /**
     * 获取rest接口参数
     * @param request
     * @return
     */
    private String getParam(HttpServletRequest request){
        String method = request.getMethod();
        String param = null;
        if (method.equalsIgnoreCase("GET")) {
            /**
             获取?后面的字符串
             http://127.0.0.1:8080/test?username=zhangsan&age=100
             -->username=zhangsan&age=100
             http://127.0.0.1:8080/test?{"username":"zhangsan"}
             -->{"username":"zhangsan"}是json字符串
             有了json串就可以映射成对象了
             */
            param = request.getQueryString();
            if (Base64.isBase64(param)) {
                param = new String(Base64.decodeBase64(param), StandardCharsets.UTF_8);
            }

        } else {
            param = getBodyData(request);
            if (Base64.isBase64(param)) {
                param = new String(Base64.decodeBase64(param), StandardCharsets.UTF_8);
            }
        }
        return param;
    }
    //获取请求体中的字符串(POST)
    private  String getBodyData(HttpServletRequest request) {
        StringBuffer data = new StringBuffer();
        String line = null;

//        try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            while (null != (line = br.readLine())) {
                data.append(line);
            }
        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return data.toString();
    }
}
