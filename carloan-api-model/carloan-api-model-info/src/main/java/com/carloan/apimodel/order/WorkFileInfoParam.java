package com.carloan.apimodel.order;

import com.carloan.apimodel.common.PageInfoExt;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WorkFileInfoParam extends PageInfoExt {

    @ApiModelProperty(value = "进件编号")
    private String orderNumber;//订单编号,进件编号,ORDER_NUMBER
    @ApiModelProperty(value = "客户姓名")
    private String userName;//人姓名,客户姓名,USER_NAME
    @ApiModelProperty(value = "审批状态")
    private String auditeState;//审核状态,AUDITE_STATE
    @ApiModelProperty(hidden = true)
    private List<String> auditeStateList;
    @ApiModelProperty(value = "申请产品")
    private String productType;//产品类型,申请产品,PRODUCT_TYPE

    @ApiModelProperty(value = "证件号码")
    private String idCard;//身份证号,证件号码,ID_CARD
    @ApiModelProperty(value = "手    机")
    private String phoneNumber;//联系电话,手机号,PHONE_NUMBER
    @ApiModelProperty(value = "审批类型,1:新申请,2:复议")
    private String auditType;//审批类型:新申请,复议,跟auditeState审批状态相关,
    @ApiModelProperty(value = "进件日期开始")
    private Date creationTimeStart;//CREATION_TIME
    @ApiModelProperty(value = "进件日期结束")
    private Date creationTimeEnd;

    @ApiModelProperty(value = "区域")
    private String entryOrgId;//进件门店一级ID,ENTRY_ORG_ID
    @ApiModelProperty(value = "城市")
    private String secondLevelId;//进件门店二级ID,SECOND_LEVEL_ID
    @ApiModelProperty(value = "信审开始时间开始")
    private Date oneStartStart;//ONE_START
    @ApiModelProperty(value = "信审开始时间结束")
    private Date oneStartEnd;
    @ApiModelProperty(value = "审批结束时间开始")
    private Date oneEndStart;//ONE_END
    @ApiModelProperty(value = "审批结束时间结束")
    private Date oneEndEnd;

}
