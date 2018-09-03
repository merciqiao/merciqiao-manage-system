package com.car.modules.rest;


import com.car.modules.loan.carloanbackinfo.dto.CarLoanBackInfoDTO;
import com.car.modules.loan.carloanbackinfo.service.CarLoanBackInfoService;
import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanBackInfoParam;
import com.carloan.apimodel.order.CarLoanBackInfoVo;
import com.carloan.common.utils.MapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/CarLoanBackInfoRest-api")
@Slf4j
@Component
@Api(tags="车贷补件记录表rest")
public class CarLoanBackInfoRest {
    @Autowired
    CarLoanBackInfoService carLoanBackInfoService;
    @Autowired
    MapperUtil mapper;
    @ApiOperation(value="根据订单id查询补件信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/get/entity",method = RequestMethod.POST)
    public ResponseResult<CarLoanBackInfoVo> queryEntity(@RequestParam("orderId") String orderId,@RequestParam("ordertypecode") String ordertypecode) throws Exception {
        ResponseResult<CarLoanBackInfoVo> result=new ResponseResult<>();
        try {
            CarLoanBackInfoDTO carLoanBackInfoDTO= carLoanBackInfoService.findCarLoanBackInfoByOrderId(orderId,ordertypecode);
            CarLoanBackInfoVo carLoanBackInfoVo= mapper.map(carLoanBackInfoDTO,CarLoanBackInfoVo.class);
            result.setStatus(Status.SUCCESS);
            result.setData(carLoanBackInfoVo);
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
    @ApiOperation(value="更新补件信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateBackInfo",method = RequestMethod.POST)
    public Response updateBackInfo(@RequestBody CarLoanBackInfoParam carLoanBackInfoParam) throws Exception {
        Response result=new Response();
        try {
            String orderId=carLoanBackInfoParam.getFkIntoCustRefId().toString();
            String orderTypeCode=carLoanBackInfoParam.getOrdertypecode().toString();
            String orderTypeName=carLoanBackInfoParam.getOrdertypename();
            String status=carLoanBackInfoParam.getStatus();
            carLoanBackInfoService.updateBackInfo(orderId,orderTypeCode,orderTypeName,status);
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
    @ApiOperation(value="插入补件信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/insertCarLoanBackInfo",method = RequestMethod.POST)
    public Response insertCarLoanBackInfo(@RequestBody CarLoanBackInfoParam carLoanBackInfoParam) throws Exception {
        Response result=new Response();
        try {
            CarLoanBackInfoDTO dto=mapper.map(carLoanBackInfoParam,CarLoanBackInfoDTO.class);
            carLoanBackInfoService.insertCarLoanBackInfo(dto);
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
