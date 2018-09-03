package com.car.modules.reqvo;

import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;
import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloanuser.dto.CarLoanUserDTO;
import com.car.modules.loan.carloanusercontacts.dto.CarLoanUserContactsDTO;

import java.util.List;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ReqUserVo
 * @description:
 * @date 2018/5/25：13:19
 */
public class ReqUserInIfVo extends ResponseTitle {
    private String orderNumber;
    private String status;
    private String reqDate;
    private CarLoanInfoDTO carLoanInfoDTO;
    private CarLoanUserDTO carLoanUserDTO;
    private List<CarLoanUserContactsDTO> carLoanUserContactsDTOList;
    private List<CarLoanFileDTO> carLoanFileDTOList;

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

    public CarLoanInfoDTO getCarLoanInfoDTO() {
        return carLoanInfoDTO;
    }

    public void setCarLoanInfoDTO(CarLoanInfoDTO carLoanInfoDTO) {
        this.carLoanInfoDTO = carLoanInfoDTO;
    }

    public CarLoanUserDTO getCarLoanUserDTO() {
        return carLoanUserDTO;
    }

    public void setCarLoanUserDTO(CarLoanUserDTO carLoanUserDTO) {
        this.carLoanUserDTO = carLoanUserDTO;
    }


    public List<CarLoanFileDTO> getCarLoanFileDTOList() {
        return carLoanFileDTOList;
    }

    public void setCarLoanFileDTOList(List<CarLoanFileDTO> carLoanFileDTOList) {
        this.carLoanFileDTOList = carLoanFileDTOList;
    }

    public List<CarLoanUserContactsDTO> getCarLoanUserContactsDTOList() {
        return carLoanUserContactsDTOList;
    }

    public void setCarLoanUserContactsDTOList(List<CarLoanUserContactsDTO> carLoanUserContactsDTOList) {
        this.carLoanUserContactsDTOList = carLoanUserContactsDTOList;
    }
}
