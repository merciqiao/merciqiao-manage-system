package com.carloan.service.admin.controller;

import java.util.List;
import java.util.Map;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.service.admin.loginlog.dto.LoginlogEntity;
import com.carloan.service.admin.loginlog.service.LoginlogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;



/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-01 22:54:18
 */
@RestController
@RequestMapping(value="/loginlog-api")
@Slf4j
public class LoginlogController {
	@Autowired
	private LoginlogService loginlogService;
	

	/**
	 * 保存
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public Response save(@RequestBody LoginlogEntity loginlog){
		Response result = new Response();
		try {
			loginlogService.save(loginlog);
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}

	}
	/**
	 * 还原
	 */
	@RequestMapping(value = "/rollBackTables",method = RequestMethod.POST)
	public Response rollBackTables(){
		Response result = new Response();
		try {
			loginlogService.rollBackTables();
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}

	}

	
}
