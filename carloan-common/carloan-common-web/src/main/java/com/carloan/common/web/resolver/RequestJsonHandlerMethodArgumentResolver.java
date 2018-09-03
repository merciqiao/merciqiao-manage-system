package com.carloan.common.web.resolver;

import com.carloan.common.web.annotation.RequestJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

/**
 * Created by zhangyl on 2018/6/28
 */
public class RequestJsonHandlerMethodArgumentResolver extends AbstractNamedValueMethodArgumentResolver implements WebArgumentResolver {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest nativeWebRequest) throws Exception {
        if (!supportsParameter(methodParameter)) {
            return WebArgumentResolver.UNRESOLVED;
        }
        return resolveArgument(methodParameter, null, nativeWebRequest, null);
    }

    @Override
    protected NamedValueInfo createNamedValueInfo(MethodParameter methodParameter) {
        RequestJson annotation = methodParameter.getParameterAnnotation(RequestJson.class);
        return new NamedValueInfo(annotation.value(), annotation.required(), null);
    }

    @Override
    protected Object resolveName(String name, MethodParameter methodParameter, NativeWebRequest nativeWebRequest) throws Exception {
        String[] paramValues = nativeWebRequest.getParameterValues(name);
        Class<?> paramType = methodParameter.getParameterType();
        if (paramValues == null) {
            return null;
        }
        return mapper.readValue(paramValues[0], paramType);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.hasParameterAnnotation(RequestJson.class)) {
            return true;
        }
        return false;
    }
}
