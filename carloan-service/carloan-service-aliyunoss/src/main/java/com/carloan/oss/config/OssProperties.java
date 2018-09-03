package com.carloan.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: OssProperties
 * @description:
 * @date 2018/7/25：9:00
 */
@Component
@Data
@ConfigurationProperties(prefix = OssProperties.MQCONFIG_PREFIX)
public class OssProperties {
    public static final String MQCONFIG_PREFIX = "OSS";
    private  String endpoint;
    private  String accessKeyId;
    private  String accessKeySecret;
    private  String bucketName;
    private  String downloadFile;//本地路径
    private  int taskNum; //最大下载数
    private  long partSize;//分片大小
    private  boolean enableCheckpoint;//开启断点续传
    private  String viedFile;
    private  String expiration;
}
