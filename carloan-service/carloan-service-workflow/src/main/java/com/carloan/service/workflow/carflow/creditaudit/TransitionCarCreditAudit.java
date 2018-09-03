package com.carloan.service.workflow.carflow.creditaudit;

import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.Jbpm4BizTabParam;
import com.carloan.apimodel.order.Jbpm4BizTabVo;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.apimodel.workflow.common.CarTransitionConst;
import com.carloan.feign.info.Jbpm4BizTabServiceFeign;
import com.carloan.service.workflow.carflow.TransitionCarBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by MMM on 2018/05/27.
 * 车贷信审流程流转类
 */
@Service
@Slf4j
public class TransitionCarCreditAudit extends TransitionCarBase{

    @Autowired
    Jbpm4BizTabServiceFeign jbpm4BizTabServiceFeign;
    /**
     * 车贷信审-同意(审核)
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean agree_shenhe(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir= CarTransitionConst.CONST_XINSHEN_TURNDIR_AGREE_SHENHE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.agree.shenhe---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.agree.shenhe---error,taskId:"+taskId+ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷信审-同意(复核)
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean agree_fuhe(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir= CarTransitionConst.CONST_XINSHEN_TURNDIR_AGREE_FUHE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.agree.fuhe---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.agree.fuhe---error,taskId:"+taskId+ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷信审-拒绝(审核)
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean refuse_shenhe(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_REFUSE_SHENHE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.refuse.shenhe---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.refuse.shenhe---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }

    }
    /**
     * 车贷信审-拒绝(复核)
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean refuse_fuhe(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_REFUSE_FUHE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.refuse.fuhe---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.refuse.fuhe---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }

    }
    /**
     * 车贷信审-疑似欺诈
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean likeAntiFraud(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_LILEANTIFRAUD;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.likeAntiFraud---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.likeAntiFraud---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }

    }
    /**
     * 车贷信审-回退,补充资料
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean rollBack_bujian(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_ROLLBACK_BUJIAN;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.rollBack.bujian---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.rollBack.bujian---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }

    }
    /**
     * 车贷信审-回退,审核
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean rollBack_shenhe(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_ROLLBACK_SHENHE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.rollBack.shenhe---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.rollBack.shenhe---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷信审-回退,复核
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean rollBack_fuhe(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_ROLLBACK_FUHE;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.rollBack.fuhe---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.rollBack.fuhe---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷信审-补件
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean attach(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_ATTACH;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.attach---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);

        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.attach---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }

    }
    /**
     * 车贷信审-补件 TODO://补件操作
     * @param orderNum 订单编号
     * @return
     * @throws Exception
     */
    public Boolean attach(String orderNum)  throws Exception{
        Jbpm4BizTabParam jbpm4BizTabParam=new Jbpm4BizTabParam();
        jbpm4BizTabParam.setBizInfNo(orderNum);
        jbpm4BizTabParam.setBizType(CarFlowConst.CAR_TASKTYPE_XINSHEN);
        ResponseResult<Jbpm4BizTabVo> jbpm4BizTabVoResponseResult= jbpm4BizTabServiceFeign.findTaskInfoByOrderNum(jbpm4BizTabParam);
        if(ResponseResult.isSucess(jbpm4BizTabVoResponseResult)){
            Jbpm4BizTabVo jbpm4BizTabVo=jbpm4BizTabVoResponseResult.getData();
            String pro_instance_id=jbpm4BizTabVo.getProInstanceId();
            return this.attach(pro_instance_id,null);
        }
        else{
            log.error(MessageFormat.format("TransitionCarCreditAudit.attach.error,ordernumber:{0}",orderNum));
            return false;
        }

    }
    /**
     * 车贷信审-非欺诈
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean notAntiFraud(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_NOTANTIFRAUD;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.notAntiFraud---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);

        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.notAntiFraud---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }
    }
    /**
     * 车贷信审-欺诈
     * @param taskId 任务id
     * @param variables 任务参数
     * @return
     */
    public Boolean antiFraud(String taskId,Map<String,Object> variables) throws Exception{
        try {
            String turnDir=CarTransitionConst.CONST_XINSHEN_TURNDIR_ANTIFRAUD;
            ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
            doActiveParamVo.setInstanceID(taskId);
            doActiveParamVo.setTransition(turnDir);
            log.info("TransitionCarCreditAudit.antiFraud---sucess,taskId:"+taskId);
            return super.doWorkFlow(taskId,turnDir);
        }
        catch (Exception ex){
            log.error("TransitionCarCreditAudit.antiFraud---error,taskId:"+taskId +ex.getStackTrace());
            throw ex;
        }
    }

}
