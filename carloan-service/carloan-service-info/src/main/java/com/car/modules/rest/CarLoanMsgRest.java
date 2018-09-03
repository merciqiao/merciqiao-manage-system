package com.car.modules.rest;

import com.car.modules.loan.carloanmsg.dto.CarLoanMsgDTO;
import com.car.modules.loan.carloanmsg.service.CarLoanMsgService;
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
 * @classname: CarLoanMsgRest
 * @description:
 * @date 2018/7/3：11:10
 */

@RestController
@RequestMapping(value="/CarLoanMsgRest-api")
@Slf4j
@Component
@Api(tags="车辆信息rest")
public class CarLoanMsgRest {

    @Autowired
    private CarLoanMsgService carLoanMsgService;

    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/entity", method = RequestMethod.POST)
    @ApiOperation(value = "根据订单编号查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<CarLoanMsgDTO> queryEntity(@RequestParam("order_number") String order_number)throws Exception{
        ResponseResult<CarLoanMsgDTO>result=new ResponseResult<>();
        try{
            CarLoanMsgDTO entity=carLoanMsgService.queryCarLoanMsgByPrimaryKey(order_number);
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
