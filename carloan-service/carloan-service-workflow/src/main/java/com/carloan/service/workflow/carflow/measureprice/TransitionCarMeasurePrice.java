package com.carloan.service.workflow.carflow.measureprice;


import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.Jbpm4BizTabParam;
import com.carloan.apimodel.order.Jbpm4BizTabVo;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.apimodel.workflow.common.CarTransitionConst;
import com.carloan.feign.activity.ActivityFeign;
import com.carloan.feign.info.Jbpm4BizTabServiceFeign;
import com.carloan.service.workflow.carflow.TransitionCarBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by MMM on 2018/05/27.
 * 车贷定价流程流转类
 */
@Service
@Slf4j
public class TransitionCarMeasurePrice extends TransitionCarBase {
//    /* 流转名称---start */
//    private static final String CONST_TURNDIR_AGREE="同意";
//    private static final String CONST_TURNDIR_REFUSE="拒绝";
//    private static final String CONST_TURNDIR_ROLLBACK="回退";
//    private static final String CONST_TURNDIR_ATTACH="补件";
//
//    /* 流转名称---end */

    @Autowired
    ActivityFeign activityFeign;
    @Autowired
    Jbpm4BizTabServiceFeign jbpm4BizTabServiceFeign;
    /**
     * 车贷定价-同意
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean agree(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir= CarTransitionConst.CONST_DINGJIA_TURNDIR_AGREE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarMeasurePrice.refuse---sucess,taskId:"+taskId );
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarMeasurePrice.agree---error,taskId:"+taskId+ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷定价-拒绝
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean refuse(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir= CarTransitionConst.CONST_DINGJIA_TURNDIR_REFUSE;
            log.info("TransitionCarMeasurePrice.refuse---sucess,taskId:"+taskId );
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarMeasurePrice.refuse---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }

    }
    /**
     * 车贷定价-回退,补充资料
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean rollBack(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_DINGJIA_TURNDIR_ROLLBACK;
            log.info("TransitionCarMeasurePrice.rollBack---sucess,taskId:"+taskId );
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarMeasurePrice.rollBack---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷定价-补件
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean attach(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_DINGJIA_TURNDIR_ATTACH;
            log.info("TransitionCarMeasurePrice.attach---sucess,taskId:"+taskId );
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarMeasurePrice.attach---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }
    }

    /**
     * 车贷定价-补件 TODO
     * @param orderNum 订单编号
     * @return
     * @throws Exception
     */
    public Boolean attach(String orderNum)  throws Exception{
        Jbpm4BizTabParam jbpm4BizTabParam=new Jbpm4BizTabParam();
        jbpm4BizTabParam.setBizInfNo(orderNum);
        jbpm4BizTabParam.setBizType(CarFlowConst.CAR_TASKTYPE_DINGJIA);
        ResponseResult<Jbpm4BizTabVo> jbpm4BizTabVoResponseResult= jbpm4BizTabServiceFeign.findTaskInfoByOrderNum(jbpm4BizTabParam);
        if(ResponseResult.isSucess(jbpm4BizTabVoResponseResult)){
            Jbpm4BizTabVo jbpm4BizTabVo=jbpm4BizTabVoResponseResult.getData();
            String pro_instance_id=jbpm4BizTabVo.getProInstanceId();
            return this.attach(pro_instance_id,null);
        }
        else{
            log.error(MessageFormat.format("TransitionCarMeasurePrice.attach.error,ordernum:{0}",orderNum));
            return false;
        }
    }


}
