package com.car.modules.workflow.dispatch.rule;

import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.entity.UserOrder;
import com.car.modules.workflow.dispatch.rule.enums.ConfTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangyl on 2018/7/25
 * 规则类型人对人
 */
@Component
public class PeopleToPeopleHandlerConf extends AbstractRuleConf{

    @Override
    public ConfTypeEnum getType() {
        return ConfTypeEnum.PTOP;
    }

    @Override
    protected int getMaxCount(Long userId, String productId) {
        return 0;
    }

    @Override
    protected List<UserOrder> getUserOrder(ConfVO confVO) {
        return null;
    }
}
