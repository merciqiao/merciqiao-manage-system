package com.carloan.gateway.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanRichTextDTO;
import com.carloan.feign.info.CarLoanRichTextServicefeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/carloanrichtext-api")
@Slf4j
@Component
@Api(tags="初审备注以及终审备注--jiangyang")
public class CarLoanRichTextController {
    @Autowired
    private CarLoanRichTextServicefeign carLoanRichTextServicefeign;

    @ApiOperation(value = "查询初审备注以及终审备注信息", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    @RequestMapping(value = "/searchCarLoanRichText", method = RequestMethod.POST)
    public ResponseResult<Object> searchCarLoanRichText(@RequestParam("relation_number") String relation_number, @RequestParam("biz_type") String biz_type) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanRichTextServicefeign.searchCarLoanRichText(relation_number, biz_type);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanRichTextController：searchCarLoanRichText" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }

    }

    @ApiOperation(value = "新增或者编辑初审终审备注信息", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    @RequestMapping(value = "/insertCarLoanRichText", method = RequestMethod.POST)
    public ResponseResult<Object> insertCarLoanRichText(@RequestParam("relation_number") String relation_number, @RequestParam("biz_type") String biz_type, @RequestParam("Content") String Content) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result = this.carLoanRichTextServicefeign.insertCarLoanRichText(relation_number, biz_type, Content);
            return result;
        } catch (Exception ex) {
            log.error("执行方法CarLoanRichTextController：insertCarLoanRichText"+ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }


    }
}
