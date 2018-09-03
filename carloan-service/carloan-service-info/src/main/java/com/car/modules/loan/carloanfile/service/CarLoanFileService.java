package com.car.modules.loan.carloanfile.service;

import com.car.modules.loan.carloanfile.dao.CarLoanFileDao;
import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanFileService
 * @description: 定义  申请人联系人信息 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloanfile.service.CarLoanFileService")
public class CarLoanFileService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanFileDao dao;

	/**
     * @author root
     * @description: 分页查询 申请人联系人信息列表
     * @date 2018-05-24 07:50:11
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanFileDTO> searchCarLoanFileByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanFileDTO> dataList =  dao.searchCarLoanFileByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询申请人联系人信息列表
     * @date 2018-05-24 07:50:11
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanFileDTO> searchCarLoanFile(Map<String,Object> searchParams) throws Exception {
	    List<CarLoanFileDTO> dataList = dao.searchCarLoanFile(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询申请人联系人信息对象
     * @date 2018-05-24 07:50:11
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanFileDTO queryCarLoanFileByPrimaryKey(String id) throws Exception {
		
		CarLoanFileDTO dto = dao.findCarLoanFileByPrimaryKey(id);
		
		if(dto == null) dto = new CarLoanFileDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanFile
     * @author root
     * @description: 新增 申请人联系人信息对象
     * @date 2018-05-24 07:50:11
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanFile(CarLoanFileDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertCarLoanFile(paramMap);
		
		CarLoanFileDTO resultDto = (CarLoanFileDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateCarLoanFile
     * @author root
     * @description: 修改 申请人联系人信息对象
     * @date 2018-05-24 07:50:11
     * @return
     * @throws
     */
	public void updateCarLoanFile(CarLoanFileDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateCarLoanFile(paramMap);
	}



	public List<CarLoanFileDTO> findCarLoanFileOrderNum(String order_number) throws Exception {
		List<CarLoanFileDTO> dto = dao.findCarLoanFileOrderNum(order_number);
		return dto;

	}

}

