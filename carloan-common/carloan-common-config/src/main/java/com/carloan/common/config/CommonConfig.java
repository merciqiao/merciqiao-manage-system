package com.carloan.common.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MMM on 2018/06/15.
 */
@Configuration
public class CommonConfig {
    /**
     * 依赖注入mapper
     * @return
     */
    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }
}

