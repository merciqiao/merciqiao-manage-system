package com.car.modules.loan.carloanuser.service;

import com.car.modules.exceptionpackage.ProductException;
import com.car.modules.loan.Jdbcquery.dao.Jdbcquery;
import com.car.modules.loan.biz.asynjob.dto.BizAsynJobDO;
import com.car.modules.loan.biz.asynjob.service.BizAsynJobService;
import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanmsg.service.CarLoanMsgService;
import com.car.modules.loan.carloansurveycontacts.dto.CarLoanSurveyContactsDTO;
import com.car.modules.loan.carloansurveycontacts.service.CarLoanSurveyContactsService;
import com.car.modules.loan.carloanuser.dao.CarLoanUserDao;
import com.car.modules.loan.carloanuser.dto.CarLoanUserDTO;
import com.car.modules.loan.carloanusercontacts.dto.CarLoanUserContactsDTO;
import com.car.modules.loan.carloanusercontacts.service.CarLoanUserContactsService;
import com.car.modules.reqvo.ReqUserInIfVo;
import com.car.modules.reqvo.Variable;
import com.carloan.apimodel.biz.enums.AsynJobEnum;
import com.carloan.feign.workflow.WorkFlowFeign;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanUserService
 * @description: 定义  车贷个人信息表 实现类
 * @author:  root
 */
@Service("com.car.modules.loan.carloanuser.service.CarLoanUserService")
@Slf4j
public class CarLoanUserService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CarLoanUserDao dao;
	@Autowired
	private CarLoanInfoService carLoanInfoService;
	@Autowired
	private CarLoanUserContactsService carLoanUserContactsService;
	@Autowired
	private CarLoanMsgService carLoanMsgService;
	@Autowired
	private Jdbcquery jdbcquery;
	@Autowired
	private CarLoanSurveyContactsService carLoanSurveyContactsService;
	@Autowired
	private WorkFlowFeign workFlowFeign;

	@Autowired
	private BizAsynJobService bizAsynJobService;

	/**
	 * @author root
	 * @description: 分页查询 车贷个人信息表列表
	 * @date 2018-05-25 01:26:23
	 * @param searchParams 条件
	 * @return
	 * @throws
	 */
	public List<CarLoanUserDTO> searchCarLoanUserByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanUserDTO> dataList =  dao.searchCarLoanUserByPaging(searchParams);
		return dataList;
	}
	/**
	 * @author root
	 * @description: 按条件查询车贷个人信息表列表
	 * @date 2018-05-25 01:26:23
	 * @param searchParams 条件
	 * @return
	 * @throws
	 */
	public List<CarLoanUserDTO> searchCarLoanUser(Map<String,Object> searchParams) throws Exception {
		List<CarLoanUserDTO> dataList = dao.searchCarLoanUser(searchParams);
		return dataList;
	}
	/**
	 * @author root
	 * @description: 查询车贷个人信息表对象
	 * @date 2018-05-25 01:26:23
	 * @param id
	 * @return
	 * @throws
	 */
	public CarLoanUserDTO queryCarLoanUserByPrimaryKey(String id) throws Exception {

		CarLoanUserDTO dto = dao.findCarLoanUserByPrimaryKey(id);

		if(dto == null) dto = new CarLoanUserDTO();

		return dto;

	}
	/**
	 * @author root
	 * @description: 查询车贷个人信息表对象
	 * @date 2018-05-25 01:26:23
	 * @return
	 * @throws
	 */
	public CarLoanUserDTO queryCarLoanUserByOrderNum(String orderNum) throws Exception {

		CarLoanUserDTO dto = dao.queryCarLoanUserByOrderNum(orderNum);

		if(dto == null) dto = new CarLoanUserDTO();

		return dto;

	}

	/**
	 * @title: insertCarLoanUser
	 * @author root
	 * @description: 新增 车贷个人信息表对象
	 * @date 2018-05-25 01:26:23
	 * @param dto
	 * @return
	 * @throws
	 */
	@SuppressWarnings("all")
	@Transactional(rollbackFor = Exception.class)
	public Long insertCarLoanUser(ReqUserInIfVo reqUserInIfVo) throws Exception {
		try {
			if(reqUserInIfVo.getCarLoanUserDTO()==null){
				throw new RuntimeException("进件用户信息不能为空");
			}
			if(reqUserInIfVo.getCarLoanInfoDTO()==null){
				throw new RuntimeException("进件订单信息不能为空");
			}
			if(CollectionUtils.isEmpty(reqUserInIfVo.getCarLoanUserContactsDTOList())){
				throw new RuntimeException("进件联系人信息不能为空");
			}
			String productType=reqUserInIfVo.getCarLoanInfoDTO().getProductSeries()+"-"+reqUserInIfVo.getCarLoanInfoDTO().getProductType();
			Map<String, Object> reqmap = new  HashMap<String, Object>();
			reqmap.put("exesql",MessageFormat.format(Variable.V9, Variable.Assemble(productType)));
			String ProductId = MapUtils.getString(jdbcquery.getQueryMap(reqmap), "PRODUCT_CODE");


			if (StringUtils.isBlank(productType)) {
				throw new ProductException("当前产品[" + ProductId+ "]名称不存在信审系统配置表【lb_t_product_conf】不能进行进件申请。");
			}
			CarLoanInfoDTO carLoanInfoDTO	=carLoanInfoService.findCarLoanInfoByOrderNum(reqUserInIfVo.getOrderNumber());
			reqUserInIfVo.getCarLoanInfoDTO().setProductSeries(ProductId);
			reqUserInIfVo.getCarLoanInfoDTO().setProductType(productType);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			reqUserInIfVo.getCarLoanUserDTO().setCarinfoid(carLoanInfoDTO.getId());
			paramMap.put("dto", reqUserInIfVo.getCarLoanUserDTO());
		    int userID=	dao.insertCarLoanUser(paramMap);
			CarLoanUserDTO carLoanUserDTO = (CarLoanUserDTO) paramMap.get("dto");
			this.saveInsertCarLoanSurveyContactsList(reqUserInIfVo.getCarLoanUserContactsDTOList(),carLoanUserDTO.getId()+"");
			carLoanInfoService.updateCarLoanInfo(reqUserInIfVo.getCarLoanInfoDTO());
			carLoanUserContactsService.insertCarLoanUserContacts(reqUserInIfVo.getCarLoanUserContactsDTOList(),carLoanInfoDTO.getId());
			carLoanMsgService.insertCarLoanFile(reqUserInIfVo.getCarLoanFileDTOList(),"客户信息附件",reqUserInIfVo.getOrderNumber());
			//新增流程发起数据
			BizAsynJobDO job=new BizAsynJobDO();
			job.setBeanClass("com.car.modules.loan.biz.asynjob.service.JbpmStartXSProAsynService");
			job.setJobState(AsynJobEnum.ASYN.getStatus());
			job.setBizKeyId(carLoanInfoDTO.getId().toString());
			int bizjob=bizAsynJobService.insertBizAsynJobDO(job);
			//workFlowFeign.startProcessByOrderId_XinShen(carLoanInfoDTO.getId()+"");
			log.info("发起人员流程,订单编号：{}"+reqUserInIfVo.getOrderNumber());
			return carLoanInfoDTO.getId();
		}catch (Exception e){
			throw new RuntimeException(e);
		}

	}
	/**
	 * @title: updateCarLoanUser
	 * @author root
	 * @description: 修改 车贷个人信息表对象
	 * @date 2018-05-25 01:26:23
	 * @return
	 * @throws
	 */
	public void updateCarLoanUser(CarLoanUserDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);

		dao.updateCarLoanUser(paramMap);
	}

	public CarLoanUserDTO searchCarLoanUserByDetail(Map<String, Object> searchParams) {
		CarLoanUserDTO dataList = dao.searchCarLoanUserByDetail(searchParams);
		return dataList;
	}



	public void  saveInsertCarLoanSurveyContactsList(List<CarLoanUserContactsDTO> loanUserContactsDTOS,String carLoanUserId) throws Exception {
		List<CarLoanSurveyContactsDTO> list =new ArrayList<>();
		for (CarLoanUserContactsDTO  carLoanUserContactsDTO : loanUserContactsDTOS){
			CarLoanSurveyContactsDTO carLoanSurveyContactsDTO = new CarLoanSurveyContactsDTO();
			carLoanSurveyContactsDTO.setOrderNumber(carLoanUserContactsDTO.getOrderNumber());
			carLoanSurveyContactsDTO.setCarLoanUserId(carLoanUserId);
			carLoanSurveyContactsDTO.setContactType("联系人电话");
			carLoanSurveyContactsDTO.setRelationship(carLoanUserContactsDTO.getRelationship());
			carLoanSurveyContactsDTO.setUserName(carLoanUserContactsDTO.getName());
			carLoanSurveyContactsDTO.setHomeAddress(carLoanUserContactsDTO.getHomeOrOfficeAddresses());
			carLoanSurveyContactsDTO.setCompanyName(carLoanUserContactsDTO.getWorkUnit());
			carLoanSurveyContactsDTO.setUserTelephone(carLoanUserContactsDTO.getContactNumber());
			list.add(carLoanSurveyContactsDTO);
		}
		carLoanSurveyContactsService.insertCarLoanSurveyContactsList(list);
	}
}

