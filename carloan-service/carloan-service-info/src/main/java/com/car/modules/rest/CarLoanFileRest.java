package com.car.modules.rest;

import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;
import com.car.modules.loan.carloanfile.service.CarLoanFileService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanFileRest
 * @description:
 * @date 2018/7/4：14:40
 */

@RestController
@RequestMapping(value="/CarLoanFileRest-api")
@Slf4j
@Component
@Api(tags="影像附件rest")
public class CarLoanFileRest {

    @Autowired
    private CarLoanFileService carLoanFileService;


    @ApiOperation(value="根据订单编号查询影像信息信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/get/entity",method = RequestMethod.POST)
    public ResponseResult<List<CarLoanFileDTO>> queryEntity(@RequestParam("order_number") String order_number) throws Exception {
        ResponseResult<List<CarLoanFileDTO> > result=new ResponseResult<>();
        try {
            List<CarLoanFileDTO> carLoanInfoDTO= carLoanFileService.findCarLoanFileOrderNum(order_number);
            result.setStatus(Status.SUCCESS);
            result.setData(carLoanInfoDTO);
            result.setMessage("执行成功");
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }
}
