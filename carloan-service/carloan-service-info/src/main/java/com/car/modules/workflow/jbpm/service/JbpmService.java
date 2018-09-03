package com.car.modules.workflow.jbpm.service;

import com.car.modules.workflow.dispatch.process.task.IProcessTaskService;
import com.car.modules.workflow.dispatch.process.task.ProcessTaskFactory;
import com.car.modules.workflow.jbpm4histtask.service.Jbpm4HistTaskService;
import com.car.modules.workflow.jbpm4task.dto.Jbpm4TaskDTO;
import com.car.modules.workflow.jbpm4task.service.Jbpm4TaskService;
import com.carloan.apimodel.jbpm.ConsignTaskVO;
import com.carloan.common.web.exception.JbpmException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangyl on 2018/7/30
 */
@Service
public class JbpmService {

    public static final Logger logger = LoggerFactory.getLogger(JbpmService.class);

    private IProcessTaskService processTaskService;
    @Autowired
    private ProcessTaskFactory processTaskFactory;
    @Autowired
    private Jbpm4TaskService taskService;
    @Autowired
    private Jbpm4HistTaskService histTaskService;
    @Autowired
    private Jbpm4ConsignedTaskService consignedTaskService;

    public void updateAssignee(ConsignTaskVO consignedTaskVO) {
        updateAssignee(consignedTaskVO.getTaskId(), consignedTaskVO.getToUserId(), consignedTaskVO.getCreateBy(), false);
    }

    /**
     * 更新处理人
     *
     * @param taskId
     * @param toUserId
     * @param createBy
     * @param dispatch 是否派单,true:派单池派单；false:页面调单
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateAssignee(long taskId, String toUserId, String createBy, boolean dispatch) {
        if (taskId <= 0 || StringUtils.isEmpty(toUserId) || StringUtils.isEmpty(createBy)) {
            logger.error("参数异常taskId:{};fromUserId:{};toUserId:{};createBy:{}", new IllegalArgumentException());
            throw new IllegalArgumentException("参数异常");
        }
        Jbpm4TaskDTO taskDTO = taskService.queryJbpm4TaskByPrimaryKey(String.valueOf(taskId));
        String fromUserId = taskDTO.getAssignee();
        /**
         * 更新JBPM4_TASK
         */
        int result = taskService.updateAssigneeByPrimaryKey(taskId, toUserId, dispatch);
        if (result != 1) {
            throw new JbpmException("更新jbpm4Task中assignee失败");
        }
        /**
         * 更新JBPM4_HIST_TASK
         */

        result = histTaskService.updateAssigneeByPrimaryKey(taskId, toUserId);
        if (result != 1) {
            throw new JbpmException("更新jbpm4HistTask中assignee失败");
        }
        /**
         * 插入派单记录
         */
        result = consignedTaskService.insertSelective(taskId, fromUserId, toUserId, createBy);
        if (result != 1) {
            logger.error("插入派单记录失败,taskId:{};fromUserId:{};toUserId:{};createBy:{}", taskId, fromUserId, toUserId, createBy);
            throw new JbpmException("插入派单记录失败");
        }
        return result;
    }

    /**
     * 定时派单
     *
     * @param bizType
     * @param activityName
     */
    public void dispatchJob(String bizType, String activityName) {
        processTaskService=processTaskFactory.getProcessTask(bizType,activityName);
        if(processTaskService==null){
            logger.error("获取定时派单类出错.bizType:{};activityName:{}",bizType,activityName);
            return;
        }
        processTaskService.execute(bizType,activityName);
    }
}
