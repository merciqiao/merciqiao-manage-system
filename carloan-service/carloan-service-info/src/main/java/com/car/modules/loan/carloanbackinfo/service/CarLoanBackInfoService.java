package com.car.modules.loan.carloanbackinfo.service;

import com.car.modules.loan.carloanbackinfo.dao.CarLoanBackInfoDao;
import com.car.modules.loan.carloanbackinfo.dto.CarLoanBackInfoDTO;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanBackInfoService
 * @description: 定义  car_loan_back_info 实现类
 * @author:  root
 */
@Service
public class CarLoanBackInfoService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanBackInfoDao dao;

	/**
     * @author root
     * @description: 分页查询 car_loan_back_info列表
     * @date 2018-06-04 04:21:08
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanBackInfoDTO> searchCarLoanBackInfoByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanBackInfoDTO> dataList =  dao.searchCarLoanBackInfoByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询car_loan_back_info列表
     * @date 2018-06-04 04:21:08
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanBackInfoDTO> searchCarLoanBackInfo(Map<String,Object> searchParams) throws Exception {
	    List<CarLoanBackInfoDTO> dataList = dao.searchCarLoanBackInfo(searchParams);
        return dataList;
    }

	/**
     * @title: insertCarLoanBackInfo
     * @author root
     * @description: 新增 car_loan_back_info对象
     * @date 2018-06-04 04:21:08
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanBackInfo(CarLoanBackInfoDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertCarLoanBackInfo(paramMap);
		
		CarLoanBackInfoDTO resultDto = (CarLoanBackInfoDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateCarLoanBackInfo
     * @author root
     * @description: 修改 car_loan_back_info对象
     * @date 2018-06-04 04:21:08
     * @return
     * @throws
     */
	public boolean updateCarLoanBackInfo(CarLoanBackInfoDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int i= dao.updateCarLoanBackInfo(paramMap);
		if(i>0){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * @author root
	 * @description:根据订单id查询对象car_loan_back_info
	 * @date 2018-06-04 04:21:08
	 * @param orderId
	 * @return
	 */
	public CarLoanBackInfoDTO findCarLoanBackInfoByOrderId(String orderId,String ordertypecode){
		return dao.findCarLoanBackInfoByOrderId(orderId,ordertypecode);
	}
	/**
	 * 更新补件记录
	 * @param orderId 订单id
	 * @param orderTypeCode 订单类型code
	 * @param orderTypeName 订单类型名称
	 * @param status 状态
	 */
	public boolean  updateBackInfo(String orderId,String orderTypeCode,String orderTypeName, String status) throws Exception{
		CarLoanBackInfoDTO carLoanBackInfoDTO=this.findCarLoanBackInfoByOrderId(orderId,orderTypeCode);
		if(carLoanBackInfoDTO!=null){
			//补件数量 (只有退回补件的时候增加补件数量)
			if("1".equals(status)){
				int att_number = Integer.parseInt(carLoanBackInfoDTO.getAttachNumber()) + 1;
				carLoanBackInfoDTO.setAttachNumber(String.valueOf(att_number));
			}
			carLoanBackInfoDTO.setStatus(status);
			carLoanBackInfoDTO.setOrdertypecode(Integer.parseInt(orderTypeCode));
			carLoanBackInfoDTO.setOrdertypename(orderTypeName);
			return this.updateCarLoanBackInfo(carLoanBackInfoDTO);
		}
		else{
			return true;
		}
	}


}

