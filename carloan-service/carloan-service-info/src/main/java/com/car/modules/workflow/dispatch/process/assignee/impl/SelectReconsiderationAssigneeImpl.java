package com.car.modules.workflow.dispatch.process.assignee.impl;

import com.car.modules.workflow.dispatch.process.assignee.AbstractSelectAssignee;
import com.car.modules.workflow.dispatch.rule.DispatchService;
import com.carloan.apimodel.biz.RuleCodeConstant;
import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyl on 2018/7/31
 * 复议节点  获取派单人
 * 指定名称是因为这个类需要在页面中配置，后面通过反射调用
 */
@Service(value = "com.car.modules.workflow.dispatch.process.assignee.impl.SelectReconsiderationAssigneeImpl")
public class SelectReconsiderationAssigneeImpl extends AbstractSelectAssignee {
    @Autowired
    private DispatchService dispatchService;

    @Override
    protected String getAssigneeByRuleInternal(ConfVO confVO) {
        String userId;
        confVO.setRuleCode(RuleCodeConstant.RECONSIDERATION_RULE);
        userId = dispatchService.dispatch(confVO);
        return userId;
    }
}
