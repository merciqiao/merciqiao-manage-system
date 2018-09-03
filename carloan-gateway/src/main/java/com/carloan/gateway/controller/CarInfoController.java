package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.feign.info.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CarInfoController
 * @description:
 * @date 2018/7/3：14:28
 */

@RestController
@RequestMapping(value="/web-carinfo-api")
@Slf4j
@Api(tags = {"订单查询信息接口-zhouzhiwei"})
public class CarInfoController {
    @Autowired
    private  CarLoanInfoServiceFeign carLoanInfoServiceFeign;
    @Autowired
    private  CarLoanMsgServiceFeign carLoanMsgServiceFeign;
    @Autowired
    private  CarLoanUserServiceFeign carLoanUserServiceFeign;
    @Autowired
    private CarLoanFileServiceFeign carLoanFileServiceFeign;
    @Autowired
    private CarLoanSurveyContactsServicrfeign carLoanSurveyContactsServicrfeign;

    /**
     * 取得单个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryEntityCarLoanInfo", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据订单编号查询返回订单信息对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
    public ResponseResult<Object> queryEntity(@RequestParam(value="order_number") String order_number)throws Exception{
             ResponseResult<Object>result=new ResponseResult<>();
        try{
            result =carLoanInfoServiceFeign.queryEntity(order_number);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 取得单个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryEntityCarLoanMsg", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据订单编号查询返回车辆信息对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
    public ResponseResult<Object> queryEntityCarLoanMsg(@RequestParam(value="order_number") String order_number)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            result =carLoanMsgServiceFeign.queryEntity(order_number);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 取得单个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryEntityCarLoanUser", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据订单编号查询返回用户信息对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
    public ResponseResult<Object> queryEntityCarLoanUser(@RequestParam(value="order_number") String order_number)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            result =carLoanUserServiceFeign.queryEntity(order_number);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 取得单个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryEntityCarFileList", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据订单编号查询返回附件信息对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
    public ResponseResult<Object> queryEntityCarFileList(@RequestParam(value="order_number") String order_number)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            result =carLoanFileServiceFeign.queryEntity(order_number);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


    /**
     * 取得单个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryCarLoanSurveyContactsEntityList", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据订单编号查询返回联系人对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
    public ResponseResult<Object> queryCarLoanSurveyContactsEntity(@RequestParam(value="order_number") String order_number)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            result =carLoanSurveyContactsServicrfeign.queryEntityList(order_number);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


}
