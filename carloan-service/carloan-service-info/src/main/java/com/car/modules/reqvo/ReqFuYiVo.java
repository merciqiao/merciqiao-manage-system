package com.car.modules.reqvo;


import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;
import com.car.modules.loan.carloanreconsideration.dto.CarLoanReconsiderationDTO;

import java.util.List;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ReqFuYiVo
 * @description:
 * @date 2018/5/28：15:24
 */
public class ReqFuYiVo {
    private String orderNumber;
    private String status;
    private String reqDate;
    private CarLoanReconsiderationDTO carLoanReconsiderationDTO;

    private List<CarLoanFileDTO>  carLoanFileDTOList;

    public List<CarLoanFileDTO> getCarLoanFileDTOList() {
        return carLoanFileDTOList;
    }

    public void setCarLoanFileDTOList(List<CarLoanFileDTO> carLoanFileDTOList) {
        this.carLoanFileDTOList = carLoanFileDTOList;
    }

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

    public CarLoanReconsiderationDTO getCarLoanReconsiderationDTO() {
        return carLoanReconsiderationDTO;
    }

    public void setCarLoanReconsiderationDTO(CarLoanReconsiderationDTO carLoanReconsiderationDTO) {
        this.carLoanReconsiderationDTO = carLoanReconsiderationDTO;
    }
}
