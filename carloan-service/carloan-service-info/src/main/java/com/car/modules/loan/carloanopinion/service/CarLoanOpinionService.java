
package com.car.modules.loan.carloanopinion.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarAuditState;
import com.carloan.apimodel.workflow.TransitionParam;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.feign.workflow.WorkFlowFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.car.modules.loan.carloanopinion.dto.CarLoanOpinionDTO;
import com.car.modules.loan.carloanopinion.dao.CarLoanOpinionDao;

/**
 * @classname: CarLoanOpinionService
 * @description: 定义  初审终审(审核意见表) 实现类
 * @author:  root
 */
@Service
public class CarLoanOpinionService implements Serializable {

    private static final long serialVersionUID = 1L;
	@Autowired
	private WorkFlowFeign workFlowfeiService;
	@Autowired
	private CarLoanInfoService carLoanInfoService;

	@Autowired
	private CarLoanOpinionDao dao;

	public List<CarLoanOpinionDTO> searchCarLoanOpinionByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanOpinionDTO> dataList =  dao.searchCarLoanOpinionByPaging(searchParams);
		return dataList;
	}
	public List<CarLoanOpinionDTO> searchCarLoanOpinion(Map<String,Object> searchParams) throws Exception {
	    List<CarLoanOpinionDTO> dataList = dao.searchCarLoanOpinion(searchParams);
        return dataList;
    }
	public CarLoanOpinionDTO queryCarLoanOpinionByPrimaryKey(String id) throws Exception {
		CarLoanOpinionDTO dto = dao.findCarLoanOpinionByPrimaryKey(id);
		if(dto == null) dto = new CarLoanOpinionDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertCarLoanOpinion(CarLoanOpinionDTO dto) throws Exception {
		String intostate= CarAuditState.getIntoStateByAuditState(dto.getAuditState());//"";
		dto.setStaTus(intostate);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		Long keyId =dto.getId();
		if(dto!=null&&dto.getId()>0) {
			int count = dao.updateCarLoanOpinion(paramMap);
		}
		else
		{
			int count = dao.insertCarLoanOpinion(paramMap);
			CarLoanOpinionDTO resultDto = (CarLoanOpinionDTO) paramMap.get("dto");
			keyId = resultDto.getId();
		}

		if (dto.getOperation() == 1) {//流程流转
//			CarLoanInfoDTO carloan=new CarLoanInfoDTO();
//			carloan.setId(dto.getCarInfoId());
//			carloan.setApprovalAmount(dto.getContractAmount());
//			carloan.setApprovalTerm(dto.getApprovalPeriod());
//			carloan.setApprovalProductType(dto.getProductType());
		 	//carLoanInfoService.updateCarLoanInfoAuditInfo(carloan);
			if(dto.getProcessId()==null&&dto.getProcessId().length()==0||dto.getTransition1()==null||dto.getTransition1().length()==0)
			{
				throw new Exception("流程事物参数不完整");
			}
			TransitionParam param = new TransitionParam();
			param.setTaskId(dto.getProcessId());
			//同意，拒绝，补件,疑似欺诈
			param.setType(dto.getTransition1());
			Response flowresult = new Response();
			if (dto.getBizType().toString().equals(CarFlowConst.CAR_TASKTYPE_XINSHEN)) {
				flowresult = workFlowfeiService.doTransition_XinShen(param);
			} else if (dto.getBizType().toString().equals(CarFlowConst.CAR_TASKTYPE_FUYI)) {
				flowresult = workFlowfeiService.doTransition_FuYi(param);
			}

			if (!Response.isSucess(flowresult)) {
				throw new Exception("流程流转失败"+flowresult.getMessage());
			}
		}
//		if(true) {
//			throw new Exception("流程流转失败");
//		}
		return keyId;

	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateCarLoanOpinion(CarLoanOpinionDTO dto)throws Exception{
		String intostate=CarAuditState.getIntoStateByAuditState(dto.getAuditState());//"";
		dto.setStaTus(intostate);
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateCarLoanOpinion(paramMap);
		}

    public CarLoanOpinionDTO queryLikeCarLoanOpinion(CarLoanOpinionDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeCarLoanOpinion(paramMap);
		}

}

