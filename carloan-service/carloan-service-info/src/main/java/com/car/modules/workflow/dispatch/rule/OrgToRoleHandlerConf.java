package com.car.modules.workflow.dispatch.rule;

import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.entity.UserOrder;
import com.car.modules.workflow.dispatch.rule.enums.ConfTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangyl on 2018/7/25
 * 规则类型机构对角色
 */
@Component
public class OrgToRoleHandlerConf extends AbstractRuleConf {

    @Override
    public ConfTypeEnum getType() {
        return ConfTypeEnum.ORGTOROLE;
    }

    @Override
    protected List<UserOrder> getUserOrder(ConfVO confVO) {
        return bizRuleConfService.getUserOrderByOrgToRole(confVO);
    }

    @Override
    protected int getMaxCount(Long userId, String productId) {
        return 100;
    }
}
