package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.MyTaskVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.common.shiro.MyShiroRealm;
import com.carloan.feign.info.MyTaskServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018-07-09.
 */
@RestController
@RequestMapping(value="/myTask-api")
@Slf4j
@Api(tags = {"我的任务接口-jianghao"})
public class MyTaskCarController {
    @Autowired
    private MyTaskServiceFeign myTaskServiceFeign;


    @RequestMapping(value = "/findMyTaskTodoList", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取我的任务待审核的任务", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> findMyTaskTodoList(@RequestBody MyTaskVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            UserInfo userInfo= MyShiroRealm.getUserInfo();
            vo.setaSSIGNEE(userInfo.getUserId().toString());
            result =myTaskServiceFeign.findMyTaskTodoList(vo);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @RequestMapping(value = "/findMyTaskDonerList", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取我的任务待完成的任务", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> findMyTaskDonerList(@RequestBody MyTaskVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            UserInfo userInfo= MyShiroRealm.getUserInfo();
            vo.setaSSIGNEE(userInfo.getUserId().toString());
            result =myTaskServiceFeign.findMyTaskDonerList(vo);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @RequestMapping(value = "/findMyTaskEndList", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取我的任务已完成的任务", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> findMyTaskEndList(@RequestBody MyTaskVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            UserInfo userInfo= MyShiroRealm.getUserInfo();
            vo.setaSSIGNEE(userInfo.getUserId().toString());
            result =myTaskServiceFeign.findMyTaskEndList(vo);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}
