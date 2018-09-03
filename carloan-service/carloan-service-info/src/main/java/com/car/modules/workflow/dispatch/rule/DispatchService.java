package com.car.modules.workflow.dispatch.rule;

import com.car.modules.loan.biz.ruleconf.service.BizRuleConfService;
import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.enums.ConfTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyl on 2018/7/25
 * 派单规则--获取处理人
 */
@Service
public class DispatchService {
    @Autowired
    private ConfFactory confFactory;
    @Autowired
    private BizRuleConfService confService;

    private IRuleConf handlerConf;

    /**
     * step1、获取规则类型
     * step2、动态获取实现类
     * step3、循环获取派单人，直到获取成功
     * @param confVO
     * @return
     */
    public String dispatch(ConfVO confVO) {
        String userId = "-1";
        List<String> types = confService.listTypeByArefId(confVO.getRuleCode());
        for (String type : types) {
            ConfTypeEnum typeEnum = ConfTypeEnum.acquire(type);
            handlerConf = confFactory.getHandlerConf(typeEnum);
            userId = handlerConf.getUserId(confVO);
            if (!"-1".equals(userId)) {
                return userId;
            }
        }
        return userId;
    }
}
