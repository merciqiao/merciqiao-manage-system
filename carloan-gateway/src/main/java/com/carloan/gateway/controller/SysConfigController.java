package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.master.SysConfigVo;
import com.carloan.feign.master.feign.SysConfigServicefeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sysConfig-api")
@Slf4j
@Api(tags = {"系统配置-xiao"})
public class SysConfigController {
    @Autowired
    private SysConfigServicefeign feiservice;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "参数:configCode,configName,configType,configValue", httpMethod = "POST")
    public ResponseResult add(@RequestBody SysConfigVo obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.insertSysConfig(obj);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改", notes = "参数:id,configCode,configName,configType,configValue", httpMethod = "POST")
    public ResponseResult update(@RequestBody SysConfigVo obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            if (obj.getId() == 0) {
                result.setStatus(Status.FAILED);
                result.setMessage("id为0");
                return result;
            }
            return feiservice.updateSysConfig(obj);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    /**
     * 假删除
     */
    @ResponseBody
    @RequestMapping({"/del/{ids}"})
    @ApiOperation(value = "删除", notes = "参数:id的字符串，如\"1\"、\"1,2,3\"", httpMethod = "POST")
    public ResponseResult del(@PathVariable("ids") String ids) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.deleteSysConfig(ids);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "参数:configCode,configName,configType,configValue,currentPage,pageSize", httpMethod = "POST")
    public ResponseResult<List<SysConfigVo>> queryPage(@RequestBody SysConfigVo obj) throws Exception {
        ResponseResult<List<SysConfigVo>> result = new ResponseResult<>();
        try {
            return feiservice.querySysConfigList(obj);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "查询对象根据id", notes = "", httpMethod = "POST")
    public ResponseResult<Object> getById(@PathVariable("id") String id) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            return feiservice.querySysConfigByPrimaryKey(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    @ResponseBody
    @RequestMapping(value = "/getValueByCode/{code}", method = RequestMethod.POST)
    @ApiOperation(value = "根据编码获取值", notes = "", httpMethod = "POST")
    public ResponseResult<String> getValueByCode(@PathVariable("code") String code) throws Exception {
        ResponseResult<String> result = new ResponseResult<>();
        try {
            return feiservice.getValueByCode(code);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}
