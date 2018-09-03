package com.car.modules.loan.carloanrichtext.service;

import com.car.modules.loan.carloanrichtext.dao.CarLoanRichTextDao;
import com.car.modules.loan.carloanrichtext.dto.CarLoanRichTextDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanRichTextService
 * @description: 定义  car_loan_rich_text 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloanrichtext.service.CarLoanRichTextService")
public class CarLoanRichTextService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanRichTextDao dao;

	/**
     * @author root
     * @description: 分页查询 car_loan_rich_text列表
     * @date 2018-06-08 21:13:03
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanRichTextDTO> searchCarLoanRichTextByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanRichTextDTO> dataList =  dao.searchCarLoanRichTextByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询car_loan_rich_text列表
     * @date 2018-06-08 21:13:03
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanRichTextDTO> searchCarLoanRichText(Map<String,Object> searchParams) throws Exception {
	    List<CarLoanRichTextDTO> dataList = dao.searchCarLoanRichText(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询car_loan_rich_text对象
     * @date 2018-06-08 21:13:03
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanRichTextDTO queryCarLoanRichTextByPrimaryKey(String id) throws Exception {
		
		CarLoanRichTextDTO dto = dao.findCarLoanRichTextByPrimaryKey(id);

		if(dto == null) dto = new CarLoanRichTextDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanRichText
     * @author root
     * @description: 新增 car_loan_rich_text对象
     * @date 2018-06-08 21:13:03
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanRichText(CarLoanRichTextDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);

		int count = dao.insertCarLoanRichText(paramMap);

		CarLoanRichTextDTO resultDto = (CarLoanRichTextDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateCarLoanRichText
     * @author root
     * @description: 修改 car_loan_rich_text对象
     * @date 2018-06-08 21:13:03
     * @param dto
     * @return
     * @throws
     */
	public void updateCarLoanRichText(CarLoanRichTextDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateCarLoanRichText(paramMap);
	}
	/**
	 * @author root
	 * @description: 查询car_loan_rich_text对象
	 * @date 2018-06-08 21:13:03
	 * @param relation_number
	 * @return
	 * @throws
	 */
	public CarLoanRichTextDTO queryCarLoanRichTextByNum(String relation_number,String biz_type) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("relation_number", relation_number);
		paramMap.put("biz_type", biz_type);
		CarLoanRichTextDTO dto = dao.findCarLoanRichTextByNum(paramMap);

		//if(dto == null) dto = new CarLoanRichTextDTO();

		return dto;

	}


}

