package com.car.modules.jbpm.controller;

import com.car.modules.jbpm.dto.MyTaskDTO;
import com.car.modules.jbpm.service.MonitoringService;
import com.car.modules.jbpm.service.MyTaskService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2018-06-28.
 */
@RestController
@RequestMapping(value="/Monitoring-api")
@Slf4j
@Component
public class MonitoringController {
    @Autowired
    private MonitoringService monitoringService;
    @ApiOperation(value="获取业务流程监控待审核的任务",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findsearchMonitorTodo",method = RequestMethod.POST)
    public ResponseResult findsearchMonitorTodo(@RequestBody MyTaskDTO dto) throws Exception {
        ResponseResult result=new ResponseResult();
        try {

            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
            List<MyTaskDTO> list = monitoringService.searchMonitorTodoByPaging(searchParams);
            PageInfo<MyTaskDTO> pageInfo = new PageInfo(list);
            //result.setMessage(list.toArray().toString());
            result.setStatus(Status.SUCCESS);
            result.setDataList(pageInfo.getList());
            result.setCount( Integer.valueOf((int) pageInfo.getTotal()));
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
    @ApiOperation(value="获取业务流程监控待完成的任务",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findsearchMonitorTone",method = RequestMethod.POST)
    public ResponseResult findsearchMonitorTone(@RequestBody MyTaskDTO dto) throws Exception {
        ResponseResult result=new ResponseResult();
        try {

            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
            List<MyTaskDTO> list = monitoringService.searchMonitorToneByPaging(searchParams);
            PageInfo<MyTaskDTO> pageInfo = new PageInfo(list);
            result.setDataList(pageInfo.getList());
            result.setCount( Integer.valueOf((int) pageInfo.getTotal()));

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
    @ApiOperation(value="获取我业务流程监控已完成的任务",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findsearchMonitorEnd",method = RequestMethod.POST)
    public ResponseResult findsearchMonitorEnd(@RequestBody MyTaskDTO dto) throws Exception {
        ResponseResult result=new ResponseResult();
        try {

            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
            List<MyTaskDTO> list = monitoringService.searchMonitorEndByPaging(searchParams);
            PageInfo<MyTaskDTO> pageInfo = new PageInfo(list);
            result.setDataList(pageInfo.getList());
            result.setCount( Integer.valueOf((int) pageInfo.getTotal()));
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
