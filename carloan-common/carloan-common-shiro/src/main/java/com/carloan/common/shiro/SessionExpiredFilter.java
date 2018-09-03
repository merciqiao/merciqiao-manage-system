package com.carloan.common.shiro;

import com.alibaba.fastjson.JSONObject;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SessionExpiredFilter extends FormAuthenticationFilter  {


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            Response result=new Response();
            result.setStatus(Status.ERR_403);
            result.setMessage("未登录或认证过期");
            httpServletResponse.getWriter().write(JSONObject.toJSON(result).toString());

        return false;

    }

}

