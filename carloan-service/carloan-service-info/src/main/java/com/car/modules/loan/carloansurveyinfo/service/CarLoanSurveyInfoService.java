package com.car.modules.loan.carloansurveyinfo.service;
import com.car.modules.loan.carloansurveyinfo.dao.CarLoanSurveyInfoDao;
import com.car.modules.loan.carloansurveyinfo.dto.CarLoanSurveyInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanSurveyInfoService
 * @description: 定义  car_loan_survey_info 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloansurveyinfo.service.CarLoanSurveyInfoService")
public class CarLoanSurveyInfoService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanSurveyInfoDao dao;

	/**
     * @author root
     * @description: 分页查询 car_loan_survey_info列表
     * @date 2018-06-07 23:26:13
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanSurveyInfoDTO> searchCarLoanSurveyInfoByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanSurveyInfoDTO> dataList =  dao.searchCarLoanSurveyInfoByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询car_loan_survey_info列表
     * @date 2018-06-07 23:26:13
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanSurveyInfoDTO> searchCarLoanSurveyInfo(Map<String,Object> searchParams) throws Exception {
	    List<CarLoanSurveyInfoDTO> dataList = dao.searchCarLoanSurveyInfo(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询car_loan_survey_info对象
     * @date 2018-06-07 23:26:13
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanSurveyInfoDTO queryCarLoanSurveyInfoByPrimaryKey(String id) throws Exception {
		
		CarLoanSurveyInfoDTO dto = dao.findCarLoanSurveyInfoByPrimaryKey(id);
		
		if(dto == null) dto = new CarLoanSurveyInfoDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanSurveyInfo
     * @author root
     * @description: 新增 car_loan_survey_info对象
     * @date 2018-06-07 23:26:13
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanSurveyInfo(CarLoanSurveyInfoDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertCarLoanSurveyInfo(paramMap);
		
		CarLoanSurveyInfoDTO resultDto = (CarLoanSurveyInfoDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	public void updateCarLoanSurveyInfo(CarLoanSurveyInfoDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateCarLoanSurveyInfo(paramMap);
	}

	/**
	 * @author root
	 * @description: 查询car_loan_survey_info对象
	 * @date 2018-06-07 23:26:13
	 * @param survey_contacts_id
	 * @return
	 * @throws
	 */
	public CarLoanSurveyInfoDTO queryCarLoanSurveyInfoBySurveyContactsId(String survey_contacts_id) throws Exception {

		CarLoanSurveyInfoDTO dto = dao.queryCarLoanSurveyInfoBySurveyContactsId(survey_contacts_id);

		if(dto == null) dto = new CarLoanSurveyInfoDTO();

		return dto;

	}
	/**
	 * @author root
	 * @description: 查询car_loan_survey_info对象
	 * @date 2018-06-07 23:26:13
	 * @param order_number,survey_contacts_id
	 * @return
	 * @throws
	 */
	public CarLoanSurveyInfoDTO queryCarLoanSurveyInfoByOrderNumber(String order_number,String contactsInfo_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("order_number", order_number);
		paramMap.put("survey_contacts_id", contactsInfo_id);
		CarLoanSurveyInfoDTO dto = dao.queryCarLoanSurveyInfoByOrderNumber(paramMap);

		//if(dto == null) dto = new CarLoanSurveyInfoDTO();

		return dto;

	}
}

