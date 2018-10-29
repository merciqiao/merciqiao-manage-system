package com.carloan.service.admin.controller;

import com.carloan.api.model.admin.SysRoleMappingParam;
import com.carloan.api.model.admin.SysRoleMappingVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
//import com.carloan.feign.admin.SysRoleMappingServicefeign;
import com.carloan.service.admin.rest.SysRoleMappingRest;
import com.carloan.service.admin.sysrolemapping.dto.SysRoleMappingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sysRoleMapping-api")
@Slf4j
@Api(tags = {"角色映射管理接口-hanxiaoyan"})
public class SysRoleMappingController {


    @Autowired
    private SysRoleMappingRest feiservice;


    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSysRoleMappingByid", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysRoleMappingDTO> querySysRoleMappingByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
        ResponseResult<SysRoleMappingDTO> result = new ResponseResult<>();
        try {
            return feiservice.querySysRoleMappingByPrimaryKey(ID);
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
    @RequestMapping(value = "/querySysRoleMappingList", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<Object> querySysRoleMappingList(@RequestBody SysRoleMappingParam obj) throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            Object list= feiservice.querySysRoleMappingList(obj);
            result.setData(list);
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
    @RequestMapping(value = "/Web/queryLike", method = RequestMethod.POST)
    @ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysRoleMappingDTO> queryLike(@RequestBody SysRoleMappingDTO obj) throws Exception {
        ResponseResult<SysRoleMappingDTO> result = new ResponseResult<>();
        try {
            return feiservice.queryLike(obj);
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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult insertSysRoleMapping(@RequestBody SysRoleMappingDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.create(obj);
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
    @RequestMapping(value = "/updateSysRoleMapping", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult updateSysRoleMapping(@RequestBody SysRoleMappingDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.update(obj);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/deleteSysRoleMapping", method = RequestMethod.POST)
    @ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")

    public ResponseResult deleteSysRoleMapping(@RequestParam("ids") String ids)
    {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.deleteSysRoleMapping(ids);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

}