package com.car.modules.loan.carloanhistoryinfo.dto;

/**
 * @author shidoudou
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanHistoryDetailDTO
 * @description:
 * @date 2018/5/30：9:26
 */
public class CarLoanHistoryDetailDTO {

    //进件时间
    private String entryDate;
    //进件编号
    private String orderNumber;
    //进件id
    private String intoId;
    //产品名称
    private String productType;
    //进件人姓名
    private String userName;
    //进件人身份证号
    private String idCard;
    //是否批复
    private String doyouApprove;
    //审批金额
    private String approvalAmount;
    //审批期限
    private String approvalTerm;
    //终审人员
    private String creLastUser;
    //进件门店
    private String secondLevelName;
    //客户经理
    private String customerManager;
    //门店评估师
    private String storeAppraiser;
    //进件人车牌号
    private String carNumber;
    //进件人车架号
    private String carFrameNumber;

    private String isCarXin;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsCarXin() {
        return isCarXin;
    }

    public void setIsCarXin(String isCarXin) {
        this.isCarXin = isCarXin;
    }

    public String getCreLastUser() {
        return creLastUser;
    }

    public void setCreLastUser(String creLastUser) {
        this.creLastUser = creLastUser;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getIntoId() {
        return intoId;
    }

    public void setIntoId(String intoId) {
        this.intoId = intoId;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDoyouApprove() {
        return doyouApprove;
    }

    public void setDoyouApprove(String doyouApprove) {
        this.doyouApprove = doyouApprove;
    }

    public String getApprovalAmount() {
        return approvalAmount;
    }

    public void setApprovalAmount(String approvalAmount) {
        this.approvalAmount = approvalAmount;
    }

    public String getApprovalTerm() {
        return approvalTerm;
    }

    public void setApprovalTerm(String approvalTerm) {
        this.approvalTerm = approvalTerm;
    }

    public String getSecondLevelName() {
        return secondLevelName;
    }

    public void setSecondLevelName(String secondLevelName) {
        this.secondLevelName = secondLevelName;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
    }

    public String getStoreAppraiser() {
        return storeAppraiser;
    }

    public void setStoreAppraiser(String storeAppraiser) {
        this.storeAppraiser = storeAppraiser;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarFrameNumber() {
        return carFrameNumber;
    }

    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }
}
