package com.carloan.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public abstract class AbstractTaskJob {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    public static final String KEY="DISPATCH";
    protected <T> T getBean(JobExecutionContext jobExecutionContext, Class<T> tClass) {
        return getContext(jobExecutionContext).getBean(tClass);
    }

    private ApplicationContext getContext(JobExecutionContext jobExecutionContext) {
        ApplicationContext context = null;
        try {
            context = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContextKey");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return context;
    }
}
