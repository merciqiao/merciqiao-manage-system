package com.carloan.service.workflow.carflow;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.*;
import com.carloan.apimodel.workflow.TaskEventParam;
import com.carloan.apimodel.workflow.common.CarOrderState;
import com.carloan.feign.info.CarLoanBackInfoServiceFeign;
import com.carloan.feign.info.Jbpm4BizTabServiceFeign;
import com.carloan.feign.info.Jbpm4HistTaskServicefeign;
import com.carloan.feign.info.Jbpm4TaskServicefeign;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class EventStartCarBase {
    @Autowired
    Jbpm4TaskServicefeign jbpm4TaskServicefeign;

    @Autowired
    Jbpm4HistTaskServicefeign jbpm4HistTaskServicefeign;

    @Autowired
    CarLoanBackInfoServiceFeign carLoanBackInfoServiceFeign;
    @Autowired
    Jbpm4BizTabServiceFeign jbpm4BizTabServiceFeign;
    @Autowired
    Mapper mapper;
    /**
     * 流转到节点,则将实例,节点保存到任务临时表(重要:先写历史表,在更新临时表)
     * @return
     */
    public Boolean insertJbpm4_Task(TaskEventParam taskEventParam){

        //先查询旧实例
        Jbpm4TaskParam jbpm4TaskParam=new Jbpm4TaskParam();
        jbpm4TaskParam.setProInstanceId(taskEventParam.getProInstanceId());

        ResponseResult<Jbpm4TaskVo> responseResult=jbpm4TaskServicefeign.queryLikeJbpm4Task(jbpm4TaskParam);
        if(ResponseResult.isSucess(responseResult)){
            String activityName=taskEventParam.getActivityName();
            //如果是结束节点,则直接删除旧实例
            if(activityName.equals("同意")||activityName.equals("拒绝")
                    ||activityName.equals("结束")){
                return this.deleteJbpm4_Task_Old(responseResult);
            }
            else {

                //如果不是结束节点,则执行如下:



                //插入新纪录
                Jbpm4TaskParam jbpm4TaskParamNew = new Jbpm4TaskParam();
                jbpm4TaskParamNew.setProInstanceId(taskEventParam.getProInstanceId());
                jbpm4TaskParamNew.setActivityName(taskEventParam.getActivityName());
                jbpm4TaskParamNew.setCreateTime(new Date());
                jbpm4TaskParamNew.setAssignee("-1");


                ResponseResult result = jbpm4TaskServicefeign.insertJbpm4Task(jbpm4TaskParamNew);
                if (ResponseResult.isSucess(result)) {
                    //如果旧实例存在,则删除旧实例
                    return this.deleteJbpm4_Task_Old(responseResult);

                } else {
                    log.error(MessageFormat.format("insertJbpm4_Task.insertJbpm4Task.error,instanceid:{0}",taskEventParam.getProInstanceId()));
                    return false;
                }

            }
        }
        else {
            log.error(MessageFormat.format("insertJbpm4_Task.queryLikeJbpm4Task.error,instanceid:{0}",taskEventParam.getProInstanceId()));
            return false;
        }

    }

    /**
     * 流转到节点,则将流程实例流转轨迹存储到 实例历史表(重要:先写历史表,在更新临时表)
     * @param taskEventParam
     * @return
     */
    public Boolean insertJbpm4_hist_Task(TaskEventParam taskEventParam){
        //先查临时表旧记录,把assignee更新到对应的历史表记录
        Jbpm4TaskParam jbpm4TaskParam=new Jbpm4TaskParam();
        jbpm4TaskParam.setProInstanceId(taskEventParam.getProInstanceId());
        String activityName=taskEventParam.getActivityName();
        ResponseResult<Jbpm4TaskVo> responseResult=jbpm4TaskServicefeign.queryLikeJbpm4Task(jbpm4TaskParam);

        if(ResponseResult.isSucess(responseResult)){
            Jbpm4TaskVo jbpm4TaskVo_Old = responseResult.getData();
            if (jbpm4TaskVo_Old != null) {
                Jbpm4HistTaskParam jbpm4HistTaskParam=new Jbpm4HistTaskParam();
                jbpm4HistTaskParam.setProInstanceId(taskEventParam.getProInstanceId());
                jbpm4HistTaskParam.setActivityName(jbpm4TaskVo_Old.getActivityName());
                //查询历史表
                ResponseResult<Jbpm4HistTaskVo> result=jbpm4HistTaskServicefeign.queryLikeJbpm4HistTask(jbpm4HistTaskParam);
                if(ResponseResult.isSucess(result)){
                    Jbpm4HistTaskVo jbpm4HistTaskVo_Old=result.getData();
                    if(jbpm4HistTaskVo_Old!=null){
                        Jbpm4HistTaskParam jbpm4HistTaskParamNew=mapper.map(jbpm4HistTaskVo_Old,Jbpm4HistTaskParam.class);
                        jbpm4HistTaskParamNew.setAssignee(jbpm4TaskVo_Old.getAssignee());
                        jbpm4HistTaskParamNew.setEndTime(new Date());
                        //把任务人和结束时间更新到任务历史表
                        ResponseResult resultEnd= jbpm4HistTaskServicefeign.updateJbpm4HistTask(jbpm4HistTaskParamNew);
                        if(ResponseResult.isSucess(resultEnd)){
                            //return true;
                        }
                        else{
                            log.error(MessageFormat.format("insertJbpm4_hist_Task.updateJbpm4HistTask.error,instanceid:{0}",taskEventParam.getProInstanceId()));
                            return false;
                        }
                    }
                    else{
                        //return true;
                    }
                }
                else{
                    log.error(MessageFormat.format("insertJbpm4_hist_Task.queryLikeJbpm4HistTask.error,instanceid:{0}",taskEventParam.getProInstanceId()));
                    return false;
                }
            }

            //补入开始流转记录
            Boolean isStart= this.insertJbpm4_Task_Start(taskEventParam);
            if(isStart){
                Jbpm4HistTaskParam jbpm4HistTaskParam=new Jbpm4HistTaskParam();
                jbpm4HistTaskParam.setProInstanceId(taskEventParam.getProInstanceId());
                jbpm4HistTaskParam.setActivityName(taskEventParam.getActivityName());
                jbpm4HistTaskParam.setAssignee("-1");
                jbpm4HistTaskParam.setCreateTime(new Date());
                if(activityName.equals("同意")||activityName.equals("拒绝")
                        ||activityName.equals("结束")){
                    jbpm4HistTaskParam.setEndTime(new Date());
                }

                Map<String, Object> variables=new HashMap<>();
                variables=taskEventParam.getVariables();
                String transition= (String)variables.get("transition");
                jbpm4HistTaskParam.setTransition(transition);
                ResponseResult result= jbpm4HistTaskServicefeign.insertJbpm4HistTask(jbpm4HistTaskParam);
                if(ResponseResult.isSucess(result)){
                    return true;
                }
                else {
                    log.error(MessageFormat.format("insertJbpm4_hist_Task.insertJbpm4HistTask.error,instanceid:{0}",taskEventParam.getProInstanceId()));
                    return false;
                }
            }
            else {
                log.error(MessageFormat.format("insertJbpm4_hist_Task.insertJbpm4_Task_Start.error,instanceid:{0}",taskEventParam.getProInstanceId()));
                return false;
            }

        }
        else{
            log.error(MessageFormat.format("insertJbpm4_hist_Task.queryLikeJbpm4Task.error,instanceid:{0}",taskEventParam.getProInstanceId()));
            return false;
        }


    }

    private Boolean deleteJbpm4_Task_Old(ResponseResult<Jbpm4TaskVo> responseResult){
        //如果旧实例存在,则删除旧实例
        Jbpm4TaskVo jbpm4TaskVo = responseResult.getData();
        if (jbpm4TaskVo != null) {
            Jbpm4TaskParam jbpm4TaskParamDel = new Jbpm4TaskParam();
            jbpm4TaskParamDel.setId(jbpm4TaskVo.getId());
            ResponseResult resultDel = jbpm4TaskServicefeign.delete(jbpm4TaskParamDel);
            if (ResponseResult.isSucess(resultDel)) {
                return true;
            } else {
                log.error(MessageFormat.format("deleteJbpm4_Task_Old.error,instanceid:{0}",jbpm4TaskVo.getProInstanceId()));
                return false;
            }
        }
        else{
            return true;
        }
    }

    /**
     * 补入开始历史记录
     * @param taskEventParam
     * @return
     */
    private Boolean insertJbpm4_Task_Start(TaskEventParam taskEventParam){
        if(taskEventParam.getTransition().equals("开始")){
            Jbpm4HistTaskParam jbpm4HistTaskParam=new Jbpm4HistTaskParam();
            jbpm4HistTaskParam.setProInstanceId(taskEventParam.getProInstanceId());
            jbpm4HistTaskParam.setCreateTime(new Date());
            jbpm4HistTaskParam.setEndTime(new Date());
            jbpm4HistTaskParam.setActivityName("开始");
            jbpm4HistTaskParam.setAssignee("-1");
            ResponseResult result= jbpm4HistTaskServicefeign.insertJbpm4HistTask(jbpm4HistTaskParam);
            if (ResponseResult.isSucess(result)) {
               return true;

            } else {
                log.error(MessageFormat.format("insertJbpm4_Task_Start.error,instanceid:{0}",taskEventParam.getProInstanceId()));
                return false;
            }
        }
        else{
            return true;
        }

    }


    /**
     * 更新补件记录
     *
     * @param orderId    订单id
     * @param auditState 审核状态
     */
    public Boolean updateBackInfo(Long orderId, String auditState,String orderTypeName,String orderTypeCode) throws Exception {
        CarLoanBackInfoParam carLoanBackInfoParam = new CarLoanBackInfoParam();
        carLoanBackInfoParam.setFkIntoCustRefId(orderId);
        carLoanBackInfoParam.setOrdertypecode(Integer.parseInt(orderTypeCode));
        carLoanBackInfoParam.setOrdertypename(orderTypeName);

        String isPatchAdd = "";
        if (CarOrderState.DINGJIA_STATE_SHENHE.getKey().equals(auditState)||//定价审核中-审核中
                CarOrderState.XINSHEN_STATE_SHENHE.getKey().equals(auditState)) {//信审-审核中
            isPatchAdd = "0";
            carLoanBackInfoParam.setStatus(isPatchAdd);
            Response response = carLoanBackInfoServiceFeign.updateBackInfo(carLoanBackInfoParam);
            if (Response.isSucess(response)) {
                log.info(MessageFormat.format("updateBackInfo.sucess,orderid:{0}", orderId));
                return true;
            } else {
                log.error(MessageFormat.format("updateBackInfo.error,orderid:{0}", orderId));
                return false;
            }
        } else if (CarOrderState.DINGJIA_STATE_BUJIAN.getKey().equals(auditState)//定价审核中-补件
                ||CarOrderState.XINSHEN_STATE_BUJIAN.getKey().equals(auditState)) {//信审-补件
            isPatchAdd = "1";
            carLoanBackInfoParam.setStatus(isPatchAdd);
            ResponseResult<CarLoanBackInfoVo> responseResult = carLoanBackInfoServiceFeign.queryEntity(orderId.toString(),orderTypeCode);
            if (ResponseResult.isSucess(responseResult)) {
                if (responseResult.getData() != null) {
                    carLoanBackInfoServiceFeign.updateBackInfo(carLoanBackInfoParam);
                    return true;
                } else {
                    carLoanBackInfoParam.setAttachNumber("1");
                    Response response = carLoanBackInfoServiceFeign.insertCarLoanBackInfo(carLoanBackInfoParam);
                    if (Response.isSucess(response)) {
                        return true;
                    } else {
                        log.error(MessageFormat.format("updateBackInfo.insertCarLoanBackInfo.error,orderid:{0}", orderId));
                        return false;
                    }
                }
            } else {
                log.error(MessageFormat.format("updateBackInfo.queryEntity.error,orderid:{0}", orderId));
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * 根据流程实例id更新任务结束时间和结束标示
     * @param taskEventParam
     * @return
     */
    public Boolean updateJbpm4BizTabOver(TaskEventParam taskEventParam){
        String activityName=taskEventParam.getActivityName();
        //如果是流程结束,则更新结束时间和标示
        if(activityName.equals("同意")||activityName.equals("拒绝")
                ||activityName.equals("结束")){
            Response response= jbpm4BizTabServiceFeign.updateJbpm4BizTabOver(taskEventParam.getProInstanceId());
            if(Response.isSucess(response)){
                return true;
            }
            else{
                log.error("EventStartCarBase.updateJbpm4BizTabOver.feign.error,proinstanceid:{0}",taskEventParam.getProInstanceId());
                return false;
            }
        }
        else{
            return true;
        }
    }
}
