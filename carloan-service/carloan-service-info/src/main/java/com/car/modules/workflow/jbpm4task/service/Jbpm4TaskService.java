
package com.car.modules.workflow.jbpm4task.service;

import com.car.modules.loan.biz.asynjob.dto.BizAsynJobDO;

import com.car.modules.loan.biz.asynjob.service.BizAsynJobService;
import com.car.modules.loan.carloanbackinfo.dto.CarLoanBackInfoDTO;
import com.car.modules.loan.carloanbackinfo.service.CarLoanBackInfoService;
import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;
import com.car.modules.loan.carloaninfo.service.CarLoanInfoService;
import com.car.modules.workflow.jbpm4biztab.service.Jbpm4BizTabService;
import com.car.modules.workflow.jbpm4histtask.dto.Jbpm4HistTaskDTO;
import com.car.modules.workflow.jbpm4histtask.service.Jbpm4HistTaskService;
import com.car.modules.workflow.jbpm4task.dao.Jbpm4TaskDao;
import com.car.modules.workflow.jbpm4task.dto.Jbpm4TaskDTO;
import com.carloan.apimodel.biz.enums.AsynJobEnum;
import com.carloan.apimodel.workflow.TaskEventParam;
import com.carloan.apimodel.workflow.common.CarFlowConst;
import com.carloan.apimodel.workflow.common.CarOrderState;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @classname: Jbpm4TaskService
 * @description: 定义  jbpm4_task 实现类
 * @author: root
 */
@Service
@Slf4j
public class Jbpm4TaskService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private Jbpm4TaskDao dao;
    @Autowired
    Jbpm4HistTaskService jbpm4HistTaskService;
    @Autowired
    CarLoanBackInfoService carLoanBackInfoService;
    @Autowired
    Jbpm4BizTabService jbpm4BizTabService;
    @Autowired
    CarLoanInfoService carLoanInfoService;
    @Autowired
    BizAsynJobService bizAsynJobService;

    public List<Jbpm4TaskDTO> searchJbpm4TaskByPaging(Map<String, Object> searchParams) throws Exception {
        List<Jbpm4TaskDTO> dataList = dao.searchJbpm4TaskByPaging(searchParams);
        return dataList;
    }

    public List<Jbpm4TaskDTO> searchJbpm4Task(Jbpm4TaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        List<Jbpm4TaskDTO> dataList = dao.searchJbpm4Task(paramMap);
        return dataList;
    }

    public Jbpm4TaskDTO queryJbpm4TaskByPrimaryKey(String id) {
        Jbpm4TaskDTO dto = dao.findJbpm4TaskByPrimaryKey(id);
        if (dto == null) dto = new Jbpm4TaskDTO();
        return dto;

    }

    @SuppressWarnings("all")
    @Transactional(rollbackFor = {Exception.class})
    public Long insertJbpm4Task(Jbpm4TaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int count = dao.insertJbpm4Task(paramMap);
        Jbpm4TaskDTO resultDto = (Jbpm4TaskDTO) paramMap.get("dto");
        Long keyId = resultDto.getId();
        return keyId;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateJbpm4Task(Jbpm4TaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        dao.updateJbpm4Task(paramMap);
    }

    public Jbpm4TaskDTO queryLikeJbpm4Task(Jbpm4TaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        return dao.queryLikeJbpm4Task(paramMap);
    }

    public boolean deleteJbpm4TaskByID(Jbpm4TaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int i = dao.deleteJbpm4TaskByID(paramMap);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 事务操作,写入任务信息
     *
     * @param taskEventParam
     * @return
     */
    @Transactional
    public boolean UpdateOrderState(TaskEventParam taskEventParam) throws Exception {
        log.info(MessageFormat.format("********>>UpdateOrderState.1.prepate,param:{0}",taskEventParam.toString()));
        boolean isUpdateState = this.updateCarLoanInfoAuditState(taskEventParam);
        String[] carStatus = new String[]{"2100", "2200", "2700", "2400", "3100", "3300", "2600", "3500", "3600"};
        boolean ispushmsg=StringUtils.startsWithAny(taskEventParam.getAuditState(), carStatus);
        int bizjob=0;
        //异步推送审核结论
        if (ispushmsg) {
            log.info("UpdateOrderState.2.save mq sucess");
            BizAsynJobDO job = new BizAsynJobDO();
            job.setBeanClass("com.car.modules.loan.biz.asynjob.service.SendIntoInfoAsyBiz");
            job.setJobState(AsynJobEnum.ASYN.getStatus());
            job.setBizKeyId(taskEventParam.orderId);
            bizjob = bizAsynJobService.insertBizAsynJobDO(job);

            //同步审批时间到订单主表
            BizAsynJobDO jobt = new BizAsynJobDO();
            jobt.setBeanClass("com.car.modules.loan.biz.asynjob.service.AsynCarStartEndTimeService");
            jobt.setJobState(AsynJobEnum.ASYN.getStatus());
            jobt.setBizKeyId(taskEventParam.proInstanceId);
            bizAsynJobService.insertBizAsynJobDO(jobt);
        }


        if (!isUpdateState||(ispushmsg&&bizjob<=0)) {
            log.error("UpdateOrderState.2.update state or mq error,state:"+isUpdateState);
            throw new Exception("writeJbpm4Task.updateCarLoanInfoAuditState.error");
        } else {
            log.info("UpdateOrderState.3.update state sucess");
            boolean isInsertJbpm = this.insertJbpm4(taskEventParam);
            if (!isInsertJbpm) {
                throw new Exception("writeJbpm4Task.insertJbpm4.error");
            } else {
                log.info("UpdateOrderState.4.insertJbpm4 sucess");
                boolean isOver = this.updateJbpm4BizTabOver(taskEventParam);
                if (!isOver) {
                    throw new Exception("writeJbpm4Task.updateBackInfo.error");
                } else {
                    log.info("UpdateOrderState.5.update updateJbpm4BizTabOver sucess");
                    if (taskEventParam.getOrderTypeCode().equals(CarFlowConst.CAR_TASKTYPE_FUYI)) {
                        log.info("UpdateOrderState.6-2.update state sucess");
                        return true;
                    } else {
                        boolean isBack = this.updateBackInfo(taskEventParam);
                        if (!isBack) {
                            throw new Exception("writeJbpm4Task.updateBackInfo.error");
                        } else {
                            log.info("UpdateOrderState.6-1.updateBackInfo success");
                            return true;
                        }
                    }
                }
            }
        }

    }

    public boolean updateCarLoanInfoAuditState(TaskEventParam taskEventParam) throws Exception{
        CarLoanInfoDTO carLoanInfoParam = new CarLoanInfoDTO();
        carLoanInfoParam.setId(Long.parseLong(taskEventParam.getOrderId()));
        carLoanInfoParam.setAuditeState(taskEventParam.getAuditState());
        return carLoanInfoService.updateCarLoanInfoAuditState(carLoanInfoParam);
    }

    /**
     * 流转到节点,插入临时表和历史表
     *
     * @param taskEventParam
     * @return
     * @throws Exception
     */
    public Boolean insertJbpm4(TaskEventParam taskEventParam) throws Exception {
        log.info(MessageFormat.format( "insertJbpm.1.prepare,param:{0}",taskEventParam.toString()));
        Long id = null;//临时表和历史表ID
        String activityName = taskEventParam.getActivityName();
        //查当前临时表记录
        Jbpm4TaskDTO jbpm4TaskDTOParam = new Jbpm4TaskDTO();
        jbpm4TaskDTOParam.setProInstanceId(taskEventParam.getProInstanceId());
        Jbpm4TaskDTO jbpm4TaskVo_Old = this.queryLikeJbpm4Task(jbpm4TaskDTOParam);
        //如果存在,则查对应的历史表记录
        if (jbpm4TaskVo_Old != null) {
            log.info("insertJbpm.2.jbpm4TaskVo_Old exist");
            Jbpm4HistTaskDTO jbpm4HistTaskDTOParam = new Jbpm4HistTaskDTO();
            jbpm4HistTaskDTOParam.setId(jbpm4TaskVo_Old.getId());
            Jbpm4HistTaskDTO jbpm4HistTaskVo_Old = jbpm4HistTaskService.queryLikeJbpm4HistTask(jbpm4HistTaskDTOParam);
            if (jbpm4HistTaskVo_Old == null) {
                log.error(MessageFormat.format("insertJbpm.3-3jbpm4HistTaskVo_Old not exist,param:{0}",jbpm4HistTaskDTOParam.toString()));
                return false;
            }
            log.info("insertJbpm.3.jbpm4HistTaskVo_Old exist");
            jbpm4HistTaskVo_Old.setEndTime(new Date());
            jbpm4HistTaskVo_Old.setNextTransition(taskEventParam.getTransition());//设置
            //更新历史表结束时间
            boolean isUpdate = jbpm4HistTaskService.updateJbpm4HistTask(jbpm4HistTaskVo_Old);
            if (!isUpdate) {
                log.error(MessageFormat.format("insertJbpm.4-4updateJbpm4HistTask error,param:{0}",jbpm4HistTaskVo_Old.toString()));
                return false;
            }
            log.info("insertJbpm.4.updateJbpm4HistTask sucess");
            //删除当前临时表记录
            boolean isDelete = this.deleteJbpm4TaskByID(jbpm4TaskVo_Old);
            if (!isDelete) {
                log.error(MessageFormat.format("insertJbpm.5-5deleteJbpm4TaskByID error,param:{0}",jbpm4TaskVo_Old.toString()));
                return false;
            }
            log.info("insertJbpm.5.deleteJbpm4TaskByID sucess");
        }
        //插入临时表新记录
        Jbpm4TaskDTO jbpm4TaskParamNew = new Jbpm4TaskDTO();
        jbpm4TaskParamNew.setProInstanceId(taskEventParam.getProInstanceId());
        jbpm4TaskParamNew.setActivityName(taskEventParam.getActivityName());
        jbpm4TaskParamNew.setCreateTime(new Date());
        jbpm4TaskParamNew.setAssignee("-1");

        id = this.insertJbpm4Task(jbpm4TaskParamNew);
        if (id == null) {
            log.error(MessageFormat.format("insertJbpm.6-6insertJbpm4Task error,param:{0}",jbpm4TaskParamNew.toString()));
            return false;
        }
        log.info("insertJbpm.6.insertJbpm4Task sucess");
        //如果是结束,删除临时表记录
        if (activityName.equals("同意") || activityName.equals("拒绝")
                || activityName.equals("结束")) {
            boolean isDelNew = this.deleteJbpm4TaskByID(jbpm4TaskParamNew);
            if (!isDelNew) {
                log.error(MessageFormat.format("insertJbpm.deleteJbpm4TaskByID error,param:{0}",jbpm4TaskParamNew.toString()));
                return false;
            }
            log.info("insertJbpm.7.deleteJbpm4TaskByID sucess");
        }

        //插入历史表新记录
        Jbpm4HistTaskDTO jbpm4HistTaskParam = new Jbpm4HistTaskDTO();
        jbpm4HistTaskParam.setProInstanceId(taskEventParam.getProInstanceId());
        jbpm4HistTaskParam.setActivityName(taskEventParam.getActivityName());
        jbpm4HistTaskParam.setAssignee("-1");
        jbpm4HistTaskParam.setCreateTime(new Date());
        jbpm4HistTaskParam.setId(id);
        if (activityName.equals("同意") || activityName.equals("拒绝")
                || activityName.equals("结束")) {
            jbpm4HistTaskParam.setEndTime(new Date());
        }
        String transition = taskEventParam.getTransition();
        jbpm4HistTaskParam.setTransition(transition);
        boolean isInsert = jbpm4HistTaskService.insertJbpm4HistTask(jbpm4HistTaskParam);
        if (isInsert) {
            log.info("insertJbpm.8.insertJbpm4HistTask sucess");
            return true;
        } else {
            log.error(MessageFormat.format("insertJbpm.8-8insertJbpm4HistTask error,param:{0}",jbpm4HistTaskParam.toString()));
            return false;
        }

    }

    /**
     * 流转到节点,则将流程实例流转轨迹存储到 实例历史表(重要:先写历史表,在更新临时表)
     *
     * @param taskEventParam
     * @return
     */
    public Boolean insertJbpm4_hist_Task(TaskEventParam taskEventParam) throws Exception {
        //先查临时表旧记录,把assignee更新到对应的历史表记录
        Jbpm4TaskDTO jbpm4TaskDTOParam = new Jbpm4TaskDTO();
        jbpm4TaskDTOParam.setProInstanceId(taskEventParam.getProInstanceId());
        String activityName = taskEventParam.getActivityName();
        Jbpm4TaskDTO jbpm4TaskVo_Old = this.queryLikeJbpm4Task(jbpm4TaskDTOParam);
        if (jbpm4TaskVo_Old != null) {
            Jbpm4HistTaskDTO jbpm4HistTaskDTOParam = new Jbpm4HistTaskDTO();
            jbpm4HistTaskDTOParam.setProInstanceId(taskEventParam.getProInstanceId());
            jbpm4HistTaskDTOParam.setActivityName(jbpm4TaskVo_Old.getActivityName());
            //查询历史表
            Jbpm4HistTaskDTO jbpm4HistTaskVo_Old = jbpm4HistTaskService.queryLikeJbpm4HistTask(jbpm4HistTaskDTOParam);
            if (jbpm4HistTaskVo_Old != null) {
                jbpm4HistTaskVo_Old.setAssignee(jbpm4TaskVo_Old.getAssignee());
                jbpm4HistTaskVo_Old.setEndTime(new Date());
                //把任务人和结束时间更新到任务历史表
                boolean isUpdate = jbpm4HistTaskService.updateJbpm4HistTask(jbpm4HistTaskVo_Old);
                if (!isUpdate) {
                    return false;
                }
            }
        }

        //补入开始流转记录
        Boolean isStart = this.insertJbpm4_Task_Start(taskEventParam);
        if (isStart) {
            Jbpm4HistTaskDTO jbpm4HistTaskParam = new Jbpm4HistTaskDTO();
            jbpm4HistTaskParam.setProInstanceId(taskEventParam.getProInstanceId());
            jbpm4HistTaskParam.setActivityName(taskEventParam.getActivityName());
            jbpm4HistTaskParam.setAssignee("-1");
            jbpm4HistTaskParam.setCreateTime(new Date());
            if (activityName.equals("同意") || activityName.equals("拒绝")
                    || activityName.equals("结束")) {
                jbpm4HistTaskParam.setEndTime(new Date());
            }
            String transition = taskEventParam.getTransition();
            jbpm4HistTaskParam.setTransition(transition);
            Boolean isHisJbpm = jbpm4HistTaskService.insertJbpm4HistTask(jbpm4HistTaskParam);
            if (isHisJbpm) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * 补入开始历史记录
     *
     * @param taskEventParam
     * @return
     */
    private Boolean insertJbpm4_Task_Start(TaskEventParam taskEventParam) throws Exception {
        if (taskEventParam.getTransition().equals("开始")) {
            Jbpm4HistTaskDTO jbpm4HistTaskParam = new Jbpm4HistTaskDTO();
            jbpm4HistTaskParam.setProInstanceId(taskEventParam.getProInstanceId());
            jbpm4HistTaskParam.setCreateTime(new Date());
            jbpm4HistTaskParam.setEndTime(new Date());
            jbpm4HistTaskParam.setActivityName("开始");
            jbpm4HistTaskParam.setAssignee("-1");
            boolean id = jbpm4HistTaskService.insertJbpm4HistTask(jbpm4HistTaskParam);
            if (id) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    /**
     * 流转到节点,则将实例,节点保存到任务临时表(重要:先写历史表,在更新临时表)
     *
     * @return
     */
    public Boolean insertJbpm4_Task(TaskEventParam taskEventParam) throws Exception {

        //先查询旧实例
        Jbpm4TaskDTO jbpm4TaskParam = new Jbpm4TaskDTO();
        jbpm4TaskParam.setProInstanceId(taskEventParam.getProInstanceId());

        Jbpm4TaskDTO Jbpm4TaskOld = this.queryLikeJbpm4Task(jbpm4TaskParam);
        String activityName = taskEventParam.getActivityName();
        //如果是结束节点,则直接删除旧实例
        if (activityName.equals("同意") || activityName.equals("拒绝")
                || activityName.equals("结束")) {
            if (Jbpm4TaskOld != null) {
                return this.deleteJbpm4TaskByID(Jbpm4TaskOld);
            } else {
                return false;
            }
        } else {

            //如果不是结束节点,则执行如下:插入新纪录
            Jbpm4TaskDTO jbpm4TaskParamNew = new Jbpm4TaskDTO();
            jbpm4TaskParamNew.setProInstanceId(taskEventParam.getProInstanceId());
            jbpm4TaskParamNew.setActivityName(taskEventParam.getActivityName());
            jbpm4TaskParamNew.setCreateTime(new Date());
            jbpm4TaskParamNew.setAssignee("-1");

            Long id = this.insertJbpm4Task(jbpm4TaskParamNew);
            if (id != null) {
                //如果旧实例存在,则删除旧实例
                if (Jbpm4TaskOld != null) {
                    return this.deleteJbpm4TaskByID(Jbpm4TaskOld);
                } else {
                    return true;
                }

            } else {
                return false;
            }

        }
    }

    /**
     * 更新补件记录
     *
     * @param orderId    订单id
     * @param auditState 审核状态
     */
    public Boolean updateBackInfo(TaskEventParam taskEventParam) throws Exception {
        log.info(MessageFormat.format( "updateBackInfo.1.prepare,param:{0}",taskEventParam.toString()));
        Long orderId = Long.parseLong(taskEventParam.getOrderId());
        String auditState = taskEventParam.getAuditState();
        String orderTypeName = taskEventParam.getOrderTypeName();
        String orderTypeCode = taskEventParam.getOrderTypeCode();
        CarLoanBackInfoDTO carLoanBackInfoParam = new CarLoanBackInfoDTO();
        carLoanBackInfoParam.setFkIntoCustRefId(orderId);
        carLoanBackInfoParam.setOrdertypecode(Integer.parseInt(orderTypeCode));
        carLoanBackInfoParam.setOrdertypename(orderTypeName);

        String isPatchAdd = "";
        if (CarOrderState.DINGJIA_STATE_SHENHE.getKey().equals(auditState) ||//定价审核中-审核中
                CarOrderState.XINSHEN_STATE_SHENHE.getKey().equals(auditState)) {//信审-审核中
            isPatchAdd = "0";
            carLoanBackInfoParam.setStatus(isPatchAdd);
            boolean isUpdate = carLoanBackInfoService.updateCarLoanBackInfo(carLoanBackInfoParam);
            log.info("updateBackInfo.1.updateCarLoanBackInfo sucess");
            return true;

        } else if (CarOrderState.DINGJIA_STATE_BUJIAN.getKey().equals(auditState)//定价审核中-补件
                || CarOrderState.XINSHEN_STATE_BUJIAN.getKey().equals(auditState)) {//信审-补件
            isPatchAdd = "1";
            carLoanBackInfoParam.setStatus(isPatchAdd);
            CarLoanBackInfoDTO carLoanBackInfoVo = carLoanBackInfoService.findCarLoanBackInfoByOrderId(orderId.toString(), orderTypeCode);
            if (carLoanBackInfoVo != null) {
                return carLoanBackInfoService.updateBackInfo(orderId.toString(), orderTypeCode, orderTypeName, isPatchAdd);
            } else {
                carLoanBackInfoParam.setAttachNumber("1");
                Long id = carLoanBackInfoService.insertCarLoanBackInfo(carLoanBackInfoParam);
                if (id != null) {
                    log.info("updateBackInfo.2.insertCarLoanBackInfo success");
                    return true;
                } else {
                    log.error("updateBackInfo.2-2insertCarLoanBackInfo error");
                    return false;
                }

            }
        } else {
            log.info("updateBackInfo.2.sucess");
            return true;
        }

    }

    /**
     * 根据流程实例id更新任务结束时间和结束标示
     *
     * @param taskEventParam
     * @return
     */
    public Boolean updateJbpm4BizTabOver(TaskEventParam taskEventParam) {
        log.info(MessageFormat.format( "updateJbpm4BizTabOver.1.prepare,param:{0}",taskEventParam.toString()));
        String activityName = taskEventParam.getActivityName();
        //如果是流程结束,则更新结束时间和标示
        if (activityName.equals("同意") || activityName.equals("拒绝")
                || activityName.equals("结束")) {
            int i = jbpm4BizTabService.updateJbpm4BizTabOver(taskEventParam.getProInstanceId());
            if (i > 0) {
                log.info("updateJbpm4BizTabOver.2updateJbpm4BizTabOver sucess");
                return true;
            } else {
                log.error("updateJbpm4BizTabOver.2-2updateJbpm4BizTabOver error");
                return false;
            }
        } else {
            log.info("updateJbpm4BizTabOver.2sucess");
            return true;
        }
    }

    /**
     * 更新任务处理人，sql并发控制派单池重复派单
     *
     * @param taskId
     * @param toUserId
     * @param boolValue
     * @return
     */
    public int updateAssigneeByPrimaryKey(long taskId, String toUserId, boolean boolValue) {
        return dao.updateAssigneeByPrimaryKey(taskId, toUserId, boolValue);
    }

    /**
     * 获取没有分配的task
     *
     * @param params
     * @return
     */
    public List<Map<String, Object>> listTaskOfNoAssignee(Map<String, Object> params) {
        return dao.listTaskOfNoAssignee(params);
    }

}

