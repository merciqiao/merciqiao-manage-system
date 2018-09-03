package com.carloan.service.shiro.sysuser.controller;


import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.shiro.UserInfoParam;
import com.carloan.common.utils.MapperUtil;
import com.carloan.service.shiro.sysuser.dto.SysUserDTO;
import com.carloan.service.shiro.sysuser.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


/**
 * @classname: SysUserController
 * @description: 定义  sys_user 控制层
 * @author:  root
 */
@RestController
@RequestMapping(value="/shiro-api")
@Slf4j
@Component
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    MapperUtil mapper;
    @ApiOperation(value="根据username查询用户信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfoByLoginName",method = RequestMethod.POST)
    public ResponseResult<UserInfo> getUserInfoByLoginName(@RequestBody UserInfoParam userInfoParam) throws Exception {
        ResponseResult<UserInfo> result = new ResponseResult<>();
        try {
            UserInfo userInfo=null;
            SysUserDTO dto=new SysUserDTO();
            dto.setLoginName(userInfoParam.getLoginName());
            SysUserDTO sysUserDTO= sysUserService.getUserInfoByLoginName(dto);
            userInfo=mapper.map(sysUserDTO,UserInfo.class);
            result.setStatus(Status.SUCCESS);
            result.setData(userInfo);
            result.setMessage("查询成功");

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    @ApiOperation(value="根据userid查询登陆信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/getLoginInfoByUserId",method = RequestMethod.POST)
    public ResponseResult<LoginInfoVo> getLoginInfoByUserId(@RequestParam String userId) throws Exception {
        ResponseResult<LoginInfoVo> result = new ResponseResult<>();
        try {

            LoginInfoVo loginInfoVo= sysUserService.getLoginInfoByUserId(userId);
            result.setData(loginInfoVo);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");

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
