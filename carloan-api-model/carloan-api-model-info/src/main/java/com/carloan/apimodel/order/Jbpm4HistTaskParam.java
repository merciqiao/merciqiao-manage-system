package com.carloan.apimodel.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *@Description:jbpm4_hist_task
 *@author root
 *@version 1.0,
 *@date 2018-07-05 13:25:18
 */
@Getter
@Setter
public class Jbpm4HistTaskParam implements Serializable{

	private static final long serialVersionUID = 1L;

	/**流程轨迹ID*/
	@ApiModelProperty(value="流程轨迹ID")
	private Long id;

	/**流程实例ID*/
	@ApiModelProperty(value="流程实例ID")
	private String proInstanceId;

	/**节点名称*/
	@ApiModelProperty(value="节点名称")
	private String activityName;

	/**节点类型*/
	@ApiModelProperty(value="节点类型")
	private String activityType;

	/**流转名称*/
	@ApiModelProperty(value="流转名称")
	private String transition;

	/**开始时间*/
	@ApiModelProperty(value="开始时间")
	private java.util.Date createTime;

	/**结束时间*/
	@ApiModelProperty(value="结束时间")
	private java.util.Date endTime;

	/**处理人*/
	@ApiModelProperty(value="处理人")
	private String assignee;

}