package com.carloan.service.admin.msg.controller;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.service.admin.msg.entity.MsgEntity;
import com.carloan.service.admin.msg.entity.MsgListEntity;
import com.carloan.service.admin.msg.groups.MsgAddGroup;
import com.carloan.service.admin.msg.groups.MsgUpdateGroup;
import com.carloan.service.admin.msg.service.MsgService;
import com.carloan.service.admin.msg.vo.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-12-15 22:29:54
 */
@RestController
@Slf4j
@RequestMapping("/msg-api")
public class MsgController {
	@Autowired
	private MsgService msgService;

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Response add(@RequestBody MsgEntity vo)throws Exception{
		Response result=new Response();
		try{
			msgService.save(vo);
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}
	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	public ResponseResult<MsgVO> queryList(@RequestBody MsgEntity vo)throws Exception{
		ResponseResult<MsgVO> result=new ResponseResult<>();
		try{
			result= (ResponseResult<MsgVO>)msgService.queryList(vo);
			return result;
		}catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}
}
