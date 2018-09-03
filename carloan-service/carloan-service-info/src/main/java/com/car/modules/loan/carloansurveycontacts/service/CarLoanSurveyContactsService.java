package com.car.modules.loan.carloansurveycontacts.service;

import com.car.modules.loan.carloancalphonelog.service.CarLoanCalPhoneLogService;
import com.car.modules.loan.carloansurveycontacts.dao.CarLoanSurveyContactsDao;
import com.car.modules.loan.carloansurveycontacts.dto.CarLoanSurveyContactsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanSurveyContactsService
 * @description: 定义  car_loan_survey_contacts 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloansurveycontacts.service.CarLoanSurveyContactsService")
public class CarLoanSurveyContactsService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private CarLoanSurveyContactsDao dao;


	@Autowired
	@Qualifier("com.car.modules.loan.carloancalphonelog.service.CarLoanCalPhoneLogService")
	private CarLoanCalPhoneLogService carLoanCalPhoneLogService;
	/**
     * @author root
     * @description: 分页查询 car_loan_survey_contacts列表
     * @date 2018-06-10 21:57:13
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanSurveyContactsDTO> searchCarLoanSurveyContactsByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanSurveyContactsDTO> dataList =  dao.searchCarLoanSurveyContactsByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询car_loan_survey_contacts列表
     * @date 2018-06-10 21:57:13
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanSurveyContactsDTO> searchCarLoanSurveyContacts(Map<String,Object> searchParams ) throws Exception {
	    List<CarLoanSurveyContactsDTO> dataList = dao.searchCarLoanSurveyContacts(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询car_loan_survey_contacts对象
     * @date 2018-06-10 21:57:13
     * @param id
     * @return
     * @throws
     */
	public CarLoanSurveyContactsDTO queryCarLoanSurveyContactsByPrimaryKey(String id) throws Exception {

		CarLoanSurveyContactsDTO dto = dao.findCarLoanSurveyContactsByPrimaryKey(id);

		if(dto == null) dto = new CarLoanSurveyContactsDTO();

		return dto;

	}

	/**
     * @title: insertCarLoanSurveyContacts
     * @author root
     * @description: 新增 car_loan_survey_contacts对象
     * @date 2018-06-10 21:57:13
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanSurveyContacts(CarLoanSurveyContactsDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);

		int count = dao.insertCarLoanSurveyContacts(paramMap);

		CarLoanSurveyContactsDTO resultDto = (CarLoanSurveyContactsDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateCarLoanSurveyContacts
     * @author root
     * @description: 修改 car_loan_survey_contacts对象
     * @date 2018-06-10 21:57:13
     * @param dto
     * @return
     * @throws
     */
	public void updateCarLoanSurveyContacts(CarLoanSurveyContactsDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);

		dao.updateCarLoanSurveyContacts(paramMap);
	}

	public List<CarLoanSurveyContactsDTO>  querySurveyContactsInfoByOrderNum(String orderNuber){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderNumber", orderNuber);
		return dao.querySurveyContactsInfoByOrderNum(paramMap);
	}


	/**
	 * @title: insertCarLoanSurveyContactsList
	 * @author root
	 * @description: 循环添加客户原始联系人
	 * @param list
	 * @return
	 * @throws
	 */
	public void insertCarLoanSurveyContactsList(List<CarLoanSurveyContactsDTO> list) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("list", list);
		dao.insertCarLoanSurveyContactsList(paramMap);
	}

}

