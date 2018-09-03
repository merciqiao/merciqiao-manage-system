package com.car.modules.loan.carloancalphonelog.service;
import com.car.modules.loan.carloancalphonelog.dao.CarLoanCalPhoneLogDao;
import com.car.modules.loan.carloancalphonelog.dto.CarLoanCalPhoneLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanCalPhoneLogService
 * @description: 定义  car_loan_cal_phone_log 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloancalphonelog.service.CarLoanCalPhoneLogService")
public class CarLoanCalPhoneLogService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanCalPhoneLogDao dao;

	/**
     * @author root
     * @description: 分页查询 car_loan_cal_phone_log列表
     * @date 2018-06-07 23:29:04
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanCalPhoneLogDTO> searchCarLoanCalPhoneLogByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanCalPhoneLogDTO> dataList =  dao.searchCarLoanCalPhoneLogByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询car_loan_cal_phone_log列表
     * @date 2018-06-07 23:29:04
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanCalPhoneLogDTO> searchCarLoanCalPhoneLog(Map<String,Object> searchParams) throws Exception {
	    List<CarLoanCalPhoneLogDTO> dataList = dao.searchCarLoanCalPhoneLog(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询car_loan_cal_phone_log对象
     * @date 2018-06-07 23:29:04
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanCalPhoneLogDTO queryCarLoanCalPhoneLogByPrimaryKey(String id) throws Exception {
		
		CarLoanCalPhoneLogDTO dto = dao.findCarLoanCalPhoneLogByPrimaryKey(id);
		
		if(dto == null) dto = new CarLoanCalPhoneLogDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanCalPhoneLog
     * @author root
     * @description: 新增 car_loan_cal_phone_log对象
     * @date 2018-06-07 23:29:04
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanCalPhoneLog(CarLoanCalPhoneLogDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertCarLoanCalPhoneLog(paramMap);
		
		CarLoanCalPhoneLogDTO resultDto = (CarLoanCalPhoneLogDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateCarLoanCalPhoneLog
     * @author root
     * @description: 修改 car_loan_cal_phone_log对象
     * @date 2018-06-07 23:29:04
     * @return
     * @throws
     */
	public void updateCarLoanCalPhoneLog(CarLoanCalPhoneLogDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateCarLoanCalPhoneLog(paramMap);
	}
	public CarLoanCalPhoneLogDTO queryInfo(Map param) {
		CarLoanCalPhoneLogDTO dto = dao.queryInfo(param);
		return dto;
	}

	public List<CarLoanCalPhoneLogDTO> queryCarLoanCalPhoneLogInfoByParam(Map<String, Object> paramMap){
		return dao.queryCarLoanCalPhoneLogInfoByParam(paramMap);
	}
}

