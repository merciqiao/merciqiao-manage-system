package com.car.modules.loan.carloanlog.service;

import com.car.modules.loan.carloanlog.dao.CarLoanLogDao;
import com.car.modules.loan.carloanlog.dto.CarLoanLogDTO;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.common.web.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanLogService
 * @description: 定义  CAR_LOAN_LOG 实现类
 * @author:  Administrator
 */
@Service("com.car.modules.loan.carloanlog.service.CarLoanLogService")
public class CarLoanLogService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanLogDao dao;

	/**
     * @author Administrator
     * @description: 分页查询 CAR_LOAN_LOG列表
     * @date 2018-05-24 16:24:05
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanLogDTO> searchCarLoanLogByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanLogDTO> dataList =  dao.searchCarLoanLogByPaging(searchParams);
		return dataList;
	}
	/**
     * @author Administrator
     * @description: 按条件查询CAR_LOAN_LOG列表
     * @date 2018-05-24 16:24:05
     * @param searchParams 条件
     * @return
     * @throws
     */
	@Page
	public Object searchCarLoanLog(CarLoanLogDTO carLoanLogDTO) throws Exception {
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("dto",carLoanLogDTO);
		List<CarLoanLogDTO> dataList = dao.searchCarLoanLog(searchParams);
        return dataList;
    }
	/**
     * @author Administrator
     * @description: 查询CAR_LOAN_LOG对象
     * @date 2018-05-24 16:24:05
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanLogDTO queryCarLoanLogByPrimaryKey(String id) throws Exception {
		
		CarLoanLogDTO dto = dao.findCarLoanLogByPrimaryKey(id);
		
		if(dto == null) dto = new CarLoanLogDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanLog
     * @author Administrator
     * @description: 新增 CAR_LOAN_LOG对象
     * @date 2018-05-24 16:24:05
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanLog(String orderNumber,String operationAction,String reqJson,String errJson) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		CarLoanLogDTO dto = new CarLoanLogDTO();
		dto.setOperationAction(operationAction);
		dto.setOrderNumber(orderNumber);
		dto.setReqJson(reqJson);
		dto.setErrJson(errJson);
		paramMap.put("dto", dto);
		int count = dao.insertCarLoanLog(paramMap);
		CarLoanLogDTO resultDto = (CarLoanLogDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateCarLoanLog
     * @author Administrator
     * @description: 修改 CAR_LOAN_LOG对象
     * @date 2018-05-24 16:24:05
     * @param paramMap
     * @return
     * @throws
     */
	public void updateCarLoanLog(CarLoanLogDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateCarLoanLog(paramMap);
	}

}

