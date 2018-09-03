package com.car.modules.loan.workfile.dao;

import com.car.modules.loan.workfile.dto.WorkFileInfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WorkFileInfoDao {

    //查询质检之后的所有状态的进件
    List<WorkFileInfoDTO> query(Map<String, Object> searchParams);

}
