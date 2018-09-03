package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanSurveyInfoDTO;
import com.carloan.feign.info.CarLoanSurveyInfoServicefeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/carloansurveyinfo-api")
@Slf4j
@Component
@Api(tags="电核备注--jiangyang")
public class CarLoanSurveyInfoController {
    @Autowired
    private CarLoanSurveyInfoServicefeign carLoanSurveyInfoServicefeign;

    @ApiOperation(value = "查询电核网核备注信息", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    @RequestMapping(value = "/searchCarLoanSurveyInfo", method = RequestMethod.POST)
    public ResponseResult<Object> searchCarLoanSurveyInfo(@RequestParam("survey_contacts_id") String survey_contacts_id) throws Exception {

        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyInfoServicefeign.searchCarLoanSurveyInfo(survey_contacts_id);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyInfoController：searchCarLoanSurveyInfo" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }

    }

    @ApiOperation(value = "新增电核网核备注信息", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    @RequestMapping(value = "/insertCarLoanSurveyInfo", method = RequestMethod.POST)
    public ResponseResult<Object> insertCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam) throws Exception {

        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyInfoServicefeign.insertCarLoanSurveyContacts(carLoanSurveyInfoParam);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyInfoController：insertCarLoanSurveyContacts" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @ApiOperation(value = "更新电核网核备注信息", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    @RequestMapping(value = "/updateCarLoanSurveyInfo", method = RequestMethod.POST)
    public ResponseResult<Object> updateCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam) throws Exception {

        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyInfoServicefeign.updateCarLoanSurveyContacts(carLoanSurveyInfoParam);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyInfoController：updateCarLoanSurveyContacts" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="保存电核网核信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/saveCarLoanSurveyInfo",method = RequestMethod.POST)
    public ResponseResult<Object> saveCarLoanSurveyInfo(@RequestParam("order_number") String order_number,@RequestParam("otherRemark") String otherRemark,@RequestParam("contactsInfo_id") String contactsInfo_id,@RequestParam("ycContent") String ycContent) throws Exception {

        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanSurveyInfoServicefeign.saveCarLoanSurveyInfo(order_number,otherRemark,contactsInfo_id,ycContent);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanSurveyInfoController：saveCarLoanSurveyInfo" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}
