package com.car.modules.rest;

import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanInfoParam;
import com.carloan.apimodel.order.CarLoanInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarLoanInfoRest
 * @description:
 * @date 2018/7/3：11:32
 */

@RestController
@RequestMapping(value="/CarLoanInfoRest-api")
@Slf4j
@Component
@Api(tags="订单信息rest")
public class CarLoanInfoRest {

    @Autowired
   private CarLoanInfoService carLoanInfoService;

    @ApiOperation(value="根据订单编号查询订单信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/get/entity",method = RequestMethod.POST)
    public ResponseResult<CarLoanInfoDTO> queryEntity(@RequestParam("order_number") String order_number) throws Exception {
        ResponseResult<CarLoanInfoDTO> result=new ResponseResult<>();
        try {
            CarLoanInfoDTO carLoanInfoDTO= carLoanInfoService.findCarLoanInfoByOrderNum(order_number);
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




    @Autowired
    Mapper mapper;
    @ApiOperation(value="根据orderId查询订单信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/queryCarLoanInfoByPrimaryKey",method = RequestMethod.POST)
    public ResponseResult<CarLoanInfoVo> queryCarLoanInfoByPrimaryKey(@RequestBody CarLoanInfoParam carLoanInfoParam) throws Exception {
        ResponseResult<CarLoanInfoVo> result=new ResponseResult<>();
        try {
            CarLoanInfoDTO carLoanInfoDTO= carLoanInfoService.queryCarLoanInfoByPrimaryKey(carLoanInfoParam.getId().toString());
            CarLoanInfoVo carLoanInfoVo=mapper.map(carLoanInfoDTO,CarLoanInfoVo.class);
            result.setStatus(Status.SUCCESS);
            result.setData(carLoanInfoVo);
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

    @ApiOperation(value="更新订单状态",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateCarLoanInfoAuditState",method = RequestMethod.POST)
    public Response updateCarLoanInfoAuditState(@RequestBody CarLoanInfoParam carLoanInfoParam) throws Exception {
        Response result=new Response();
        try {
            CarLoanInfoDTO dto=mapper.map(carLoanInfoParam,CarLoanInfoDTO.class);
            carLoanInfoService.updateCarLoanInfoAuditState(dto);
            result.setStatus(Status.SUCCESS);
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
