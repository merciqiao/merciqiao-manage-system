package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanSurveyContactsDTO;
import com.carloan.feign.info.CarLoanSurveyContactsServicefeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/carloansurveycontacts-api")
@Slf4j
@Component
@Api(tags="电核网核--jiangyang")

public class CarLoanSurveyContactsController {
    @Autowired
    private CarLoanSurveyContactsServicefeign carLoanSurveyContactsServicefeign;

    @ApiOperation(value="查询电核网核联系人列表",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/searchCarLoanSurveyContacts",method = RequestMethod.POST)
    public ResponseResult<Object> searchCarLoanSurveyContacts(@RequestParam("order_number") String order_number) throws Exception {

        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyContactsServicefeign.searchCarLoanSurveyContacts(order_number);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyContactsController：searchCarLoanSurveyContacts" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="查询电核网核联系人详细信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/searchCarLoanSurveyContactsInfo",method = RequestMethod.POST)
    public ResponseResult<Object> searchCarLoanSurveyContactsInfo(@RequestParam("contactsInfo_id") String contactsInfo_id) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyContactsServicefeign.searchCarLoanSurveyContactsInfo(contactsInfo_id);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyContactsController：searchCarLoanSurveyContactsInfo" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }

    }
    @ApiOperation(value="新增电核网核联系人信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/insertCarLoanSurveyContacts",method = RequestMethod.POST)
    public ResponseResult<Object> insertCarLoanSurveyContacts(@RequestBody CarLoanSurveyContactsDTO carLoanSurveyContactsParam) throws Exception {

        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyContactsServicefeign.insertCarLoanSurveyContacts(carLoanSurveyContactsParam);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyContactsController：insertCarLoanSurveyContacts" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="更新电核网核联系人",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateCarLoanSurveyContacts",method = RequestMethod.POST)
    public ResponseResult<Object> updateCarLoanSurveyContacts(@RequestBody CarLoanSurveyContactsDTO CarLoanSurveyContactsInfoParam) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyContactsServicefeign.updateCarLoanSurveyContacts(CarLoanSurveyContactsInfoParam);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyContactsController：updateCarLoanSurveyContacts" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }

    }
    @ApiOperation(value="删除电核网核联系人",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/deleteCarLoanSurveyContacts",method = RequestMethod.POST)
    public ResponseResult<Object> deleteCarLoanSurveyContacts(@RequestBody CarLoanSurveyContactsDTO CarLoanSurveyContactsInfoParam) throws Exception {

        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyContactsServicefeign.deleteCarLoanSurveyContacts(CarLoanSurveyContactsInfoParam);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyContactsController：deleteCarLoanSurveyContacts" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


 }
