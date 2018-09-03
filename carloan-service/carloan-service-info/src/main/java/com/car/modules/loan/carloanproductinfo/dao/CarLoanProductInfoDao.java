package com.car.modules.loan.carloanproductinfo.dao;

import com.car.modules.loan.carloanproductinfo.dto.CarLoanProductDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CarLoanProductInfoDao {
    List<Map> querySysDictList(Map<String, String> temp);

    List<CarLoanProductDTO> queryCarProductData();
}
