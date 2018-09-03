package com.car.modules.workflow.dispatch.rule;

import com.car.modules.workflow.dispatch.rule.enums.ConfTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyl on 2018/7/25
 */
@Component
public class ConfFactory implements ApplicationContextAware {

    private static Map<ConfTypeEnum, IRuleConf> beanMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IRuleConf> map = applicationContext.getBeansOfType(IRuleConf.class);
        beanMap = new HashMap<>(map.size());
        map.forEach((key, value) -> beanMap.put(value.getType(), value));
    }

    public IRuleConf getHandlerConf(ConfTypeEnum typeEnum) {
        return beanMap.get(typeEnum);
    }
}
