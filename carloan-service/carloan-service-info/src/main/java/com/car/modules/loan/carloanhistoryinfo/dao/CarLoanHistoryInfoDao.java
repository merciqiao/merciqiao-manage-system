package com.car.modules.loan.carloanhistoryinfo.dao;

import com.car.modules.loan.carloanhistoryinfo.dto.CarLoanHistoryDetailDTO;

import java.util.List;
import java.util.Map;

/**
 * @author shidoudou
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanHistoryInfoDao
 * @description:
 * @date 2018/5/30：9:12
 */
public interface CarLoanHistoryInfoDao {


    List<CarLoanHistoryDetailDTO> queryCarNumber(Map<String, Object> searchParams);

    List<CarLoanHistoryDetailDTO> queryCarLoanPhone(Map<String, Object> searchParams);

    List<CarLoanHistoryDetailDTO> queryCarLoanContactPhone(Map<String, Object> searchParams);
}
