package com.carloan.gateway.controller;


import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.order.CarAntifraudOpnitionVo;
import com.carloan.apimodel.order.CarAuditState;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.apimodel.workflow.TransitionParam;
import com.carloan.common.shiro.MyShiroRealm;
import com.carloan.feign.info.CarAntifraudOpnitionServicefeign;
import com.carloan.feign.workflow.WorkFlowFeign;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 *
 * 此接口为外部提供调用,通过注册中心获取相关业务接口标识，通过[feign]rest形式调用服务方接口
 */

@RestController
@RequestMapping(value="/antifraudOpnition-api")
@Slf4j
@Api(tags = {"反欺诈审核接口-hanxiaoyan"})
public class AntifraudOpnitionController {


	@Autowired
	private CarAntifraudOpnitionServicefeign feiservice;
	@Autowired
	private WorkFlowFeign workFlowfeiService;


	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ApiOperation(value="根据主键ID查询反欺诈信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
	@RequestMapping(value = "/queryAntifraudOpnitionByID",method = RequestMethod.POST)
	public ResponseResult<Object> queryCarAntifraudOpnitionByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<Object> result = new ResponseResult<>();
		try {
			return feiservice.queryCarAntifraudOpnitionByPrimaryKey(ID);
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
	@ApiOperation(value="根据订单编号查询反欺诈审核意见列表",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "GET")
	@RequestMapping(value = "/queryCarAntifraudOpnitionList",method = RequestMethod.GET)
	public ResponseResult<Object> queryCarAntifraudOpnitionList(@RequestParam("ordernum") String ordernum,@RequestParam("status") String status) throws Exception {
		ResponseResult<Object> result = new ResponseResult<>();
		try {
			return feiservice.queryCarAntifraudOpnitionList(ordernum,status);
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
	@ApiOperation(value="保存反欺诈审核意见id：0新增，否则更新",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
	@RequestMapping(value = "/saveAntifraudOpnition",method = RequestMethod.POST)
	public ResponseResult saveAntifraudOpnition(@RequestBody CarAntifraudOpnitionVo obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			UserInfo curuser= MyShiroRealm.getUserInfo();
			obj.setApprover(curuser.getUserId().toString());
			String conclusion=obj.getTransition();
			String transition="";
			if(conclusion.equals("欺诈"))
			{
				obj.setAuditState(CarAuditState.CAR_AUDIT_2600.getKey());
				transition="欺诈";
			}
			else  if(conclusion.equals("非欺诈"))
			{
				obj.setAuditState(CarAuditState.CAR_AUDIT_2300.getKey());
				transition="非欺诈";
			}
			else  if(conclusion.equals("回退"))
			{
				obj.setAuditState(CarAuditState.CAR_AUDIT_2300.getKey());
				transition="回退";
			}
			obj.setTransition(transition);

//			if(obj!=null && obj.getId()>0)
//			{
//				obj.setUpdateTime(new Date());
//				result= feiservice.updateCarAntifraudOpnition(obj);
//			}
//			else
//			{
//				obj.setCreateTime(new Date());
//				obj.setUpdateTime(new Date());
//				result= feiservice.insertCarAntifraudOpnition(obj);
//			}
            return feiservice.insertCarAntifraudOpnition(obj);

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
	@RequestMapping(value = "/Web/update/v1", method = RequestMethod.POST)
	@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult updateCarAntifraudOpnition(@RequestBody CarAntifraudOpnitionVo obj) throws Exception {
		ResponseResult result = new ResponseResult();
		try {
			return feiservice.updateCarAntifraudOpnition(obj);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;
		}
	}

}