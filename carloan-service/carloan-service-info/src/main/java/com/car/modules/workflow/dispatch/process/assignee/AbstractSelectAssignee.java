package com.car.modules.workflow.dispatch.process.assignee;

import com.car.modules.workflow.dispatch.process.assignee.entity.ProcessAssigneeTO;
import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.jbpm4histtask.service.Jbpm4HistTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhangyl on 2018/7/31
 */
public abstract class AbstractSelectAssignee implements ISelectAssignee {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Jbpm4HistTaskService histTaskService;

    @Override
    public String getAssigneeByRule(ProcessAssigneeTO processAssigneeDTO) {
        String userId;
        String proInstanceId = null;
        try {
            proInstanceId= processAssigneeDTO.getProInstanceId();
            String activityName = processAssigneeDTO.getActivityName();
            String orgId = processAssigneeDTO.getOrgId();
            /**
             * 获取历史派单人
             */
            userId = histTaskService.getHisUserOfActiveByProInstId(proInstanceId, activityName);
            if ("-1".equals(userId)) {
                if (logger.isInfoEnabled()) {
                    logger.info("没有获取到历史派单人.proInstanceId:{};activityName:{};orgId:{}", proInstanceId, activityName, orgId);
                    //根据规则获取
                    ConfVO confVO= ConfVO.builder().arefId(orgId).bizType(processAssigneeDTO.getBizType()).build();
                    userId = this.getAssigneeByRuleInternal(confVO);
                }
            }
        } catch (RuntimeException ex) {
            userId = "-1";
            logger.error("获取派单人出现异常",ex);
        }
        if(logger.isInfoEnabled()){
            logger.info("==自动派单规则制定的定价专员ID:{},流程实例ID:{}==",userId,proInstanceId);
        }
        return userId;
    }

    /**
     * 子类实现
     * @param confVO
     * @return
     */
    protected abstract String getAssigneeByRuleInternal(ConfVO confVO);
}
