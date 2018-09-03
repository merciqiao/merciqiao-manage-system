package com.car.modules.rest;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.car.modules.loan.carantifraudopnition.dto.CarAntifraudOpnitionDTO;
import com.car.modules.loan.carantifraudopnition.service.CarAntifraudOpnitionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/carAntifraudOpnition")
@Slf4j
@Api(tags={"反欺诈审核意见表"})
public class CarAntifraudOpnitionRest {


	@Autowired
	private CarAntifraudOpnitionService service;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<CarAntifraudOpnitionDTO> queryCarAntifraudOpnitionByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
		ResponseResult<CarAntifraudOpnitionDTO> result = new ResponseResult<>();
		try {
			CarAntifraudOpnitionDTO entity = service.queryCarAntifraudOpnitionByPrimaryKey(ID);
			result.setStatus(Status.SUCCESS);
			result.setData(entity);
			result.setMessage("查询成功");
			return result;
		} catch (Exception ex) {
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
	@RequestMapping(value = "/getCarAntifraudOpnitionList", method = RequestMethod.GET)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
	public ResponseResult<List<CarAntifraudOpnitionDTO>> queryCarAntifraudOpnitionList(@RequestParam("orderid") String orderid,@RequestParam("status") String status) throws Exception {
		ResponseResult<List<CarAntifraudOpnitionDTO>> result = new ResponseResult<>();
		try {
			CarAntifraudOpnitionDTO obj = new CarAntifraudOpnitionDTO();
			obj.setOrderNumber(orderid);
			obj.setValidateState(Short.parseShort("1"));
			List<CarAntifraudOpnitionDTO> entity = service.searchCarAntifraudOpnition(obj);
			for (CarAntifraudOpnitionDTO dto:entity) {
				if (dto.getOperation()==0&&status.equals("1")) {
					dto.setIsEdit("true");
				} else {
					dto.setIsEdit("false");
				}
			}
			result.setStatus(Status.SUCCESS);
			result.setData(entity);
			result.setMessage("查询成功");
			return result;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.setStatus(Status.FAILED);
			result.setMessage("执行异常,请重试");
			return result;

		}
	}


	/**
	 * 根据对象查询信息返回单个实体
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryLike", method = RequestMethod.POST)
	@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<CarAntifraudOpnitionDTO> queryLike(@RequestBody CarAntifraudOpnitionDTO obj) throws Exception {
		ResponseResult<CarAntifraudOpnitionDTO> result = new ResponseResult<>();
		try {
			CarAntifraudOpnitionDTO entity = service.queryLikeCarAntifraudOpnition(obj);
			result.setStatus(Status.SUCCESS);
			result.setData(entity);
			result.setMessage("查询成功");
			return result;
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
	@ResponseBody
	@RequestMapping(value = "/create/v1", method = RequestMethod.POST)
	@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult create(@RequestBody CarAntifraudOpnitionDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		obj.setValidateState((short)1);
		try {
			result.setData(service.insertCarAntifraudOpnition(obj));
			result.setStatus(Status.SUCCESS);
			result.setMessage("新增成功");
			return result;
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
	@RequestMapping(value = "/update/v1", method = RequestMethod.POST)
	@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult update(@RequestBody CarAntifraudOpnitionDTO obj) throws Exception {
		ResponseResult result = new ResponseResult();
		obj.setValidateState((short)1);
		try {
			if(service.updateCarAntifraudOpnition(obj)) {
				result.setStatus(Status.SUCCESS);
				result.setMessage("修改成功");
			}
			else
			{
				result.setStatus(Status.FAILED);
				result.setMessage("修改失败");
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