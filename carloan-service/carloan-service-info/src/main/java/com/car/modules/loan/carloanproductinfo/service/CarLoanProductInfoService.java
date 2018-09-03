package com.car.modules.loan.carloanproductinfo.service;

import com.car.modules.loan.carloanproductinfo.dao.CarLoanProductInfoDao;
import com.car.modules.loan.carloanproductinfo.dto.CarLoanProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("com.car.modules.loan.carloanproductinfo.service.CarLoanProductInfoService")
public class CarLoanProductInfoService implements Serializable{
    @Autowired
    private CarLoanProductInfoDao dao;

    public List<Map> querySysDictList(String code) {
        HashMap temp = new HashMap();
        temp.put("code", code);
        return dao.querySysDictList(temp);
    }

    public List<CarLoanProductDTO> queryCarProductData() {
        return dao.queryCarProductData();
    }
}
