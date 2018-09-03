package com.car.modules.loan.carloanmsg.service;

import com.car.modules.loan.Jdbcquery.dao.Jdbcquery;
import com.car.modules.loan.biz.asynjob.dto.BizAsynJobDO;
import com.car.modules.loan.biz.asynjob.service.BizAsynJobService;
import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;
import com.car.modules.loan.carloanfile.service.CarLoanFileService;
import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.loan.carloanmsg.dao.CarLoanMsgDao;
import com.car.modules.loan.carloanmsg.dto.CarLoanMsgDTO;
import com.car.modules.reqvo.ReqPriceVo;
import com.car.modules.reqvo.Variable;
import com.carloan.apimodel.biz.enums.AsynJobEnum;
import com.carloan.apimodel.workflow.TransitionParam;
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
 * @classname: CarLoanMsgService
 * @description: 定义  车辆信息 实现类
 * @author:  Administrator
 */
@Service("com.car.modules.loan.carloanmsg.service.CarLoanMsgService")
@Slf4j
public class CarLoanMsgService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CarLoanMsgDao dao;


	@Autowired
	private Jdbcquery jdbcquery;


	@Autowired
	private CarLoanFileService carLoanFileService;

	@Autowired
	private CarLoanInfoService carLoanInfoService;


	@Autowired
	private WorkFlowFeign workFlowFeign;

	@Autowired
	private BizAsynJobService bizAsynJobService;
	/**
	 * @author Administrator
	 * @description: 分页查询 车辆信息列表
	 * @date 2018-05-24 16:25:10
	 * @param searchParams 条件
	 * @return
	 * @throws
	 */
	public List<CarLoanMsgDTO> searchCarLoanMsgByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanMsgDTO> dataList =  dao.searchCarLoanMsgByPaging(searchParams);
		return dataList;
	}
	/**
	 * @author Administrator
	 * @description: 按条件查询车辆信息列表
	 * @date 2018-05-24 16:25:10
	 * @param searchParams 条件
	 * @return
	 * @throws
	 */
	public List<CarLoanMsgDTO> searchCarLoanMsg(Map<String,Object> searchParams) throws Exception {
		List<CarLoanMsgDTO> dataList = dao.searchCarLoanMsg(searchParams);
		return dataList;
	}
	/**
	 * @author Administrator
	 * @description: 查询车辆信息对象
	 * @date 2018-05-24 16:25:10
	 * @return
	 * @throws
	 */
	public CarLoanMsgDTO queryCarLoanMsgByPrimaryKey(String order_number) throws Exception {

		CarLoanMsgDTO dto = dao.findCarLoanMsgByPrimaryKey(order_number);

		if(dto == null) dto = new CarLoanMsgDTO();

		return dto;

	}

	/**
	 * @title: insertCarLoanMsg
	 * @author Administrator
	 * @description: 新增 车辆信息对象
	 * @date 2018-05-24 16:25:10
	 * @param dto
	 * @return
	 * @throws
	 */
	@SuppressWarnings("all")
	@Transactional(rollbackFor=Exception.class)
	public Long insertCarLoanMsg(ReqPriceVo reqPriceVo) throws Exception {
		try {
			List<CarLoanFileDTO>  carLoanFileDTOList =reqPriceVo.getCarLoanFileDTOList();
			if (reqPriceVo.getCarLoanMsgDTO()==null|| CollectionUtils.isEmpty(carLoanFileDTOList)){
				throw new RuntimeException("车辆实体或者附件实体不能为空");
			}


			CarLoanInfoDTO carLoanInfoDTO = new CarLoanInfoDTO();
			carLoanInfoDTO.setOrderNumber(reqPriceVo.getOrderNumber());
			Long id =	carLoanInfoService.insertCarLoanInfo(carLoanInfoDTO);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			reqPriceVo.getCarLoanMsgDTO().setCarinfoid(id);
			paramMap.put("dto", reqPriceVo.getCarLoanMsgDTO());
			dao.insertCarLoanMsg(paramMap);
			this.insertCarLoanFile("定价上传附件",reqPriceVo.getCarLoanFileDTOList());
			//workFlowFeign.startProcessByOrderId_DingJia(id+"");
			BizAsynJobDO job=new BizAsynJobDO();
			job.setBeanClass("com.car.modules.loan.biz.asynjob.service.JbpmStartProAsynService");
			job.setJobState(AsynJobEnum.ASYN.getStatus());
			job.setBizKeyId(id.toString());
			int bizjob=bizAsynJobService.insertBizAsynJobDO(job);
			log.info("★★★★★★★★★★★★★★★★★★★★★sta dingjia ok★★★★★★★★★★★★★★★★★★★★★");
			return id;
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}



	public void insertCarLoanFile(String remake,List<CarLoanFileDTO>  carLoanFileDTOList)throws Exception {
		if (CollectionUtils.isEmpty(carLoanFileDTOList)){
			throw new RuntimeException("附件实体不能为空");
		}
		for ( CarLoanFileDTO carLoanFileDTO:carLoanFileDTOList){
			if (StringUtils.isNotBlank(carLoanFileDTO.getImgcode())) {
				Map<String, Object> paramMap = new  HashMap<String, Object>();
				paramMap.put("exesql",MessageFormat.format(Variable.V7, Variable.Assemble(carLoanFileDTO.getImgcode())));
				Map<String, String> map = jdbcquery.getQueryMap(paramMap);
				carLoanFileDTO.setHistoryUrl(carLoanFileDTO.getFileUrl());
				carLoanFileDTO.setFileLink(remake);
				carLoanFileDTO.setAttachType(MapUtils.getString(map, "TWO_LEVEL_CODE"));
				carLoanFileDTO.setFileAppendageType(MapUtils.getString(map, "ONE_LEVEL_CODE"));
				carLoanFileDTO.setFileName(MapUtils.getString(map, "TWO_LEVEL_NAME"));
				carLoanFileService.insertCarLoanFile(carLoanFileDTO);
			}
		}
	}



	@SuppressWarnings("all")
	@Transactional(rollbackFor=Exception.class)
	public void insertCarLoanFile(List<CarLoanFileDTO>  carLoanFileDTOList,String remake,String orderNumber) throws Exception {
		try {
			if (CollectionUtils.isEmpty(carLoanFileDTOList)){
				throw new RuntimeException("附件实体不能为空");
			}
			TransitionParam transitionParam = new TransitionParam();transitionParam.setOrderNum(orderNumber);

			List<CarLoanFileDTO> loanFileDTOS=this.getFileList(carLoanFileDTOList);
			for ( CarLoanFileDTO carLoanFileDTO:loanFileDTOS){
				if (StringUtils.isNotBlank(carLoanFileDTO.getImgcode())) {
					Map<String, Object> paramMap = new  HashMap<String, Object>();
					paramMap.put("exesql",MessageFormat.format(Variable.V7, Variable.Assemble(carLoanFileDTO.getImgcode())));
					Map<String, String> map = jdbcquery.getQueryMap(paramMap);
					carLoanFileDTO.setHistoryUrl(carLoanFileDTO.getFileUrl());
					carLoanFileDTO.setFileLink(remake);
					carLoanFileDTO.setFileName(MapUtils.getString(map, "TWO_LEVEL_NAME"));
					carLoanFileDTO.setAttachType(MapUtils.getString(map, "TWO_LEVEL_CODE"));
					carLoanFileDTO.setFileAppendageType(MapUtils.getString(map, "ONE_LEVEL_CODE"));
					carLoanFileService.insertCarLoanFile(carLoanFileDTO);
				}
			}
			if (remake.equals("定价补件")){
				log.info("订单编号：{},开始调用定价补件流程--------开始------------",orderNumber);
				workFlowFeign.doTransition_DingJia_Attach(transitionParam);
				log.info("订单编号：{},开始调用定价补件流程--------结束------------",orderNumber);

			}
			if (remake.equals("客户信息补件")){
				log.info("订单编号：{},开始调用客户信息补件流程--------开始------------",orderNumber);
				workFlowFeign.doTransition_XinShen_Attach(transitionParam);
				log.info("订单编号：{},开始调用客户信息补件流程--------结束------------",orderNumber);
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}


	public List<CarLoanFileDTO> getFileList(List<CarLoanFileDTO> list){
		List<CarLoanFileDTO> copyList = new ArrayList<>();
		for (CarLoanFileDTO fileDTO:list){
			int count = carLoanInfoService.count(MessageFormat.format(Variable.V4, Variable.Assemble(fileDTO.getOrderNumber()), Variable.Assemble(fileDTO.getFileUrl())));
			if (count<=0) {
				copyList.add(fileDTO);
			}
		}
		return copyList;
	}





	/**
	 * @title: updateCarLoanMsg
	 * @author Administrator
	 * @description: 修改 车辆信息对象
	 * @date 2018-05-24 16:25:10
	 * @return
	 * @throws
	 */
	public void updateCarLoanMsg(CarLoanMsgDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);

		dao.updateCarLoanMsg(paramMap);
	}

	public List<CarLoanMsgDTO> searchCarLoanMsgs(Map<String, Object> searchParams) {
		List<CarLoanMsgDTO> dataList = dao.searchCarLoanMsgs(searchParams);
		return dataList;
	}
	/**
	 * @author Administrator
	 * @description: 更新对象车辆审核状态
	 * @date 2018-05-24 16:25:11
	 * @param paramMap
	 */
	public void updateCarLoanMsgAuditState(Map<String, Object> paramMap){
		dao.updateCarLoanMsgAuditState(paramMap);
	}

	/**
	 * 根据订单号查询任务id和流程实例id
	 * @param orderNum
	 * @return
	 */
	public HashMap findTaskInfoByOrderNum(String orderNum,String bizType){
		Map<String, Object> paramMap=new HashMap<>();
		paramMap.put("orderNum",orderNum);
		paramMap.put("bizType",bizType);
		return dao.findTaskInfoByOrderNum(paramMap);
	}

}

