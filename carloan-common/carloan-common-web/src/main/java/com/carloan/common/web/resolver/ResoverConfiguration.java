package com.carloan.common.web.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by zhangyl on 2018/6/28
 */
@Configuration
public class ResoverConfiguration extends WebMvcConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(ResoverConfiguration.class);

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        logger.info("***********loading Request Json resolver************");
        argumentResolvers.add(resolver());
        super.addArgumentResolvers(argumentResolvers);
    }
    @Bean
    public RequestJsonHandlerMethodArgumentResolver resolver() {
        return new RequestJsonHandlerMethodArgumentResolver();
    }
}
