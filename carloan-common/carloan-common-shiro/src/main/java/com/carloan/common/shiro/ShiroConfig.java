package com.carloan.common.shiro;

import com.carloan.common.config.ShiroRedis;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSentinelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.mgt.SecurityManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.Filter;

/**
 * 过滤器
 */
@Configuration
public class ShiroConfig {
    @Autowired
    ShiroRedis shiroRedis;


    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/shiro-api/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //登陆不需要认证
        filterChainDefinitionMap.put("/shiro-api/login/**", "anon");

        //swagger start
        filterChainDefinitionMap.put("/swagger-ui.html"," anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        //swagger end
        //自定义授权 start 这里查询所有"地址-permission"配置,添加到filter做接口权限控制
//        filterChainDefinitionMap.put("/quartzjob-api/queryCarLoanInfoByPrimaryKey/**", "roles[BIZ_AUDIT]");
        //filterChainDefinitionMap.put("/quartzjob-api/queryCarLoanInfoByPrimaryKey/**", "perms[workfile/queryCreditIntoInfo:exportExcel]");
        //自定义授权 end


        //filterChainDefinitionMap.put("/**", "authc");//


        // 未登录
        shiroFilterFactoryBean.setLoginUrl("/shiro-api/unlogin");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/shiro-api/unauth");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        Map<String, Filter> filters=new LinkedHashMap<>();
        filters.put("authc",new SessionExpiredFilter());
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());//设置myrealm
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());//设置mysessionmanager
        // 自定义缓存实现 使用redis,权限缓存
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    //自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        mySessionManager.setSessionDAO(redisSessionDAO());
        mySessionManager.setGlobalSessionTimeout(shiroRedis.getSessionexpiretime());//session缓存时间,滑动缓存
        return mySessionManager;
    }
    /**
     * cacheManager 缓存 redis实现
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
//        redisCacheManager.setRedisManager(redisSentinelManager());
        redisCacheManager.setRedisManager(redisManager());
        redisCacheManager.setExpire(shiroRedis.getPermissionxpiretime()/1000);//权限缓存时间,非滑动缓存,要/1000
        return redisCacheManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * <p>
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//        redisSessionDAO.setRedisManager(redisSentinelManager());
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }
    /**
     * 配置shiro redisManager
     * <p>
     * 使用的是shiro-redis开源插件 单点时使用
     *
     * @return
     */
    //@Bean
    public RedisManager redisManager() {

        RedisManager redisManager = new RedisManager();
        redisManager.setHost(shiroRedis.getHost());
        redisManager.setPort(shiroRedis.getPort());
        redisManager.setExpire(shiroRedis.getSessionexpiretime());// 配置缓存过期时间
        if(!StringUtils.isEmpty(shiroRedis.getPassword())){
            redisManager.setPassword(shiroRedis.getPassword());
        }
        redisManager.setTimeout(shiroRedis.getTimeout());

        return redisManager;
    }
    /**
     * 配置shiro redisSentinelManager   哨兵模式
     * 使用的是shiro-redis开源插件
     * @return
     */
    //@Bean
    public RedisSentinelManager redisSentinelManager(){
        RedisSentinelManager redisSentinelManager = new RedisSentinelManager();
        redisSentinelManager.setMasterName(shiroRedis.getMastername());
        redisSentinelManager.setHost(shiroRedis.getHost());
        if(!StringUtils.isEmpty(shiroRedis.getPassword())){
            redisSentinelManager.setPassword(shiroRedis.getPassword());
        }
        redisSentinelManager.setTimeout(shiroRedis.getTimeout());
        redisSentinelManager.setExpire(shiroRedis.getSessionexpiretime());
        return redisSentinelManager;
    }
    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
