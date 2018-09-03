package com.car.modules.loan.carloanprice.dao;

import java.util.List;
import java.util.Map;

import com.car.modules.loan.carloanprice.dto.CarLoanPriceDTO;

public interface CarLoanPriceDao {
    public List<CarLoanPriceDTO> searchCarLoanPriceByPaging(Map<String, Object> searchParams) ;
    
    public List<CarLoanPriceDTO> searchCarLoanPrice(Map<String,Object> searchParams);

    public CarLoanPriceDTO findCarLoanPriceByPrimaryKey(String id);
    
    public int insertCarLoanPrice(Map<String, Object> paramMap);
    
    public int updateCarLoanPrice(Map<String, Object> paramMap);

    public CarLoanPriceDTO queryLikeCarLoanPrice(Map<String, Object> paramMap);

    
}
