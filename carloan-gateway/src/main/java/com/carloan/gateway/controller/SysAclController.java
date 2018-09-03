package com.carloan.gateway.controller;
import java.util.List;


import com.carloan.api.model.admin.SysAclParam;
import com.carloan.api.model.admin.SysAclVo;
import com.carloan.feign.admin.SysAclServicefeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

/**
 *
 * 此接口为外部提供调用,通过注册中心获取相关业务接口标识，通过[feign]rest形式调用服务方接口
 */

@RestController
@RequestMapping(value = "/sysAcl-api")
@Slf4j
public class SysAclController {


    @Autowired
    private SysAclServicefeign feiservice;


    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySysAclByPrimaryKey", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> querySysAclByPrimaryKey(@RequestParam("ID") String ID) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            return feiservice.querySysAclByPrimaryKey(ID);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 取得List业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSysAclList", method = RequestMethod.POST)
    @ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> querySysAclList(@RequestBody SysAclParam obj) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            return feiservice.querySysAclList(obj);
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
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> queryLike(@RequestBody SysAclVo obj) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            return feiservice.queryLikeSysAcl(obj);
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
    @RequestMapping(value = "/insertSysAcl", method = RequestMethod.POST)
    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult insertSysAcl(@RequestBody SysAclVo obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.insertSysAcl(obj);
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
    @RequestMapping(value = "/Web/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult updateSysAcl(@RequestBody SysAclVo obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.updateSysAcl(obj);
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
    @RequestMapping(value = "/Web/delete/v1", method = RequestMethod.POST)
    @ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult deleteSysAcl(@RequestParam("ids") String ids) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            if(ids!=null&&!ids.equals(""))
            {
                feiservice.deleteSysAcl(ids);
                result.setMessage("修改成功");
                result.setStatus(Status.SUCCESS);
            }
            else
            {
                result.setMessage("修改失败");
                result.setStatus(Status.FAILED);
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