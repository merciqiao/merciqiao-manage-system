package com.carloan.quartz.job;

import com.carloan.apimodel.biz.enums.AsynJobEnum;
import com.carloan.feign.info.CarBizAsynJobTaskFeign;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by zhangyl on 2018/8/8
 * 异步定时任务
 */
@DisallowConcurrentExecution
@Component("com.carloan.quartz.job.ExecuteAsynTaskJob")
public class ExecuteAsynTaskJob extends AbstractTaskJob implements Job, Serializable {

    private static final long serialVersionUID = 1524997975950536760L;

    private CarBizAsynJobTaskFeign bizAsynJobTaskFeign;

    @Override
    public void execute(JobExecutionContext context) {
        bizAsynJobTaskFeign=super.getBean(context,CarBizAsynJobTaskFeign.class);
        bizAsynJobTaskFeign.executeAsynJob(AsynJobEnum.ASYN.getStatus());
    }
}
