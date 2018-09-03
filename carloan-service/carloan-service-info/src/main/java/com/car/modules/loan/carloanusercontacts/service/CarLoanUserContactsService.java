package com.car.modules.loan.carloanusercontacts.service;
import com.car.modules.loan.carloanusercontacts.dao.CarLoanUserContactsDao;
import com.car.modules.loan.carloanusercontacts.dto.CarLoanUserContactsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanUserContactsService
 * @description: 定义  申请人联系人信息 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloanusercontacts.service.CarLoanUserContactsService")
public class CarLoanUserContactsService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanUserContactsDao dao;

	/**
     * @author root
     * @description: 分页查询 申请人联系人信息列表
     * @date 2018-05-24 05:03:24
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanUserContactsDTO> searchCarLoanUserContactsByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanUserContactsDTO> dataList =  dao.searchCarLoanUserContactsByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询申请人联系人信息列表
     * @date 2018-05-24 05:03:24
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanUserContactsDTO> searchCarLoanUserContacts(String order_number) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("order_number",order_number);
		List<CarLoanUserContactsDTO> dataList = dao.searchCarLoanUserContacts(paramMap);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询申请人联系人信息对象
     * @date 2018-05-24 05:03:24
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanUserContactsDTO queryCarLoanUserContactsByPrimaryKey(String id) throws Exception {
		
		CarLoanUserContactsDTO dto = dao.findCarLoanUserContactsByPrimaryKey(id);
		
		if(dto == null) dto = new CarLoanUserContactsDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanUserContacts
     * @author root
     * @description: 新增 申请人联系人信息对象
     * @date 2018-05-24 05:03:24
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public void insertCarLoanUserContacts(List<CarLoanUserContactsDTO> list,Long carinfoid) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("list", list);
		paramMap.put("carinfoid", carinfoid);
		dao.insertCarLoanUserContacts(paramMap);
	}
	/**
     * @title: updateCarLoanUserContacts
     * @author root
     * @description: 修改 申请人联系人信息对象
     * @date 2018-05-24 05:03:24
     * @return
     * @throws
     */
	public void updateCarLoanUserContacts(CarLoanUserContactsDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		dao.updateCarLoanUserContacts(paramMap);
	}

	/**
	 * 通过参数来查询联系人 的相关信息
	 * @param orderNuber
	 * @return
	 */
	public List findCarLoanUserContactsByOrderNum(String orderNuber) throws Exception{
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("orderNuber", orderNuber);
		List dataList = dao.findCarLoanUserContactsByOrderNum(searchParams);
		return dataList;
	}
}

