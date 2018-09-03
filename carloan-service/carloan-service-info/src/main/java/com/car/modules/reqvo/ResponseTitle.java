package com.car.modules.reqvo;

import com.car.modules.loan.carloanopinion.dto.CarLoanOpinionDTO;
import com.car.modules.loan.carloanprice.dto.CarLoanPriceDTO;
import com.car.modules.loan.carloanreconsideration.dto.CarLoanReconsiderationDTO;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ReqTitle
 * @description:
 * @date 2018/5/25：16:26
 */
public class ResponseTitle  {
    private String orderNumber;
    private String status;
    private String reqDate;
    private CarLoanPriceDTO carLoanPriceDTO;
    private CarLoanOpinionDTO carLoanOpinionDTO;
    private CarLoanReconsiderationDTO carLoanReconsiderationDTO;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public CarLoanPriceDTO getCarLoanPriceDTO() {
        return carLoanPriceDTO;
    }

    public void setCarLoanPriceDTO(CarLoanPriceDTO carLoanPriceDTO) {
        this.carLoanPriceDTO = carLoanPriceDTO;
    }

    public CarLoanOpinionDTO getCarLoanOpinionDTO() {
        return carLoanOpinionDTO;
    }

    public void setCarLoanOpinionDTO(CarLoanOpinionDTO carLoanOpinionDTO) {
        this.carLoanOpinionDTO = carLoanOpinionDTO;
    }

    public CarLoanReconsiderationDTO getCarLoanReconsiderationDTO() {
        return carLoanReconsiderationDTO;
    }

    public void setCarLoanReconsiderationDTO(CarLoanReconsiderationDTO carLoanReconsiderationDTO) {
        this.carLoanReconsiderationDTO = carLoanReconsiderationDTO;
    }
}
