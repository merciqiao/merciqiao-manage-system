package com.carloan.service.admin.rest;
import java.util.List;


import com.carloan.api.model.admin.SysUserParam;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.shiro.UserInfoParam;
import com.carloan.common.utils.EncryptUtil;
import com.carloan.common.utils.MapperUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.admin.sysuser.dto.SysUserDTO;
import com.carloan.service.admin.sysuser.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/sysUser")
@Slf4j
@Api(tags={"sys_user"})
public class SysUserRest {


@Autowired
private SysUserService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<SysUserDTO> querySysUserByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<SysUserDTO>result=new ResponseResult<>();
			try{
				SysUserDTO entity=service.querySysUserByPrimaryKey(ID);
				result.setStatus(Status.SUCCESS);
				result.setData(entity);
				result.setMessage("查询成功");
				return result;
			}catch (Exception ex) {
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
	@RequestMapping(value = "/getSysUserList", method = RequestMethod.POST)
	@ApiOperation(value = "根据查询参数返回list", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public Object querySysUserList(@RequestBody SysUserParam obj)throws Exception {
		 return 	service.searchSysUser(obj);
	}
/**
 * 根据对象查询信息返回单个实体
 *
 * @return
 */
		@ResponseBody
		@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
		@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult<SysUserDTO> queryLike(@RequestBody SysUserDTO obj)throws Exception{
				ResponseResult<SysUserDTO>result=new ResponseResult<>();
				try{
				SysUserDTO entity=service.queryLikeSysUser(obj);
				result.setStatus(Status.SUCCESS);
				result.setData(entity);
				result.setMessage("查询成功");
				return result;
				}catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;

				}
				}

		/**
		 * 插入一个业务对象
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/create/v1", method = RequestMethod.POST)
		@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult create(@RequestBody SysUserDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.insertSysUser(obj);
				result.setStatus(Status.SUCCESS);
				result.setMessage("新增成功");
				return result;
				}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;

				}
				}
		/**
		 * 修改一个业务对象
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/update/v1", method = RequestMethod.POST)
		@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult update(@RequestBody SysUserDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.updateSysUser(obj);
				result.setStatus(Status.SUCCESS);
				result.setMessage("修改成功");
				return result;
				}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;
				}
				}
	/**
	 * 删除一个业务对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delSysUserByUserId", method = RequestMethod.POST)
	@ApiOperation(value = "删除用户列表中用户", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult delSysUserByUserId(@RequestParam("ids") String ids)throws Exception{
		ResponseResult result=new ResponseResult();
		try{
			if(ids!=null&&!ids.equals(""))
			{
				service.deleteSysUserByPrimaryKey(ids);
				result.setMessage("修改成功");
				result.setStatus(Status.SUCCESS);
			}
			else
			{
				result.setMessage("修改失败");
				result.setStatus(Status.FAILED);
			}
			return result;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}

	/**
	 * 修改密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkOldPassWord", method = RequestMethod.POST)
	@ApiOperation(value = "修改密码", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult checkOldPassWord(@RequestParam("LoginName") String LoginName,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword)throws Exception{
		ResponseResult result=new ResponseResult();

		try {

			SysUserDTO dto=new SysUserDTO();
			dto.setLoginName(LoginName);
			SysUserDTO entity=service.queryLikeSysUser(dto);
			if (entity != null && entity.getLoginName() != null && entity.getLoginName() != "") {
				String oldPassWordhash= EncryptUtil.encryptPwd(oldPassword);
				if (!oldPassWordhash.equals(entity.getPassword())) {
					result.setMessage("原始密码不正确");
					result.setStatus(Status.FAILED);
				} else {
					entity.setPassword(EncryptUtil.encryptPwd(newPassword));
					service.updateSysUser(entity);
					result.setMessage("修改成功");
					result.setStatus(Status.SUCCESS);
				}
			} else {

				result.setMessage("该用户名不存在");
				result.setStatus(Status.FAILED);
			}
			return result;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}


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
			SysUserDTO sysUserDTO= service.getUserInfoByLoginName(dto);
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

            LoginInfoVo loginInfoVo= service.getLoginInfoByUserId(userId);
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