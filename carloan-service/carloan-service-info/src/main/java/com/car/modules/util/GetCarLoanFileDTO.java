package com.car.modules.util;


import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: GetCarLoanFileDTO
 * @description:
 * @date 2018/5/28：15:42
 */
public class GetCarLoanFileDTO {



    public static CarLoanFileDTO getFileDTO(String attachType,String url,String remake){
        CarLoanFileDTO carLoanFileDTO = new CarLoanFileDTO();
        carLoanFileDTO.setFileUrl(url);
        carLoanFileDTO.setHistoryUrl(url);
        carLoanFileDTO.setAttachType(attachType);
        carLoanFileDTO.setFileLink(remake);
        return carLoanFileDTO;

    }
}
