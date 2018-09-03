package com.car.modules.rest;

import com.car.modules.loan.carloanusercontacts.service.CarLoanUserContactsService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanUserContactsRest
 * @description:
 * @date 2018/7/30：15:17
 */


@RestController
@RequestMapping(value="/CarLoanUserContactsRest-api")
@Slf4j
@Component
public class CarLoanUserContactsRest {

    @Autowired
    private CarLoanUserContactsService carLoanUserContactsService;


    @ResponseBody
    @RequestMapping(value = "/get/entity", method = RequestMethod.POST)
    @ApiOperation(value = "根据订单编号查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<List> queryEntity(@RequestParam("order_number") String order_number)throws Exception{
        ResponseResult<List>result=new ResponseResult<>();
        try{
            List entity=carLoanUserContactsService.findCarLoanUserContactsByOrderNum(order_number);
            result.setStatus(Status.SUCCESS);
            result.setData(entity);
            result.setMessage("查询成功");
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}
