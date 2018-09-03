package com.carloan.gateway.controller;

/**
 * Created by Administrator on 2018-07-26.
 */
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.MyTaskVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.common.shiro.MyShiroRealm;
import com.carloan.feign.info.MonitoringFeign;
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
@RequestMapping(value="/Monitoring-api")
@Slf4j
@Api(tags = {"业务流程监控-jianghao"})
public class MonitoringController {
    @Autowired
    private MonitoringFeign monitoringFeign;


    @RequestMapping(value = "/findsearchMonitorTodo", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取业务流程监控待审核的任务", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> findMyTaskTodoList(@RequestBody MyTaskVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            UserInfo userInfo= MyShiroRealm.getUserInfo();
            vo.setaSSIGNEE(userInfo.getUserId().toString());
            result =monitoringFeign.findsearchMonitorTodo(vo);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @RequestMapping(value = "/findsearchMonitorTone", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取业务流程监控待完成的任务", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> findsearchMonitorTone(@RequestBody MyTaskVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            UserInfo userInfo= MyShiroRealm.getUserInfo();
            vo.setaSSIGNEE(userInfo.getUserId().toString());
            result =monitoringFeign.findsearchMonitorTone(vo);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @RequestMapping(value = "/findsearchMonitorEnd", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取我业务流程监控已完成的任务", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> findsearchMonitorEnd(@RequestBody MyTaskVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            UserInfo userInfo= MyShiroRealm.getUserInfo();
            vo.setaSSIGNEE(userInfo.getUserId().toString());
            result =monitoringFeign.findsearchMonitorEnd(vo);
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}

