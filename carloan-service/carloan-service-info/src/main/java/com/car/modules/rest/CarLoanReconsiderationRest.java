package com.car.modules.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.car.modules.reqvo.ReqFuYiVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.car.modules.loan.carloanreconsideration.dto.CarLoanReconsiderationDTO;
import com.car.modules.loan.carloanreconsideration.service.CarLoanReconsiderationService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/carLoanReconsideration")
@Slf4j
@Api(tags={"车贷复议表"})
public class CarLoanReconsiderationRest {


@Autowired
private CarLoanReconsiderationService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<CarLoanReconsiderationDTO> queryCarLoanReconsiderationByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<CarLoanReconsiderationDTO>result=new ResponseResult<>();
			try{
				CarLoanReconsiderationDTO entity=service.queryCarLoanReconsiderationByPrimaryKey(ID);
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
	@RequestMapping(value = "/getCarLoanReconsiderationList", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<List<CarLoanReconsiderationDTO>> getCarLoanReconsiderationList(@RequestParam("ordernum") String ordernum)throws Exception{
			ResponseResult<List<CarLoanReconsiderationDTO>>result=new ResponseResult<>();
			try{
			List<CarLoanReconsiderationDTO> entity=service.getCarLoanReconsiderationList(ordernum);
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
		public ResponseResult create(@RequestBody ReqFuYiVo obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.insertCarLoanReconsideration(obj);
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
		public ResponseResult update(@RequestBody CarLoanReconsiderationDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				service.updateCarLoanReconsideration(obj);
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








}