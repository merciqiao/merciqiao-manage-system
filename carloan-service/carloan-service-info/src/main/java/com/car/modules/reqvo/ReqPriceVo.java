package com.car.modules.reqvo;

import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;
import com.car.modules.loan.carloanmsg.dto.CarLoanMsgDTO;
import com.car.modules.loan.carloanreconsideration.dto.CarLoanReconsiderationDTO;

import java.util.List;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ReqVo
 * @description:
 * @date 2018/5/24：19:41
 */
public class ReqPriceVo extends ResponseTitle{
    private String orderNumber;
    private String status;
    private String reqDate;
    private CarLoanMsgDTO carLoanMsgDTO;
    private List<CarLoanFileDTO>  carLoanFileDTOList;
    private CarLoanReconsiderationDTO carLoanReconsiderationDTO;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public CarLoanMsgDTO getCarLoanMsgDTO() {
        return carLoanMsgDTO;
    }

    public void setCarLoanMsgDTO(CarLoanMsgDTO carLoanMsgDTO) {
        this.carLoanMsgDTO = carLoanMsgDTO;
    }

    public List<CarLoanFileDTO> getCarLoanFileDTOList() {
        return carLoanFileDTOList;
    }

    public void setCarLoanFileDTOList(List<CarLoanFileDTO> carLoanFileDTOList) {
        this.carLoanFileDTOList = carLoanFileDTOList;
    }

    public CarLoanReconsiderationDTO getCarLoanReconsiderationDTO() {
        return carLoanReconsiderationDTO;
    }

    public void setCarLoanReconsiderationDTO(CarLoanReconsiderationDTO carLoanReconsiderationDTO) {
        this.carLoanReconsiderationDTO = carLoanReconsiderationDTO;
    }
}
