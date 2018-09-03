package com.car.modules.workflow.jbpm.service;

import com.car.modules.workflow.jbpm.dao.Jbpm4ConsignedTaskMapper;
import com.car.modules.workflow.jbpm.entity.Jbpm4ConsignedTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by zhangyl on 2018/7/30
 */
@Service
public class Jbpm4ConsignedTaskService {
    @Autowired
    private Jbpm4ConsignedTaskMapper consignedTaskMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(long taskId, String fromUserId, String toUserId, String createBy) {
        Jbpm4ConsignedTask consignedTask = new Jbpm4ConsignedTask();
        consignedTask.setTaskId(taskId);
        consignedTask.setFromUserId(fromUserId);
        consignedTask.setToUserId(toUserId);
        consignedTask.setCreateBy(createBy);
        consignedTask.setCreateTime(new Date());
        return consignedTaskMapper.insertSelective(consignedTask);
    }
}
