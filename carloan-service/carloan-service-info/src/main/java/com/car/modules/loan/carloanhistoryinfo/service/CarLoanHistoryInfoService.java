package com.car.modules.loan.carloanhistoryinfo.service;

import com.car.modules.loan.carloanhistoryinfo.dao.CarLoanHistoryInfoDao;
import com.car.modules.loan.carloanhistoryinfo.dto.CarLoanHistoryDetailDTO;
import com.car.modules.loan.carloanmsg.dto.CarLoanMsgDTO;
import com.car.modules.loan.carloanuser.dto.CarLoanUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shidoudou
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanHistoryInfoService
 * @description:
 * @date 2018/5/29：18:09
 */
@Service("com.car.modules.loan.carloanhistoryinfo.service.CarLoanHistoryInfoService")
public class CarLoanHistoryInfoService implements Serializable{

    private static final long serialVersionUID = 1L;

    @Autowired
    private CarLoanHistoryInfoDao dao;

    public List<CarLoanHistoryDetailDTO> queryCarLoanPhone(CarLoanUserDTO carLoanUserDTO) {
        Map<String, Object> searchParams = new HashMap<String, Object>();
        searchParams.put("dto", carLoanUserDTO);
        List<CarLoanHistoryDetailDTO> list=dao.queryCarLoanPhone(searchParams);
        return list;
    }

    public List<CarLoanHistoryDetailDTO> queryCarNumber(CarLoanMsgDTO carMagDto) {
        Map<String, Object> searchParams = new HashMap<String, Object>();
        searchParams.put("dto", carMagDto);
        List<CarLoanHistoryDetailDTO> list=dao.queryCarNumber(searchParams);
        return list;
    }

    public List<CarLoanHistoryDetailDTO> queryCarLoanContactPhone(CarLoanUserDTO carLoanUserDTO) {
        Map<String, Object> searchParams = new HashMap<String, Object>();
        searchParams.put("dto", carLoanUserDTO);
        List<CarLoanHistoryDetailDTO> list=dao.queryCarLoanContactPhone(searchParams);
        return list;
    }
}
