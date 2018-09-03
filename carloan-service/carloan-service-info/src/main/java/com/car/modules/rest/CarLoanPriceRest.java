package com.car.modules.rest;;

import java.util.List;
import java.util.Objects;


import com.alibaba.fastjson.JSONObject;
import com.car.modules.reqvo.ReqPriceVo;
import com.carloan.apimodel.order.CarLoanPriceParam;
import com.carloan.apimodel.order.CarLoanPriceVo;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.car.modules.loan.carloanprice.dto.CarLoanPriceDTO;
import com.car.modules.loan.carloanprice.service.CarLoanPriceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/carLoanPrice")
@Slf4j
@Api(tags={"定价审核意见表"})
public class CarLoanPriceRest {


	@Autowired
	private CarLoanPriceService service;
	@Autowired
	Mapper mapper;
	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> queryCarLoanPriceByPrimaryKey(@PathVariable("ID") String ID)throws Exception{
			ResponseResult<Object>result=new ResponseResult<>();
			try{
				CarLoanPriceDTO entity=service.queryCarLoanPriceByPrimaryKey(ID);
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
		 * 根据对象查询信息返回单个实体
		 *
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/queryLoanPriceinfo", method = RequestMethod.GET)
		@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
		public ResponseResult<List<CarLoanPriceDTO>> queryLoanPriceinfo(@RequestParam("ordernum") String ordernum,@RequestParam("status") String status)throws Exception {//@RequestParam("msg") String msg
			ResponseResult<List<CarLoanPriceDTO>> result = new ResponseResult<>();
			try {//mapperUtil.map(sysRoleDTOList,SysRole.class);
				CarLoanPriceDTO objdto = new CarLoanPriceDTO(); //mapper.map(obj, CarLoanPriceDTO.class);//(CarLoanPriceDTO) JSONObject.parseObject(obj.toString(), CarLoanPriceDTO.class);//
				objdto.setOrderNumber(ordernum);
				List<CarLoanPriceDTO> entity = service.searchCarLoanPrice(objdto);
				for (CarLoanPriceDTO dto:entity) {
					if (dto.getOperation()==0&&status.equals("1")) {
						dto.setIsEdit("true");
					} else {
						dto.setIsEdit("false");
					}
				}
				result.setStatus(Status.SUCCESS);
				result.setData(entity);
				//log.info(msg);
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
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/create/v1", method = RequestMethod.POST)
		@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult create(@RequestBody CarLoanPriceDTO obj)throws Exception {
			ResponseResult result = new ResponseResult();
			try {
				//CarLoanPriceDTO objdto = mapper.map(obj, CarLoanPriceDTO.class);
				result.setData(service.insertCarLoanPrice(obj));
				result.setStatus(Status.SUCCESS);
				result.setMessage("保存成功");
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
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/update/v1", method = RequestMethod.POST)
		@ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult update(@RequestBody CarLoanPriceDTO obj)throws Exception {
			ResponseResult result = new ResponseResult();
			try {
				//CarLoanPriceDTO objdto = mapper.map(obj, CarLoanPriceDTO.class);
				service.updateCarLoanPrice(obj);
				result.setStatus(Status.SUCCESS);
				result.setMessage("修改成功");
				return result;
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				result.setStatus(Status.FAILED);
				result.setMessage("执行异常,请重试");
				return result;
			}
		}

}