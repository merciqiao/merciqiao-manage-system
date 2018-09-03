package com.carloan.feign.info;

import com.carloan.apimodel.common.ResponseResult;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: AliYunOssServiceFeign
 * @description:
 * @date 2018/7/27：14:10
 */
@FeignClient(value = "carloan-service-aliyunoss",path = "/AliYunOss-api")

public interface AliYunOssServiceFeign {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseResult uploadFile(@RequestPart(value = "importFile")  MultipartFile importFile);


    @Configuration
    public class MultipartSupportConfig {
        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        @Primary
        @Scope("prototype")
        public SpringFormEncoder feignEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }

    }
}
