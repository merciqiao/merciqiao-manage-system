package com.car.modules.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.car.modules.loan.carloanopinion.dto.CarLoanOpinionDTO;
import com.car.modules.loan.carloanopinion.service.CarLoanOpinionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/carLoanOpinion")
@Slf4j
@Api(tags={"初审终审(审核意见表)"})
public class CarLoanOpinionRest {


@Autowired
private CarLoanOpinionService service;
	@Autowired
	private CarLoanInfoService carLoanInfoService;

	/**
	 * 取得单个业务对象
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
	@ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult<Object> queryCarLoanOpinionByPrimaryKey(@PathVariable("ID") String ID)throws Exception {
		ResponseResult<Object> result = new ResponseResult<>();
		try {
			CarLoanOpinionDTO entity = service.queryCarLoanOpinionByPrimaryKey(ID);
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
		@RequestMapping(value = "/queryLike", method = RequestMethod.GET)
		@ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
		public ResponseResult<Object> queryLike(@RequestParam("ordernum") String ordernum,@RequestParam("actName") String actName,@RequestParam("status") String status)throws Exception {
			ResponseResult<Object> result = new ResponseResult<>();
			try {
				//CarLoanOpinionDTO entity=service.queryLikeCarLoanOpinion(obj);
				CarLoanOpinionDTO obj=new CarLoanOpinionDTO();
				obj.setOrderNumber(ordernum);
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("dto", obj);
				List<CarLoanOpinionDTO> entity = service.searchCarLoanOpinion(paramMap);
				for (CarLoanOpinionDTO dto:entity) {
					if (dto.getCurrentExaminationPost().equals(actName)&&status.equals("1")&&dto.getOperation()==0) {
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
		 * 插入一个业务对象
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/create/v1", method = RequestMethod.POST)
		@ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
		public ResponseResult create(@RequestBody CarLoanOpinionDTO obj)throws Exception{
				ResponseResult result=new ResponseResult();
				try{
				Long key=service.insertCarLoanOpinion(obj);
				result.setData(key+"");
				if(key>0&&obj.getTransition()=="同意"&&obj.getOperation()==1) {
					CarLoanInfoDTO carloan = new CarLoanInfoDTO();
					carloan.setId(obj.getCarInfoId());
					carloan.setApprovalAmount(obj.getContractAmount());
					carloan.setApprovalTerm(obj.getApprovalPeriod());
					carloan.setApprovalProductType(obj.getProductType());
					carLoanInfoService.updateCarLoanInfoAuditInfo(carloan);
				}
				result.setStatus(Status.SUCCESS);
				result.setMessage("保存成功");
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
		public ResponseResult update(@RequestBody CarLoanOpinionDTO obj)throws Exception {
			ResponseResult result = new ResponseResult();
			try {
				service.updateCarLoanOpinion(obj);
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