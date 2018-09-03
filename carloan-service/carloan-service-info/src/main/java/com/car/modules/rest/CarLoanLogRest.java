package com.car.modules.rest;

import com.car.modules.loan.carloanlog.dto.CarLoanLogDTO;
import com.car.modules.loan.carloanlog.service.CarLoanLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanLogRest
 * @description:
 * @date 2018/7/10：15:10
 */
@RestController
@RequestMapping(value="/CarLoanLogRest-api")
@Slf4j
@Component
public class CarLoanLogRest {

    @Autowired
    private CarLoanLogService carLoanLogService;


    @RequestMapping(value = "/get/entityList",method = RequestMethod.POST)
    public Object queryEntity(@RequestBody CarLoanLogDTO carLoanLogDTO) throws Exception {
       return carLoanLogService.searchCarLoanLog(carLoanLogDTO);
    }

}
