package com.car.modules.workflow.jbpm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 当前文件为MybatisGenerator自动生成，重新生成时会被覆盖，请勿修改！（表结构变化时请重新生成）
 * table:jbpm4_consigned_task
 */
@Getter
@Setter
public class Jbpm4ConsignedTask implements Serializable {
    private Long id;

    /**
     * TASKID
     */
    private Long taskId;

    /**
     * 派单FROM
     */
    private String fromUserId;

    private String toUserId;

    /**
     * 操作人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}