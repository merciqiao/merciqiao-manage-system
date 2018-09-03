package com.carloan.quartz.service;

import com.carloan.apimodel.quartzjob.JobInfoVO;
import com.carloan.apimodel.quartzjob.QuartzVO;
import com.carloan.apimodel.quartzjob.TriggerExtVO;
import com.carloan.apimodel.quartzjob.TriggerInfoVO;
import com.carloan.quartz.dao.QuartzMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyl on 2018/6/28
 */
@Service
public class SchedulerService {
    private final Logger logger = LoggerFactory.getLogger(SchedulerService.class);
    public static final String JOB_GROUP_NAME = "DEFAULT";
    public static final String TRIGGER_GROUP_NAME = "DEFAULT";
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private QuartzMapper quartzMapper;

    private Class<? extends Job> getCLass(String jobClass) {
        Class<? extends Job> clazz;
        try {
            clazz = Class.forName(jobClass).asSubclass(Job.class).newInstance().getClass();
        } catch (Exception e) {
            this.logger.error("初始化类异常", e);
            throw new RuntimeException("初始化类异常", e);
        }
        return clazz;

    }
    private CronTrigger getTrigger(String jobName){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        CronTrigger trigger;
        try {
            trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            logger.error("获取任务异常", e);
            throw new RuntimeException("获取任务异常", e);
        }
        return trigger;
    }
    public void addJob(QuartzVO vo) {
        String jobName=vo.getJobName();
        CronTrigger trigger=getTrigger(jobName);
        if(trigger==null){
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(getCLass(vo.getJobClass()))
                    .withIdentity(jobName, JOB_GROUP_NAME).build();
            // 触发器
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobName, TRIGGER_GROUP_NAME)
                    //立即执行
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(vo.getCron()))
                    .build();
            try {
                // 加入这个调度
                scheduler.scheduleJob(jobDetail, trigger);
                //启动之
                scheduler.start();
            } catch (SchedulerException e) {
                logger.error("添加定时任务出现异常", e);
                throw new RuntimeException("添加定时任务出现异常",e);
            }
        }
    }

    /**
     * 移除任务
     *
     * @param jobName
     */
    public void deleteJob(String jobName) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        try {
            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
            // 移除触发器
            scheduler.unscheduleJob(triggerKey);
            // 删除任务
            scheduler.deleteJob(JobKey.jobKey(jobName, JOB_GROUP_NAME));
        } catch (SchedulerException e) {
            logger.error("删除任务异常", e);
            throw new RuntimeException("删除定时任务出现异常", e);
        }
    }

    /**
     *
     * @param triggerName
     * @param cron
     */
    public void updateJob(String triggerName, String cron) {
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, TRIGGER_GROUP_NAME);
        CronTrigger trigger;
        try {
            trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            logger.error("获取不到任务", e);
            throw new RuntimeException("获取不到任务", e);
        }
        if (trigger != null) {
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerName, TRIGGER_GROUP_NAME)
                        //立即执行
                        .startNow()
                        .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                        .build();
                try {
                    scheduler.rescheduleJob(triggerKey, trigger);
                } catch (SchedulerException e) {
                    logger.error("修改任务cron异常",e);
                }

            }
        }
    }

    /**
     * 暂停任务
     * @param jobName
     */
    public void pauseTrigger(String jobName){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        try {
            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
        } catch (SchedulerException e) {
            logger.error("停止任务异常", e);
            throw new RuntimeException("停止任务异常", e);
        }
    }
    /**
     * 恢复任务
     * @param jobName
     */
    public void resumeTrigger(String jobName){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        try {
            // 恢复触发器
            scheduler.resumeTrigger(triggerKey);
        } catch (SchedulerException e) {
            logger.error("停止任务异常", e);
            throw new RuntimeException("停止任务异常", e);
        }
    }

    /**
     * 获取所有定时信息
     *
     * @param triggerExtVO
     * @return
     */
    public PageInfo<TriggerInfoVO> listTriggerInfo(TriggerExtVO triggerExtVO) {
        PageHelper.startPage(triggerExtVO.getCurrentPage(), triggerExtVO.getPageSize());
        List<TriggerInfoVO> list = quartzMapper.listTriggerInfoByPage(triggerExtVO);
        PageInfo<TriggerInfoVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 根据jobName查找
     *
     * @param jobName
     * @return
     */
    public JobInfoVO selectJobInfoByJobName(String jobName) {
        return quartzMapper.selectJobInfoByJobName(jobName);
    }
}
