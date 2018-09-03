package com.car.modules.workflow.jbpm4task.rest;

import java.util.List;


import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.workflow.TaskEventParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.car.modules.workflow.jbpm4task.dto.Jbpm4TaskDTO;
import com.car.modules.workflow.jbpm4task.service.Jbpm4TaskService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/jbpm4Task")
@Slf4j
@Api(tags = {"jbpm4_task"})
public class Jbpm4TaskRest {


    @Autowired
    private Jbpm4TaskService service;

    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Jbpm4TaskDTO> queryJbpm4TaskByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
        ResponseResult<Jbpm4TaskDTO> result = new ResponseResult<>();
        try {
            Jbpm4TaskDTO entity = service.queryJbpm4TaskByPrimaryKey(ID);
            result.setStatus(Status.SUCCESS);
            result.setData(entity);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


    /**
     * 取得List对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getJbpm4TaskList", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<List<Jbpm4TaskDTO>> queryJbpm4TaskList(@RequestBody Jbpm4TaskDTO obj) throws Exception {
        ResponseResult<List<Jbpm4TaskDTO>> result = new ResponseResult<>();
        try {
            List<Jbpm4TaskDTO> entity = service.searchJbpm4Task(obj);
            result.setStatus(Status.SUCCESS);
            result.setData(entity);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


    /**
     * 根据对象查询信息返回单个实体
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryLike", method = RequestMethod.POST)
    @ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Jbpm4TaskDTO> queryLike(@RequestBody Jbpm4TaskDTO obj) throws Exception {
        ResponseResult<Jbpm4TaskDTO> result = new ResponseResult<>();
        try {
            Jbpm4TaskDTO entity = service.queryLikeJbpm4Task(obj);
            result.setStatus(Status.SUCCESS);
            result.setData(entity);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 插入一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create/v1", method = RequestMethod.POST)
    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult create(@RequestBody Jbpm4TaskDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.insertJbpm4Task(obj);
            result.setStatus(Status.SUCCESS);
            result.setMessage("新增成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 修改一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult update(@RequestBody Jbpm4TaskDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.updateJbpm4Task(obj);
            result.setStatus(Status.SUCCESS);
            result.setMessage("修改成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    /**
     * 删除一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
    @ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult delete(@RequestBody Jbpm4TaskDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.deleteJbpm4TaskByID(obj);
            result.setStatus(Status.SUCCESS);
            result.setMessage("删除成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    /**
     * 更新完订单状态,写入任务表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/UpdateOrderState", method = RequestMethod.POST)
    @ApiOperation(value = "更新完订单状态,写入任务表", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public Response UpdateOrderState(@RequestBody TaskEventParam taskEventParam) throws Exception {
        Response result = new Response();
        try {
            boolean isWrite= service.UpdateOrderState(taskEventParam);
            if(isWrite){
                result.setStatus(Status.SUCCESS);
                result.setMessage("执行成功");
            }
            else{
                result.setStatus(Status.FAILED);
                result.setMessage("执行失败");
            }
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}