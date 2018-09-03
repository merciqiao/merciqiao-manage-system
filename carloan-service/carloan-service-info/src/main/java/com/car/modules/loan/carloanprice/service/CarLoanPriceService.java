
package com.car.modules.loan.carloanprice.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarAuditState;
import com.carloan.apimodel.workflow.TransitionParam;
import com.carloan.feign.workflow.WorkFlowFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.car.modules.loan.carloanprice.dto.CarLoanPriceDTO;
import com.car.modules.loan.carloanprice.dao.CarLoanPriceDao;

/**
 * @classname: CarLoanPriceService
 * @description: 定义  定价审核意见表 实现类
 * @author:  root
 */
@Service
public class CarLoanPriceService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private CarLoanPriceDao dao;
	@Autowired
	private WorkFlowFeign workFlowfeiService;

	public List<CarLoanPriceDTO> searchCarLoanPriceByPaging(Map<String,Object> searchParams) throws Exception {
		List<CarLoanPriceDTO> dataList =  dao.searchCarLoanPriceByPaging(searchParams);
		return dataList;
	}
	public List<CarLoanPriceDTO> searchCarLoanPrice(CarLoanPriceDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<CarLoanPriceDTO> dataList = dao.searchCarLoanPrice(paramMap);
        return dataList;
    }
	public CarLoanPriceDTO queryCarLoanPriceByPrimaryKey(String id) throws Exception {
		CarLoanPriceDTO dto = dao.findCarLoanPriceByPrimaryKey(id);
		if(dto == null) dto = new CarLoanPriceDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertCarLoanPrice(CarLoanPriceDTO dto) throws Exception {
		String intostate= CarAuditState.getIntoStateByAuditState(dto.getAuditState());//"";
		dto.setStaTus(intostate);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		Long keyId =dto.getId();
		int count =0;
		if(dto.getId()>0)
		{
			count = dao.updateCarLoanPrice(paramMap);
		}
		else
		{
			count = dao.insertCarLoanPrice(paramMap);
			CarLoanPriceDTO resultDto = (CarLoanPriceDTO) paramMap.get("dto");
			keyId = resultDto.getId();
		}

		if (dto.getOperation() == 1) {//流程流转
			if(dto.getProcessId()==null&&dto.getProcessId().length()==0||dto.getTransition().length()==0)
			{
				throw new Exception("流程事物参数不完整");
			}
			TransitionParam param = new TransitionParam();
			param.setTaskId(dto.getProcessId());
			//审核：同意，拒绝，回退，疑似欺诈 复议：
			param.setType(dto.getTransition());
			Response flowresult = new Response();
			flowresult = workFlowfeiService.doTransition_DingJia(param);
			if (!Response.isSucess(flowresult)) {
				throw new Exception("流程流转失败"+flowresult.getMessage());
			}
		}
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateCarLoanPrice(CarLoanPriceDTO dto)throws Exception{
		String intostate= CarAuditState.getIntoStateByAuditState(dto.getAuditState());//"";
		dto.setStaTus(intostate);
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateCarLoanPrice(paramMap);
		}

    public CarLoanPriceDTO queryLikeCarLoanPrice(CarLoanPriceDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeCarLoanPrice(paramMap);
		}

}

