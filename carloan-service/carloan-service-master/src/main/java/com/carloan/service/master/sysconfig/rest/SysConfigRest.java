package com.carloan.service.master.sysconfig.rest;

import java.util.List;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.master.sysconfig.dto.SysConfigDTO;
import com.carloan.service.master.sysconfig.service.SysConfigService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sysConfig")
@Slf4j
@Api(tags = {"sys_config"})
public class SysConfigRest {
    @Autowired
    private SysConfigService service;

    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysConfigDTO> querySysConfigByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
        ResponseResult<SysConfigDTO> result = new ResponseResult<>();
        try {
            SysConfigDTO entity = service.querySysConfigByPrimaryKey(ID);
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

    @ResponseBody
    @RequestMapping(value = "/getValueByCode/{code}", method = RequestMethod.POST)
    @ApiOperation(value = "根据编码获取值", notes = "", httpMethod = "POST")
    public ResponseResult<String> getValueByCode(@PathVariable("code") String code) throws Exception {
        ResponseResult<String> result = new ResponseResult<>();
        try {
            String entity = service.getValueByCode(code);
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
    @RequestMapping(value = "/getSysConfigList", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<List<SysConfigDTO>> querySysConfigList(@RequestBody SysConfigDTO obj) throws Exception {
        ResponseResult<List<SysConfigDTO>> result = new ResponseResult<>();
        try {
            PageInfo<SysConfigDTO> pageInfo = service.queryPage(obj);
            result.setData(pageInfo.getList());
            result.setCount((int) pageInfo.getTotal());
            result.setStatus(Status.SUCCESS);
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
    public ResponseResult create(@RequestBody SysConfigDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.insertSysConfig(obj);
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
    public ResponseResult update(@RequestBody SysConfigDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.updateSysConfig(obj);
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
     * 假删除
     */
    @ResponseBody
    @RequestMapping(value = "/deleteSysConfig/{ids}", method = RequestMethod.POST)
    @ApiOperation(value = "假删除", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult deleteSysConfig(@PathVariable("ids") String ids) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.deleteSysConfig(ids);
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

}