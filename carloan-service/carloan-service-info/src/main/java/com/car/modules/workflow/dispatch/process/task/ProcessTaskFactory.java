package com.car.modules.workflow.dispatch.process.task;

import com.carloan.common.web.exception.JbpmException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyl on 2018/7/31
 */
@Component
public class ProcessTaskFactory implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(ProcessTaskFactory.class);
    private static Map<String, IProcessTaskService> beanMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IProcessTaskService> map = applicationContext.getBeansOfType(IProcessTaskService.class);
        beanMap = new HashMap<>(map.size());
        map.forEach((key, value) -> beanMap.put(value.getType(), value));
    }

    public IProcessTaskService getProcessTask(String bizType, String activityName) {
        if (StringUtils.isEmpty(bizType) || StringUtils.isEmpty(activityName)) {
            logger.error("根据type获取IProcessTaskService失败,参数异常.bizType:{};activityName:{}", bizType, activityName);
            throw new JbpmException("根据type获取IProcessTaskService失败,参数异常");
        }
        StringBuffer buf = new StringBuffer();
        buf.append(bizType).append(":").append(activityName);
        return beanMap.get(buf.toString());
    }
}
