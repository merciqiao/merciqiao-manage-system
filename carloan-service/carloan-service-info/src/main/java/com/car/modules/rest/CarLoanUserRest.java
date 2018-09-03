package com.car.modules.rest;

import com.car.modules.loan.carloanuser.dto.CarLoanUserDTO;
import com.car.modules.loan.carloanuser.service.CarLoanUserService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanUserRest
 * @description:
 * @date 2018/7/3：11:18
 */
@RestController
@RequestMapping(value="/CarLoanUserRest-api")
@Slf4j
@Component
@Api(tags="用户信息rest接口")
public class CarLoanUserRest {

    @Autowired
    private CarLoanUserService carLoanUserService;


    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/entity", method = RequestMethod.POST)
    @ApiOperation(value = "根据订单编号查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<CarLoanUserDTO> queryEntity(@RequestParam("order_number") String order_number)throws Exception{
        ResponseResult<CarLoanUserDTO>result=new ResponseResult<>();
        try{
            CarLoanUserDTO entity=carLoanUserService.queryCarLoanUserByOrderNum(order_number);
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
