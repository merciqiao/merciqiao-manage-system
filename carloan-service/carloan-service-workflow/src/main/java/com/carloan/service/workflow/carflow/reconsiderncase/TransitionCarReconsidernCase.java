package com.carloan.service.workflow.carflow.reconsiderncase;

import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.workflow.common.CarTransitionConst;
import com.carloan.service.workflow.carflow.TransitionCarBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by MMM on 2018/05/27.
 * 车贷复议流程流转类
 */
@Service
@Slf4j
public class TransitionCarReconsidernCase extends TransitionCarBase{


    /**
     * 车贷复议-同意
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean agree(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir= CarTransitionConst.CONST_FUYI_TURNDIR_AGREE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarReconsidernCase.agree---sucess,taskId:"+taskId );
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarReconsidernCase.agree---error,taskId:"+taskId+ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷复议-拒绝
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean refuse(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir= CarTransitionConst.CONST_FUYI_TURNDIR_REFUSE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarReconsidernCase.refuse---sucess,taskId:"+taskId );
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarReconsidernCase.refuse---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }
    }

}
