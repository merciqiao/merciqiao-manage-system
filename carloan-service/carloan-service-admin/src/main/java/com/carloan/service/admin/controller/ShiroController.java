package com.carloan.service.admin.controller;


import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.shiro.UserInfoParam;
import com.carloan.common.utils.EncryptUtil;
import com.carloan.common.utils.MapperUtil;
//import com.carloan.feign.admin.SysUserServicefeign;
import com.carloan.service.admin.rest.SysUserRest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

//import com.carloan.feign.shiro.SysUserServiceFeign;

@RestController
@RequestMapping(value="/shiro-api")
@Slf4j
@Api(tags = {"登录接口-qiaolixue"})
public class ShiroController {
//    @Autowired
//    SysUserServiceFeign sysUserServiceFeign;
    @Autowired
    private SysUserRest sysUserServiceFeign;
    @Autowired
    MapperUtil mapperUtil;
    @ApiOperation(value="登陆",notes="测试账户:PC0002952,密码:123456,返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseResult<LoginInfoVo> login(@RequestBody UserInfoParam userInfoParam) throws Exception {
        ResponseResult<LoginInfoVo> result = new ResponseResult<>();
        try {
            LoginInfoVo loginInfoVo=new LoginInfoVo();
            String loginName=userInfoParam.getLoginName();
//            String passWord="123456";//前端加密了
            String passWord=userInfoParam.getPassword();
            Subject subject = SecurityUtils.getSubject();
            //subject.logout();
            //加密
            String encryptPwd= EncryptUtil.encryptPwd(passWord);
            UsernamePasswordToken token = new UsernamePasswordToken(loginName,encryptPwd);
            String message="";
            try {
                subject.login(token);
                message="登陆成功";
                log.info(message);
                //设置用户信息
                UserInfo userInfo=new UserInfo();
                BeanUtils.copyProperties(subject.getPrincipal(),userInfo);

                userInfo.setPassword(null);
                userInfo.setSalt(null);
                userInfo.setToken(subject.getSession().getId().toString());
                loginInfoVo.setUserInfo(userInfo);
                ResponseResult<LoginInfoVo> response= sysUserServiceFeign.getLoginInfoByUserId(userInfo.getUserId().toString());
                if(ResponseResult.isSucess(response)){
                    LoginInfoVo loginInfoDTO=response.getData();
                    loginInfoVo.setSysRoleVoList(loginInfoDTO.getSysRoleVoList());
                    loginInfoVo.setRolePermissionVoList(loginInfoDTO.getRolePermissionVoList());
                    loginInfoVo.setSysMenuVoList(loginInfoDTO.getSysMenuVoList());
                }
                else{
                    String errorMsg=MessageFormat.format("login.getLoginInfoByUserId.error,userid:{0}",userInfo.getUserId().toString());
                    log.error(errorMsg);
                    throw new Exception(errorMsg);
                }

                result.setData(loginInfoVo);
                result.setStatus(Status.SUCCESS);
            } catch (IncorrectCredentialsException e) {
                result.setStatus(Status.FAILED);
                message="密码错误";
                log.info(message);
            } catch (LockedAccountException e) {
                result.setStatus(Status.FAILED);
                message="登录失败，该用户已被冻结";
                log.info(message);
                log.error(e.getMessage(),e);
            } catch (AuthenticationException e) {
                result.setStatus(Status.FAILED);
                message="该用户不存在";
                log.info("该用户不存在");
            } catch (Exception e) {
                result.setStatus(Status.FAILED);
                message="登录异常";
                log.error(message);
                log.error(e.getMessage(),e);
            }
            result.setMessage(message);
            //SecurityUtils.getSubject().getSession().setTimeout(shiroRedis.getExpiretime());
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }

    /**
     * 未登录
     * @return
     */
    @ApiOperation(value="未登录",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/unlogin",method = {RequestMethod.POST,RequestMethod.GET})
    public Response unlogin() {
        Response result=new Response();
        result.setMessage("未登录");
        result.setStatus(Status.FAILED);
        return result;
    }

    /**
     * 未授权
     * @return
     */
    @ApiOperation(value="未授权",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/unauth",method = {RequestMethod.POST,RequestMethod.GET})
    public Response unauth() {
        Response result=new Response();
        result.setMessage("未授权");
        result.setStatus(Status.FAILED);
        return result;
    }

    /**
     * 退出登录
     * @return
     */
    @ApiOperation(value="退出登录",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/loginout",method = {RequestMethod.POST,RequestMethod.GET})
    public Response logout() {
        Response result=new Response();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            result.setMessage("退出登录");
            result.setStatus(Status.SUCCESS);
            return result;
        }
        catch (Exception ex){
            result.setMessage("退出失败");
            result.setStatus(Status.FAILED);
            return result;
        }
    }

    /**
     * 退出登录
     * @return
     */
    @ApiOperation(value="测试权限",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/test",method = {RequestMethod.POST,RequestMethod.GET})
    @RequiresPermissions("workfile/queryCreditIntoInfo:exportExcel")
    public Response test() {
        Response result=new Response();
        result.setMessage("测试权限通过");
        result.setStatus(Status.SUCCESS);
        return result;
    }

}
