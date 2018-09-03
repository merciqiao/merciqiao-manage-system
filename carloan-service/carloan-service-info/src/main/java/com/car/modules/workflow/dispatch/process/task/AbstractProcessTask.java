package com.car.modules.workflow.dispatch.process.task;

import com.car.modules.workflow.dispatch.process.assignee.entity.ProcessAssigneeTO;
import com.car.modules.workflow.jbpm.service.JbpmService;
import com.car.modules.workflow.jbpm4task.service.Jbpm4TaskService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyl on 2018/7/31
 */
public abstract class AbstractProcessTask implements IProcessTaskService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Jbpm4TaskService taskService;

    @Autowired
    private JbpmService jbpmService;

    /**
     * 此方法不要使用 {@link Transactional }注解，
     * 否则出现Transaction rolled back because it has been marked as rollback-only异常
     *
     * @param bizType
     * @param activityName
     */
    @Override
    public void execute(String bizType, String activityName) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("bizType", bizType);
        params.put("activityName", activityName);
        PageHelper.startPage(1, 400, false);
        List<Map<String, Object>> list = taskService.listTaskOfNoAssignee(params);
        for (Map<String, Object> map : list) {
            try {
                String proInstanceId = map.get("PRO_INSTANCE_ID").toString();
                String orgId = (String) (map.get("ORG_ID"));
                //TODO
                orgId = StringUtils.isEmpty(orgId) ? "1" : orgId;
                long taskId = Long.parseLong(map.get("ID").toString());
                ProcessAssigneeTO processAssigneeDTO = ProcessAssigneeTO.builder()
                        .proInstanceId(proInstanceId)
                        .activityName(activityName)
                        .bizType(bizType)
                        .orgId(orgId)
                        .build();
                String toUserId = this.executeInternal(processAssigneeDTO);
                if ("-1".equals(toUserId)) {
                    continue;
                }

                //更新代办人
                jbpmService.updateAssignee(taskId, toUserId, "1", true);
            } catch (RuntimeException ex) {
                logger.error("更新代办人出现异常", ex);
            }
        }
    }

    /**
     *
     * 获取具体的派单人，子类重写
     * @param processAssigneeDTO
     * @return
     */
    public abstract String executeInternal(ProcessAssigneeTO processAssigneeDTO);
}
