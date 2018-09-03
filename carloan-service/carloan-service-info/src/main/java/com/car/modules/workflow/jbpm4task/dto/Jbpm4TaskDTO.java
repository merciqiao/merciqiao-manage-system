package com.car.modules.workflow.jbpm4task.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 *@Description:jbpm4_task
 *@author root
 *@version 1.0,
 *@date 2018-07-05 11:35:23
 */
@Getter
@Setter
public class Jbpm4TaskDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**任务表ID*/
	@ApiModelProperty(value="任务表ID")
	private Long id;

	/**流程实例ID*/
	@ApiModelProperty(value="流程实例ID")
	private String proInstanceId;

	/**流程节点名称*/
	@ApiModelProperty(value="流程节点名称")
	private String activityName;

	/**处理人*/
	@ApiModelProperty(value="处理人")
	private String assignee;

	/**创建时间*/
	@ApiModelProperty(value="创建时间")
	private java.util.Date createTime;

}