package com.carloan.service.admin.controller;

import com.carloan.api.model.admin.SysUserParam;
import com.carloan.api.model.admin.SysUserVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.common.utils.EncryptUtil;
//import com.carloan.feign.admin.SysUserServicefeign;
import com.carloan.service.admin.rest.SysUserRest;
import com.carloan.service.admin.sysuser.dto.SysUserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/7/6.
 */
@RestController
@RequestMapping(value="/sysuser-api")
@Slf4j
@Api(tags = {"用户信息接口-hanxiaoyan"})
public class SysUserController {
    @Autowired
    private SysUserRest sysUserfeignservice;
    @ApiOperation(value="新增用户信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseResult<Object> addUser(@RequestBody SysUserDTO vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        vo.setPassword(EncryptUtil.encryptPwd(vo.getPassword()));
        vo.setValidateState("1");
        try{
            if(vo!=null&&vo.getId()>0)
            {
                if(vo.getIsLocked().equals("0"))
                {
                    vo.setPassword("");
                }
                result=sysUserfeignservice.update(vo);
            }
            else
            {
                result=sysUserfeignservice.create(vo);
            }
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="查询用户信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/querySysUser",method = RequestMethod.POST)
    public ResponseResult<SysUserDTO> querySysUser(@RequestParam("id") String id)throws Exception {
        ResponseResult<SysUserDTO> result = new ResponseResult<>();
        try {
            if(id!=null && id.length()!=0) {

                result = sysUserfeignservice.querySysUserByPrimaryKey(id);
            }
            else
            {
                result.setStatus(Status.FAILED);
                result.setMessage("执行异常,参数不完整");
            }
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="查询用户列表",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/querySysUserList",method = RequestMethod.POST)
    public Object querySysUserList(@RequestBody SysUserParam vo)throws Exception {
        Object result = new ResponseResult<>();
        try {

            result =sysUserfeignservice.querySysUserList(vo);

            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return result;

        }
    }
    @ApiOperation(value="删除用户列表中用户",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/delSysUserByUserId",method = RequestMethod.POST)
    public ResponseResult<Object> delSysUserByUserId(@RequestParam("ids") String ids)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {


            if(ids!=null&&!ids.equals(""))
            {
                sysUserfeignservice.delSysUserByUserId(ids);
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
    @ApiOperation(value="修改密码",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/checkOldPassWord",method = RequestMethod.POST)
    public ResponseResult<Object> checkOldPassWord(@RequestParam("LoginName") String LoginName,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {


            if(LoginName!=null&&!LoginName.equals(""))
            {
                result= sysUserfeignservice.checkOldPassWord(LoginName,oldPassword,newPassword);
            }
            else
            {
                result.setMessage("用户名不能为空");
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
