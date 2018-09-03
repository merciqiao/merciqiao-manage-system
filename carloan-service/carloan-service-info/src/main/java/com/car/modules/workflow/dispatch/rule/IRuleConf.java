package com.car.modules.workflow.dispatch.rule;


import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.enums.ConfTypeEnum;

/**
 * Created by zhangyl on 2018/7/25
 */
public interface IRuleConf {
    /**
     * 获取类型
     * @return
     */
    ConfTypeEnum getType();

    /**
     * 根据规则获取用户
     * @param confVO
     * @return
     */
    String getUserId(ConfVO confVO);
}
