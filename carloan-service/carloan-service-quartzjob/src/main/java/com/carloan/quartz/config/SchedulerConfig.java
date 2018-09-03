package com.carloan.quartz.config;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class SchedulerConfig {

    @Autowired
    private DataSource dataSource;
    @Bean()
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        factory.setQuartzProperties(quartzProperties());
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    public Scheduler scheduler() throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = schedulerFactoryBean();
        return schedulerFactoryBean.getScheduler();
    }

    /**
     * 定义 Quartz 属性配置 bean，名称为 quartzProperties
     *
     * @return
     * @throws IOException
     */
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new FileSystemResource(new File("config/quartz.properties")));
        propertiesFactoryBean.afterPropertiesSet();// 注意 : 这一句必须要调用，否则配置文件并不会被加载，下面的 getObject() 会返回 null
        Properties props = propertiesFactoryBean.getObject();
        return props;
    }
}
