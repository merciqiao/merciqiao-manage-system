package com.car.modules.loan.carantifraudopnition.dao;

import java.util.List;
import java.util.Map;

import com.car.modules.loan.carantifraudopnition.dto.CarAntifraudOpnitionDTO;

public interface CarAntifraudOpnitionDao {
    public List<CarAntifraudOpnitionDTO> searchCarAntifraudOpnitionByPaging(Map<String, Object> searchParams) ;
    
    public List<CarAntifraudOpnitionDTO> searchCarAntifraudOpnition(Map<String,Object> searchParams);

    public CarAntifraudOpnitionDTO findCarAntifraudOpnitionByPrimaryKey(String id);
    
    public int insertCarAntifraudOpnition(Map<String, Object> paramMap);
    
    public int updateCarAntifraudOpnition(Map<String, Object> paramMap);

    public CarAntifraudOpnitionDTO queryLikeCarAntifraudOpnition(Map<String, Object> paramMap);

    
}
