package com.car.modules.loan.biz.asynjob.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizAsynJobDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 处理类
     */
    private String beanClass;

    /**
     * 业务keyID
     */
    private String bizKeyId;

    /**
     * 状态 enum类 {@link com.carloan.apimodel.biz.enums.AsynJobEnum}
     */
    private Integer jobState;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 错误日志
     */
    private String errorRemark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 任务状态1:有效0:无效
     */
    private Integer validateState;

    /**
     * 运行次数
     */
    private Integer jobRun;

    private static final long serialVersionUID = 1L;
}