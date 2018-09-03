package com.car.modules.loan.biz.ruleconf.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 当前文件为MybatisGenerator自动生成，重新生成时会被覆盖，请勿修改！（表结构变化时请重新生成）
 * table:biz_rule_conf
 */
@Getter
@Setter
public class BizRuleConfDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 规则CODE
     */
    private String ruleCode;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 级别，越小级别越高
     */
    private Integer ruleLevel;

    /**
     * 是否详情1:是;1:否
     */
    private String ruleIsDetail;

    /**
     * 上级ID
     */
    private Long pId;

    /**
     * 类别1:人对人;2:机构对角色;3:机构对人;4:机构对机构;5:节点对角色
     */
    private String ruleType;

    /**
     * 主关联ID(目前是机构ID)
     */
    private String arefId;

    /**
     * 主关联描述
     */
    private String arefDesc;

    /**
     * 被关联ID(目前是用户ID或角色CODE)
     */
    private String brefId;

    private String brefDesc;

    /**
     * 状态0:无效;1:有效
     */
    private String validateState;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}