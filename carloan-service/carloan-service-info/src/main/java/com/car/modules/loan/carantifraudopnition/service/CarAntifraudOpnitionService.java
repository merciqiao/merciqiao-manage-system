
package com.car.modules.loan.carantifraudopnition.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.workflow.TransitionParam;
import com.carloan.feign.workflow.WorkFlowFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.car.modules.loan.carantifraudopnition.dto.CarAntifraudOpnitionDTO;
import com.car.modules.loan.carantifraudopnition.dao.CarAntifraudOpnitionDao;

/**
 * @classname: CarAntifraudOpnitionService
 * @description: 定义  反欺诈审核意见表 实现类
 * @author:  root
 */
@Service
public class CarAntifraudOpnitionService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CarAntifraudOpnitionDao dao;
	@Autowired
	private WorkFlowFeign workFlowfeiService;

	public List<CarAntifraudOpnitionDTO> searchCarAntifraudOpnitionByPaging(Map<String, Object> searchParams) throws Exception {
		List<CarAntifraudOpnitionDTO> dataList = dao.searchCarAntifraudOpnitionByPaging(searchParams);
		return dataList;
	}

	public List<CarAntifraudOpnitionDTO> searchCarAntifraudOpnition(CarAntifraudOpnitionDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		List<CarAntifraudOpnitionDTO> dataList = dao.searchCarAntifraudOpnition(paramMap);
		return dataList;
	}

	public CarAntifraudOpnitionDTO queryCarAntifraudOpnitionByPrimaryKey(String id) throws Exception {
		CarAntifraudOpnitionDTO dto = dao.findCarAntifraudOpnitionByPrimaryKey(id);
		if (dto == null) dto = new CarAntifraudOpnitionDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertCarAntifraudOpnition(CarAntifraudOpnitionDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		Long keyId=dto.getId();
		if(dto.getId()>0) {
			int count = dao.updateCarAntifraudOpnition(paramMap);
		}
		else
		{
			int count = dao.insertCarAntifraudOpnition(paramMap);
			CarAntifraudOpnitionDTO resultDto = (CarAntifraudOpnitionDTO) paramMap.get("dto");
			keyId = resultDto.getId();
		}
		if(dto.getOperation()==1) {
			if (dto.getProcessId() == null && dto.getProcessId().length() == 0 || dto.getTransition() == null || dto.getTransition().length() == 0) {
				throw new Exception("流程参数不完整");
			}
			//流程流转
			TransitionParam param = new TransitionParam();
			param.setTaskId(dto.getProcessId());
			param.setType(dto.getTransition());
			Response flowresult = new Response();
			flowresult = workFlowfeiService.doTransition_XinShen(param);
			if (!Response.isSucess(flowresult)) {
				throw new Exception("流程流转失败"+flowresult.getMessage());
			}

		}

		return keyId;
	}

	@Transactional(rollbackFor = {Exception.class})
	public Boolean updateCarAntifraudOpnition(CarAntifraudOpnitionDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int result = dao.updateCarAntifraudOpnition(paramMap);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public CarAntifraudOpnitionDTO queryLikeCarAntifraudOpnition(CarAntifraudOpnitionDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeCarAntifraudOpnition(paramMap);
	}

}

