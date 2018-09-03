package com.car.modules.workflow.jbpm4biztab.service;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanuser.dto.CarLoanUserDTO;
import com.car.modules.loan.carloanuser.service.CarLoanUserService;
import com.carloan.apimodel.order.Jbpm4BizTabParam;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.common.web.annotation.IdempotentBoolean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.modules.workflow.jbpm4biztab.dto.Jbpm4BizTabDTO;
import com.car.modules.workflow.jbpm4biztab.dao.Jbpm4BizTabDao;

/**
 * @classname: Jbpm4BizTabService
 * @description: 定义  jbpm4_biz_tab 实现类
 * @author:  root
 */
@Slf4j
@Service("com.car.modules.workflow.jbpm4biztab.service.Jbpm4BizTabService")
public class Jbpm4BizTabService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private Jbpm4BizTabDao dao;
	@Autowired
	CarLoanInfoService carLoanInfoService;
	@Autowired
	CarLoanUserService carLoanUserService;

	/**
     * @author root
     * @description: 分页查询 jbpm4_biz_tab列表
     * @date 2018-06-27 05:16:35
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<Jbpm4BizTabDTO> searchJbpm4BizTabByPaging(Map<String,Object> searchParams) throws Exception {
		List<Jbpm4BizTabDTO> dataList =  dao.searchJbpm4BizTabByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询jbpm4_biz_tab列表
     * @date 2018-06-27 05:16:35
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<Jbpm4BizTabDTO> searchJbpm4BizTab(Map<String,Object> searchParams) throws Exception {
	    List<Jbpm4BizTabDTO> dataList = dao.searchJbpm4BizTab(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询jbpm4_biz_tab对象
     * @date 2018-06-27 05:16:35
     * @param id
     * @return
     * @throws
     */ 
	public Jbpm4BizTabDTO queryJbpm4BizTabByPrimaryKey(String id) throws Exception {
		
		Jbpm4BizTabDTO dto = dao.findJbpm4BizTabByPrimaryKey(id);
		
		if(dto == null) dto = new Jbpm4BizTabDTO();
		
		return dto;
		
	}

	/**
     * @title: insertJbpm4BizTab
     * @author root
     * @description: 新增 jbpm4_biz_tab对象
     * @date 2018-06-27 05:16:35
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertJbpm4BizTab(Jbpm4BizTabDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertJbpm4BizTab(paramMap);
		
		Jbpm4BizTabDTO resultDto = (Jbpm4BizTabDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateJbpm4BizTab
     * @author root
     * @description: 修改 jbpm4_biz_tab对象
     * @date 2018-06-27 05:16:35
     * @param paramMap
     * @return
     * @throws
     */
	public void updateJbpm4BizTab(Jbpm4BizTabDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateJbpm4BizTab(paramMap);
	}
	/**
     * @title: deleteJbpm4BizTabByPrimaryKey
     * @author root
     * @description: 删除 jbpm4_biz_tab,按主键
     * @date 2018-06-27 05:16:35
     * @param paramMap
     * @throws
     */ 
	public void deleteJbpm4BizTabByPrimaryKey(Jbpm4BizTabDTO baseDto,String ids) throws Exception {
		if(StringUtils.isEmpty(ids)) throw new Exception("删除失败！传入的参数主键为null");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", baseDto);
		paramMap.put("ids", ids);
		dao.deleteJbpm4BizTabByPrimaryKey(paramMap);
	}
	/**
	 * 根据订单号查询流程实例id
	 * @param orderNum
	 * @return
	 */
	public Jbpm4BizTabDTO findTaskInfoByOrderNum(String orderNum,String bizType){
		Map<String, Object> paramMap=new HashMap<>();
		paramMap.put("orderNum",orderNum);
		paramMap.put("bizType",bizType);
		return dao.findTaskInfoByOrderNum(paramMap);
	}

	/**
	 * 查询未完成订单是否存在
	 * @param orderId
	 * @param bizType
	 * @return
	 */
	public Boolean findJbpm4BizTabExist(String orderId,String bizType){
		Map<String, Object> paramMap=new HashMap<>();
		paramMap.put("orderId",orderId);
		paramMap.put("bizType",bizType);
		int i= dao.findJbpm4BizTabExist(paramMap);
		if(i>0){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 根据流程实例id更新任务结束时间和结束标示
	 * @param pro_instance_id
	 * @return
	 */
	public int updateJbpm4BizTabOver(String pro_instance_id){
		Map<String, Object> paramMap = new HashMap<String, Object>();

		Jbpm4BizTabDTO dto=new Jbpm4BizTabDTO();
		dto.setOverTime(new Date());
		dto.setIsOver(1);
		dto.setProInstanceId(pro_instance_id);
		paramMap.put("dto", dto);
		return dao.updateJbpm4BizTabOver(paramMap);
	}
	@IdempotentBoolean
    public boolean saveJbpm4BizTab(Jbpm4BizTabParam carLoanInfoParam) throws Exception{
		log.info(MessageFormat.format("1.saveJbpm4BizTab prepare,param:{0}",carLoanInfoParam.toString()));
		CarLoanInfoDTO orderInfo =carLoanInfoService.queryCarLoanInfoByPrimaryKey(carLoanInfoParam.getId().toString());
		if(orderInfo==null||orderInfo.getId()==null){
			log.error("查询订单失败");
			return false;
		}
		else{
			String orderNum=orderInfo.getOrderNumber();
			CarLoanUserDTO carLoanUserDTO= carLoanUserService.queryCarLoanUserByOrderNum(orderNum);
			if(carLoanUserDTO==null){
				log.error("查询订单用户表失败");
				return false;
			}
			else{
				Jbpm4BizTabDTO jbpm4BizTabParam=new Jbpm4BizTabDTO();
				jbpm4BizTabParam.setProInstanceId(carLoanInfoParam.getProInstanceId());//流程id
				String bizInfName="";
				if(carLoanInfoParam.getBizType().equals(CarFlowConst.CAR_TASKTYPE_FUYI)){
					bizInfName=orderInfo.getOrderNumber()+" "+carLoanUserDTO.getUserName()+" 复议";
				}
				else if(carLoanInfoParam.getBizType().equals(CarFlowConst.CAR_TASKTYPE_DINGJIA)){
					bizInfName=orderInfo.getOrderNumber()+" "+"定价";
				}
				else{
					bizInfName=orderInfo.getOrderNumber()+" "+carLoanUserDTO.getUserName();
				}

				jbpm4BizTabParam.setBizInfName(bizInfName);//任务名称=订单编号+姓名);
				jbpm4BizTabParam.setBizTabName("car_loan_info");//表名
				jbpm4BizTabParam.setBizInfId(orderInfo.getId().toString());//订单id
				jbpm4BizTabParam.setBizInfNo(orderInfo.getOrderNumber());//订单号
				jbpm4BizTabParam.setBizType(carLoanInfoParam.getBizType());//订单类型(定价)
				jbpm4BizTabParam.setRemark(carLoanUserDTO.getUserName());
				jbpm4BizTabParam.setOrgId(orderInfo.getSecondlevelid());//所属组织
				Long id= this.insertJbpm4BizTab(jbpm4BizTabParam);
				if(id!=null){
					log.info("2.saveJbpm4BizTab sucess");
					return true;
				}
				else{
					log.error("2-2.saveJbpm4BizTab error");
					return false;
				}
			}
		}
	}

}

