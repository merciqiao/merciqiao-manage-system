package com.carloan.service.admin.mayirecord.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.service.admin.mayirecord.entity.MayirecordEntity;
import com.carloan.service.admin.mayirecord.service.MayirecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:37:38
 */
@RestController
@Slf4j
@RequestMapping(value="/mayirecord-api")
public class MayirecordController {
	@Autowired
	private MayirecordService mayirecordService;

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Response add(@RequestBody MayirecordEntity vo)throws Exception{
		Response result=new Response();
		try{
			mayirecordService.save(vo);

			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}
	
}
