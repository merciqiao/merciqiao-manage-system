package com.car.modules.loan.carloanreconsideration.service;

import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanmsg.service.CarLoanMsgService;
import com.car.modules.loan.carloanreconsideration.dao.CarLoanReconsiderationDao;
import com.car.modules.loan.carloanreconsideration.dto.CarLoanReconsiderationDTO;
import com.car.modules.reqvo.ReqFuYiVo;
import com.carloan.feign.workflow.WorkFlowFeign;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanReconsiderationService
 * @description: 定义  车贷复议表 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloanreconsideration.service.CarLoanReconsiderationService")
@Slf4j
public class CarLoanReconsiderationService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private CarLoanReconsiderationDao dao;


	@Autowired
	private CarLoanMsgService carLoanMsgService;

	@Autowired
	private WorkFlowFeign workFlowFeign;

	@Autowired
	private CarLoanInfoService carLoanInfoService;

	/**
     * @author root
     * @description: 分页查询 车贷复议表列表
     * @date 2018-05-28 01:51:28
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<CarLoanReconsiderationDTO> searchCarLoanReconsiderationByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanReconsiderationDTO> dataList =  dao.searchCarLoanReconsiderationByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询车贷复议表列表
     * @date 2018-05-28 01:51:28
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<CarLoanReconsiderationDTO> getCarLoanReconsiderationList(String ordernum) throws Exception {
	    List<CarLoanReconsiderationDTO> dataList = dao.getCarLoanReconsiderationList(ordernum);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询车贷复议表对象
     * @date 2018-05-28 01:51:28
     * @param id
     * @return
     * @throws
     */ 
	public CarLoanReconsiderationDTO queryCarLoanReconsiderationByPrimaryKey(String id) throws Exception {
		
		CarLoanReconsiderationDTO dto = dao.findCarLoanReconsiderationByPrimaryKey(id);
		
		if(dto == null) dto = new CarLoanReconsiderationDTO();
		
		return dto;
		
	}

	/**
     * @title: insertCarLoanReconsideration
     * @author root
     * @description: 新增 车贷复议表对象
     * @date 2018-05-28 01:51:28
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
public Long insertCarLoanReconsideration(ReqFuYiVo reqFuYiVo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (CollectionUtils.isNotEmpty(reqFuYiVo.getCarLoanFileDTOList())){
			carLoanMsgService.insertCarLoanFile(reqFuYiVo.getCarLoanFileDTOList(),"复议上传附件",reqFuYiVo.getOrderNumber());
		}
		if(reqFuYiVo.getCarLoanReconsiderationDTO()==null){
			throw new RuntimeException("carLoanReconsiderationDTO复议实体不能为空");
		}
		paramMap.put("dto", reqFuYiVo.getCarLoanReconsiderationDTO());
		dao.insertCarLoanReconsideration(paramMap);
		CarLoanInfoDTO carLoanInfoDTO	=carLoanInfoService.findCarLoanInfoByOrderNum(reqFuYiVo.getOrderNumber());
		workFlowFeign.startProcessByOrderId_FuYi(carLoanInfoDTO.getId()+"");
		log.info("★★★★★★★★★★★★★★★★★★★★★sta xinshen Fuyi  OK★★★★★★★★★★★★★★★★★★★★★");
		return reqFuYiVo.getCarLoanReconsiderationDTO().getId();
	}
	/**
     * @title: updateCarLoanReconsideration
     * @author root
     * @description: 修改 车贷复议表对象
     * @date 2018-05-28 01:51:28
     * @return
     * @throws
     */
	public void updateCarLoanReconsideration(CarLoanReconsiderationDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateCarLoanReconsideration(paramMap);
	}
	/**
	 * @author root
	 * @description:查询对象车贷复议表
	 * @param orderNum
	 * @return
	 */
	public CarLoanReconsiderationDTO findCarLoanReconsiderationByOrderNum(String orderNum){
		return dao.findCarLoanReconsiderationByOrderNum(orderNum);
	}
	/**
	 * 更新订单状态
	 * @param paramMap
	 */
	public void  updateCarLoanReconsiderationAuditState(Map<String, Object> paramMap){
		dao.updateCarLoanReconsiderationAuditState(paramMap);
	}
}

