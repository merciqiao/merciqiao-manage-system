package com.car.modules.loan.carloanproductinfo.rest;

import com.car.modules.loan.carloanproductinfo.dto.CarLoanProductDTO;
import com.car.modules.loan.carloanproductinfo.service.CarLoanProductInfoService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.common.redisTemplate.service.RedisUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value="/car-product-info")
public class CarLoanProductInfoRest {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private CarLoanProductInfoService service;

    @RequestMapping(value = "/querySysDictList",method = RequestMethod.POST)
    public List<Map> querySysDictList(@RequestParam("code") String code){
        List<Map> list=new ArrayList<>();
        try {
             list=service.querySysDictList(code);
        }catch (Exception e){
            e.printStackTrace();
            log.error("querySysDictList方法异常");
        }
        return list;
    }

    @RequestMapping(value = "/queryCarProductData")
    public ResponseResult<CarLoanProductDTO> queryCarProductData(){
        ResponseResult<CarLoanProductDTO> result=new ResponseResult<>();
        try {
            List<CarLoanProductDTO> list=service.queryCarProductData();
            result.setDataList(list);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error("queryCarProductData方法异常");
        }
        return result;
    }
}
