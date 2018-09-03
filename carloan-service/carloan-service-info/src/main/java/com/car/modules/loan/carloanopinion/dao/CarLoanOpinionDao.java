package com.car.modules.loan.carloanopinion.dao;

import java.util.List;
import java.util.Map;

import com.car.modules.loan.carloanopinion.dto.CarLoanOpinionDTO;

public interface CarLoanOpinionDao {
    public List<CarLoanOpinionDTO> searchCarLoanOpinionByPaging(Map<String, Object> searchParams) ;
    
    public List<CarLoanOpinionDTO> searchCarLoanOpinion(Map<String,Object> searchParams);

    public CarLoanOpinionDTO findCarLoanOpinionByPrimaryKey(String id);
    
    public int insertCarLoanOpinion(Map<String, Object> paramMap);
    
    public int updateCarLoanOpinion(Map<String, Object> paramMap);

    public CarLoanOpinionDTO queryLikeCarLoanOpinion(Map<String, Object> paramMap);

    
}
