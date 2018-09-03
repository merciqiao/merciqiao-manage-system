package com.carloan.apimodel.order;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarLoanInfoVo {
    private static final long serialVersionUID = 1L;

    /**主键id*/
    private Long id;

    /**订单编号*/
    private String orderNumber;

    /**产品系列*/
    private String productSeries;

    /**产品类型*/
    private String productType;

    /**申请期限*/
    private String productTerm;

    /**申请额度*/
    private String applicationLimit;

    /**融资用途*/
    private String financingPurposes;

    /**追加额度*/
    private String additionalCredits;

    /**期望融资总额*/
    private String expectedTotalFinancing;

    /**是否同意过户*/
    private String isAgreedChangeName;

    /**客户来源*/
    private String customerSource;

    /**业务联系人*/
    private String name;

    /**业务联系电话*/
    private String phone;

    /**进件门店一级ID*/
    private String entryOrgid;

    /**进件门店一级NAME*/
    private String entryOrgname;

    /**进件门店二级ID*/
    private String secondlevelid;

    /**进件门店二级NAME*/
    private String secondlevelname;

    /**门店评估师*/
    private String storeAppraiser;

    /**客户经理*/
    private String customerManager;

    /**进件时间*/
    private String entryDate;

    /**审核结束时间*/
    private String endDate;

    /**审批金额*/
    private String approvalAmount;

    /**订单状态*/
    private String orderStatus;

    /**是否批复*/
    private String doyouApprove;

    /**审批期限*/
    private String approvalTerm;

    /**单位具体描述*/
    private String companyDescription;

    /**家庭具体描述*/
    private String familyDescription;

    /**征信报告情况*/
    private String informationReport;

    /**人法网查询情况*/
    private String RFWQuerySituation;

    /**工商网查询情况*/
    private String GSWQuerySituation;

    /**电核情况*/
    private String telephoneVerification;

    /**其他情况说明*/
    private String otherInformation;

    /**创建时间*/
    private Date creationTime;

    /**修改时间*/
    private Date updateTime;
    /**大区来源*/
    private String regional;
    /**分区来源*/
    private String subRegional;
    /**区域来源*/
    private String area;
    /**审核状态*/
    private String auditeState;

    private String carinfoid;
}
