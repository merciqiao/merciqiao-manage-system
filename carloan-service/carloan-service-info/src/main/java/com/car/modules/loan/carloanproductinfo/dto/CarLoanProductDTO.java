package com.car.modules.loan.carloanproductinfo.dto;

import com.carloan.apimodel.order.CarProductPropertyDTO;

import java.util.List;

public class CarLoanProductDTO {

    private static final long serialVersionUID = 1L;

    /**主键ID*/
    private Long id;

    /**进件ID*/
    private Long fkIntoId;

    /**产品类型*/
    private String productType;

    /**产品名称*/
    private String productName;

    /**产品编码*/
    private String productCode;

    /**还款方式(1:等额本息, 2:等额本金, 3:先息后本)(可多选,格式:1,2)*/
    private String repaymentWay;

    /**新定义还款方式*/
    private String repaymentType;
    /**
     * 贷款额度
     */
    private CarProductPropertyDTO loanLimitProp;

    private List loanPeriodList;


    public List getLoanPeriodList() {
        return loanPeriodList;
    }

    public void setLoanPeriodList(List loanPeriodList) {
        this.loanPeriodList = loanPeriodList;
    }

    /**
     * 综合费率
     */
    private CarProductPropertyDTO serviceRateProp;

    /**贷款期数(1:1期; 2:3期; 3:6期; 4:9期; 5:12期; 6:18期; 7:24期; 8:36期; 9:48期)*/
    private String loanPeriods;

    public String getLoanPeriods() {
        return loanPeriods;
    }

    public void setLoanPeriods(String loanPeriods) {
        this.loanPeriods = loanPeriods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkIntoId() {
        return fkIntoId;
    }

    public void setFkIntoId(Long fkIntoId) {
        this.fkIntoId = fkIntoId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getRepaymentWay() {
        return repaymentWay;
    }

    public void setRepaymentWay(String repaymentWay) {
        this.repaymentWay = repaymentWay;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public CarProductPropertyDTO getLoanLimitProp() {
        return loanLimitProp;
    }

    public void setLoanLimitProp(CarProductPropertyDTO loanLimitProp) {
        this.loanLimitProp = loanLimitProp;
    }

    public CarProductPropertyDTO getServiceRateProp() {
        return serviceRateProp;
    }

    public void setServiceRateProp(CarProductPropertyDTO serviceRateProp) {
        this.serviceRateProp = serviceRateProp;
    }
}
