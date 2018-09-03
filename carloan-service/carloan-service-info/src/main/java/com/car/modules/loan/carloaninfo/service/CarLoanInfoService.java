package com.car.modules.loan.carloaninfo.service;

import com.car.modules.loan.carloaninfo.dao.CarLoanInfoDao;
import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanInfoService
 * @description: 定义  信审车贷订单表 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloaninfo.service.CarLoanInfoService")
public class CarLoanInfoService implements Serializable {
	private Logger logger = LoggerFactory.getLogger(CarLoanInfoService.class);


	private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanInfoDao dao;

	/**
     * @author root
     * @description: 分页查询 信审车贷订单表列表
     * @date 2018-05-24 05:09:46
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanInfoDTO> searchCarLoanInfoByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanInfoDTO> dataList =  dao.searchCarLoanInfoByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询信审车贷订单表列表
     * @date 2018-05-24 05:09:46
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanInfoDTO> searchCarLoanInfo(Map<String,Object> searchParams) throws Exception {
	    List<CarLoanInfoDTO> dataList = dao.searchCarLoanInfo(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询信审车贷订单表对象
     * @date 2018-05-24 05:09:46
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanInfoDTO queryCarLoanInfoByPrimaryKey(String id) throws Exception {
		
		CarLoanInfoDTO dto = dao.findCarLoanInfoByPrimaryKey(id);
		
		if(dto == null) dto = new CarLoanInfoDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanInfo
     * @author root
     * @description: 新增 信审车贷订单表对象
     * @date 2018-05-24 05:09:46
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertCarLoanInfo(CarLoanInfoDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertCarLoanInfo(paramMap);
		
		CarLoanInfoDTO resultDto = (CarLoanInfoDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateCarLoanInfo
     * @author root
     * @description: 修改 信审车贷订单表对象
     * @date 2018-05-24 05:09:46
     * @param paramMap
     * @return
     * @throws
     */
	public void updateCarLoanInfo(CarLoanInfoDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateCarLoanInfo(paramMap);
	}
	/**
     * @title: deleteCarLoanInfoByPrimaryKey
     * @author root
     * @description: 删除 信审车贷订单表,按主键
     * @date 2018-05-24 05:09:46
     * @param paramMap
     * @throws
     */ 


	public int  count(String sql){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("exesql",sql);
		return dao.countSqlinfo(paramMap);
	}

	public Map<String, String>  getValueMap(String sql)throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("exesql",sql);
		logger.info("★★★★★★★★★★="+sql);
		return dao.getValueMap(paramMap);
	}
	/**
	 * @author Administrator
	 * @description: 更新车贷信审表审核状态
	 * @date 2018-05-24 16:25:11
	 * @param dto
	 */
	public boolean updateCarLoanInfoAuditState(CarLoanInfoDTO dto){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int i= dao.updateCarLoanInfoAuditState(paramMap);
		if(i>0){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * @author Administrator
	 * @description: 更新车贷信审表审核状态
	 * @date 2018-05-24 16:25:11
	 * @param dto
	 */
	public boolean updateCarLoanInfoAuditInfo(CarLoanInfoDTO dto){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int i= dao.updateCarLoanInfoAuditInfo(paramMap);
		if(i>0){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * @author root
	 * @description:查询对象信审车贷订单表
	 * @date 2018-05-24 05:09:46
	 * @param orderNum
	 * @return
	 */
	public CarLoanInfoDTO findCarLoanInfoByOrderNum(String orderNum){
		CarLoanInfoDTO dto = dao.findCarLoanInfoByOrderNum(orderNum);

		if(dto == null) dto = new CarLoanInfoDTO();

		return dto;
	}
}

