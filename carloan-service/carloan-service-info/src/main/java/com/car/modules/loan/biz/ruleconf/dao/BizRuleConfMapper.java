package com.car.modules.loan.biz.ruleconf.dao;


import com.car.modules.loan.biz.ruleconf.dto.BizRuleConfDO;
import com.car.modules.workflow.dispatch.rule.entity.ConfVO;
import com.car.modules.workflow.dispatch.rule.entity.UserOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangyl on 2018/7/25
 */
public interface BizRuleConfMapper {
    BizRuleConfDO selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(@Param("ids") Object... var1);

    int insertSelective(BizRuleConfDO confDO);

    int updateByPrimaryKey(BizRuleConfDO confDO);

    int updateByPrimaryKeySelective(BizRuleConfDO confDO);

    /**
     * 根据ruleCode查找type类型
     *
     * @param ruleCode
     * @return
     */
    List<String> listTypeByArefId(@Param("ruleCode") String ruleCode);

    /**
     * 获取规则类型--机构对角色的用户代办数量
     *
     * @param confVO
     * @return
     */
    List<UserOrder> getUserOrderByOrgToRole(ConfVO confVO);
}