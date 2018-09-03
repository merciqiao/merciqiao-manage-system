package com.car.modules.workflow.dispatch.process.task;

/**
 * Created by zhangyl on 2018/7/31
 */
public interface IProcessTaskService {
    /**
     * bizType+activityName确认类型
     * 如:3000:定价
     * @return
     */
    String getType();
    void execute(String bizType,String activityName);

}
