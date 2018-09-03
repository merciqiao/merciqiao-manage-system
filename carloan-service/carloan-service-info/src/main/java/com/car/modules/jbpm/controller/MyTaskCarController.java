package com.car.modules.jbpm.controller;

import com.car.modules.jbpm.dto.MyTaskDTO;
import com.car.modules.jbpm.service.MyTaskService;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2018-06-28.
 */
@RestController
@RequestMapping(value="/myTask-api")
@Slf4j
@Component
public class MyTaskCarController {
    @Autowired
    private MyTaskService workFileService;
    @ApiOperation(value="获取我的任务待审核的任务",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findMyTaskTodoList",method = RequestMethod.POST)
    public ResponseResult findMyTaskTodoList(@RequestBody MyTaskDTO dto) throws Exception {
        ResponseResult result=new ResponseResult();
        try {

            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
            List<MyTaskDTO> list = workFileService.searchCarMyTodoTaskByPaging(searchParams);
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
    @ApiOperation(value="获取我的任务待完成的任务",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findMyTaskDonerList",method = RequestMethod.POST)
    public ResponseResult findMyTaskDonerList(@RequestBody MyTaskDTO dto) throws Exception {
        ResponseResult result=new ResponseResult();
        try {

            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
            List<MyTaskDTO> list = workFileService.searchCaDonerMyTaskByPaging(searchParams);
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
    @ApiOperation(value="获取我的任务已完成的任务",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findMyTaskEndList",method = RequestMethod.POST)
    public ResponseResult findMyTaskEndList(@RequestBody MyTaskDTO dto) throws Exception {
        ResponseResult result=new ResponseResult();
        try {

            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
            List<MyTaskDTO> list = workFileService.searchCarEndMyTaskByPaging(searchParams);
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
    @ApiOperation(value="更新信审开始时间和结束时间",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateCarStartEndTime",method = RequestMethod.POST)
    public ResponseResult updateCarStartEndTime(@RequestParam("inid") String inid) throws Exception {
        ResponseResult result=new ResponseResult();
        try {

            if(inid!=null&&!inid.equals(""))
            {
                Map<String, Object> searchParams = new HashMap<String, Object>();
                searchParams.put("in_id", inid);
                workFileService.updateCarStartEndTime(searchParams);
                result.setStatus(Status.SUCCESS);
                result.setMessage("修改成功");
            }
            else
            {
                result.setStatus(Status.FAILED);
                result.setMessage("修改失败");
            }
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
