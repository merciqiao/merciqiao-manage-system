package com.carloan.quartz.dao;

import com.carloan.apimodel.quartzjob.JobInfoVO;
import com.carloan.apimodel.quartzjob.TriggerExtVO;
import com.carloan.apimodel.quartzjob.TriggerInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangyl on 2018/6/28
 */
public interface QuartzMapper {
    /**
     * 获取所有定时信息
     * @param triggerExtVO
     * @return
     */
    List<TriggerInfoVO> listTriggerInfoByPage(TriggerExtVO triggerExtVO);

    /**
     * 根据jobName查找
     * @param jobName
     * @return
     */
    JobInfoVO selectJobInfoByJobName(@Param("jobName") String jobName);
}
