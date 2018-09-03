package com.carloan.apimodel.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkFileInfoDTO {

    private String infoId;//主键id,car_loan_info.id
    private String orderNumber;//订单编号,进件编号
    private String userName;//人姓名,客户姓名
    private String idCard;//身份证号,证件号码
    private String phoneNumber;//联系电话,手机号

    private String productType;//产品类型,申请产品
    private String approvalProductType;//审批产品类型,审批产品
    private String approvalTerm;//审批期限
    private String approvalAmount;//审批金额,审批额度

    private String auditeState;//审核状态,审批状态
    private String auditType;//审批类型,1:新申请,2:复议,由auditeState转化
    private String creUserId;//信审员ID
    private String creUserUserName;//信审员姓名,信审员
    private String creUserOrgname;//信审员组织名称,信审室

    private String secondLevelName;//进件门店二级NAME,城市,所属门店

    private java.util.Date creationTime;//进件时间,创建时间
    private java.util.Date oneStart;//信审流程开始时间,信审开始时间
    private java.util.Date oneEnd;//信审流程结束时间,审批结束时间

}
