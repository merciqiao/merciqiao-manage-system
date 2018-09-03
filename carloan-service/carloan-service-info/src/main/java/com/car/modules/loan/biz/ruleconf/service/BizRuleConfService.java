package com.car.modules.loan.biz.ruleconf.service;


import com.car.modules.loan.biz.ruleconf.dao.BizRuleConfMapper;
import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.entity.UserOrder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyl on 2018/7/25
 */
@Service
public class BizRuleConfService {
    public static final Logger logger = LoggerFactory.getLogger(BizRuleConfService.class);
    @Autowired
    private BizRuleConfMapper confMapper;

    public List<String> listTypeByArefId(String ruleCode) {
        return confMapper.listTypeByArefId(ruleCode);
    }

    /**
     * 获取规则类型--机构对角色的用户代办数量
     *
     * @param confVO
     * @return
     */
    public List<UserOrder> getUserOrderByOrgToRole(ConfVO confVO) {
        if (StringUtils.isEmpty(confVO.getRuleCode()) || StringUtils.isEmpty(confVO.getArefId()) || StringUtils.isEmpty(confVO.getBizType())) {
            logger.error("参数异常,ruleCode:{},arefId:{},bizType:{}", confVO.getRuleCode(), confVO.getArefId(), confVO.getBizType());
        }
        return confMapper.getUserOrderByOrgToRole(confVO);
    }
}
