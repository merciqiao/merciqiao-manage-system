package com.carloan.service.admin.controller;

import com.carloan.api.model.admin.SysRoleParam;
import com.carloan.api.model.admin.SysRoleUserParam;
import com.carloan.api.model.admin.SysRoleUserVo;
import com.carloan.api.model.admin.SysRoleVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
//import com.carloan.feign.admin.SysRoleServicefeign;
//import com.carloan.feign.admin.SysRoleUserServicefeign;
import com.carloan.service.admin.rest.SysRoleRest;
import com.carloan.service.admin.rest.SysRoleUserRest;
import com.carloan.service.admin.sysrole.dto.SysRoleDTO;
import com.carloan.service.admin.sysroleuser.dto.SysRoleUserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/7/6.
 */

@RestController
@RequestMapping(value="/sysrole-api")
@Slf4j
@Api(tags = {"用户角色接口-hanxiaoyan"})
public class SysRoleController {
    @Autowired
    private SysRoleRest sysRolefeignservice;
    @Autowired
    private SysRoleUserRest sysRoleUserfeignservice;

    @ApiOperation(value="新增角色信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public ResponseResult<Object> addRole(@RequestBody SysRoleDTO vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            if(vo!=null&&vo.getId()>0)
            {
                if(vo.getValidateState()==null){
                vo.setValidateState("1");
                }
                vo.setVersion((long)1);
                result=sysRolefeignservice.update(vo);
            }
            else
            {
                vo.setValidateState("1");
                vo.setVersion((long)1);
                result=sysRolefeignservice.create(vo);
            }
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="获取角色对象",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/getSysRoleByid",method = RequestMethod.POST)
    public ResponseResult<SysRoleDTO> getSysRoleByid(@RequestParam("id") String id)throws Exception {
        ResponseResult<SysRoleDTO> result = new ResponseResult<>();
        try {

            result=sysRolefeignservice.querySysRoleByPrimaryKey(id);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="删除角色对象",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/deleteSysRoleByid",method = RequestMethod.POST)
    public ResponseResult<Object> deleteSysRoleByid(@RequestParam("id") String id)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result=sysRolefeignservice.deleteSysRolebyID(id);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="获取角色列表",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/querySysRoleList",method = RequestMethod.POST)
    public ResponseResult<Object> querySysRoleList(@RequestBody SysRoleParam vo)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {

            Object list =sysRolefeignservice.querySysRoleList(vo);
            result.setData(list);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="保存用户角色信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/saveRoleUser",method = RequestMethod.POST)
    public ResponseResult<SysRoleUserDTO> saveRoleUser(@RequestBody SysRoleUserDTO vo)throws Exception{
        ResponseResult<SysRoleUserDTO>result=new ResponseResult<>();
        try{
            if(vo!=null&&vo.getId()>0)
            {
                vo.setTargetType("user");
                vo.setValidateState("1");
                result=sysRoleUserfeignservice.update(vo);
            }
            else
            {
                vo.setTargetType("user");
                vo.setValidateState("1");
                result=sysRoleUserfeignservice.create(vo);
            }
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="获取角色用户列表",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/queryRoleUserList",method = RequestMethod.POST)
    public ResponseResult<Object> queryRoleUserList(@RequestBody SysRoleUserParam vo)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            Object list =sysRoleUserfeignservice.querySysRoleUserList(vo);
            result.setData(list);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="删除角色对象",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/deleteSysRoleUserByid",method = RequestMethod.POST)
    public ResponseResult<Object> deleteSysRoleUserByid(@RequestParam("id") String id)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result=sysRoleUserfeignservice.deleteSysRoleUserbyID(id);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}
