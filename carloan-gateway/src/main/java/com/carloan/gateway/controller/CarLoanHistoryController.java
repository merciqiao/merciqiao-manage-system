package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanHistoryDetailDTO;
import com.carloan.apimodel.order.CarLoanUserVo;
import com.carloan.feign.info.CarLoanHistoryServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.List;

@RestController
@RequestMapping(value="/carinfo-history-api")
@Slf4j
@Api(tags = {"历史匹配接口-shidoudou"})
public class CarLoanHistoryController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarLoanHistoryServiceFeign carLoanHistoryServiceFeign;

    @ApiOperation(value="查询车贷手机号匹配信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "GET")
    @RequestMapping(value = "/queryCarLoanPhoneHistory",method = RequestMethod.GET)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanPhoneHistory(@RequestParam("orderNumber") String orderNumber){
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        try {
            result=carLoanHistoryServiceFeign.queryCarLoanPhoneHistory(orderNumber);
            CarLoanHistoryDetailDTO carphone=result.getData();
            try {
                if(StringUtils.isNotEmpty(carphone.getPhoneNumber())){
                    ParameterizedTypeReference<List<CarLoanHistoryDetailDTO>> typeRef = new ParameterizedTypeReference<List<CarLoanHistoryDetailDTO>>() {};
                    String url="http://172.24.133.70:8080/loan/api/carLoanHistory/getLoanCarPhone";
                    String param="phoneNumber="+carphone.getPhoneNumber();
                    String urlParam=url+"?"+param;
                    ResponseEntity<List<CarLoanHistoryDetailDTO>> responseEntity = restTemplate.exchange(urlParam, HttpMethod.POST,null, typeRef );
                    List<CarLoanHistoryDetailDTO> list=result.getDataList();
                    if(CollectionUtils.isNotEmpty(responseEntity.getBody())){
                        list.addAll(responseEntity.getBody());
                    }
                    result.setDataList(list);
                }
            }catch (Exception a){
                a.printStackTrace();
                log.error("执行查询信审getCarPhone异常",a);
            }
            result.setData(null);
            return result;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            result.setStatus(Status.FAILED);
            result.setMessage("queryCarLoanPhoneHistory执行异常,请重试");
        }
        return result;
    }

    @ApiOperation(value="查询车贷车牌号匹配信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "GET")
    @RequestMapping(value = "/queryCarLoanCarNumberHistory",method = RequestMethod.GET)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanCarNumberHistory(@RequestParam("orderNumber") String orderNumber){
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        try {
            result=carLoanHistoryServiceFeign.queryCarLoanCarNumberHistory(orderNumber);
            return result;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            result.setStatus(Status.FAILED);
            result.setMessage("queryCarLoanCarNumberHistory执行异常,请重试");
        }
        return result;
    }

    @ApiOperation(value="查询车贷身份证匹配信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "GET")
    @RequestMapping(value = "/queryCarLoanIdCardHistory",method = RequestMethod.GET)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanIdCardHistory(@RequestParam("orderNumber") String orderNumber){
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        try {
            result=carLoanHistoryServiceFeign.queryCarLoanIdCardHistory(orderNumber);
            CarLoanHistoryDetailDTO car=result.getData();
            try {
                if(StringUtils.isNotEmpty(car.getIdCard())){
                    ParameterizedTypeReference<List<CarLoanHistoryDetailDTO>> typeRef = new ParameterizedTypeReference<List<CarLoanHistoryDetailDTO>>() {};
                    String url="http://172.24.133.70:8080/loan/api/carLoanHistory/getLoanCarIdCard";
                    String param="idCard="+car.getIdCard();
                    String urlParam=url+"?"+param;
                    ResponseEntity<List<CarLoanHistoryDetailDTO>> responseEntity = restTemplate.exchange(urlParam, HttpMethod.POST,null, typeRef );
                    List<CarLoanHistoryDetailDTO> list=result.getDataList();
                    if(CollectionUtils.isNotEmpty(responseEntity.getBody())){
                        list.addAll(responseEntity.getBody());
                    }
                    result.setDataList(list);
                }
            }catch (Exception a){
                a.printStackTrace();
                log.error("执行查询信审getCarIdCard异常",a);
            }
            result.setData(null);
            return result;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            result.setStatus(Status.FAILED);
            result.setMessage("queryCarLoanIdCardHistory执行异常,请重试");
        }
        return result;
    }

    @ApiOperation(value="查询车贷车架号匹配信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "GET")
    @RequestMapping(value = "/queryCarLoanCarFrameNumberHistory",method = RequestMethod.GET)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanCarFrameNumberHistory(@RequestParam("orderNumber") String orderNumber){
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        try {
            result=carLoanHistoryServiceFeign.queryCarLoanCarFrameNumberHistory(orderNumber);
            return result;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            result.setStatus(Status.FAILED);
            result.setMessage("queryCarLoanCarFrameNumberHistory执行异常,请重试");
        }
        return result;
    }
}
