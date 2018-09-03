package com.carloan.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "shiro-redis")
public class ShiroRedis {
    public String host;
    public Integer port;
    public String password;
    public Integer timeout;
    /*session过期时间,毫秒*/
    public Integer sessionexpiretime;
    /*权限和角色过期时间,毫秒*/
    public Integer permissionxpiretime;
    public String mastername;
}
