
package com.carloan.service.activiti.controller;


import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.activiti.dto.ActivitiInfoVO;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.*;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.javax.el.ExpressionFactory;
import org.activiti.engine.impl.javax.el.ValueExpression;
import org.activiti.engine.impl.juel.ExpressionFactoryImpl;
import org.activiti.engine.impl.juel.SimpleContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by MMM on 2018/01/29.
 * rest接口
 */

@RestController
@RequestMapping(value="/activity-api")
@Slf4j
@Component
public class ActivityController {
    @Resource

    ProcessEngine engine;


    @ApiOperation(value="启动工作流",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/workflow.start")
    @ResponseBody
    public ResponseResult<ActivitiInstanceInfoVO> startprocess(@RequestBody ActivitiInfoVO activitiParamVO) throws Exception {
        ResponseResult<ActivitiInstanceInfoVO> result = new ResponseResult<>();
        try{
            ActivitiInstanceInfoVO instance=new ActivitiInstanceInfoVO();
            TaskService taskService=engine.getTaskService();
            RuntimeService runtimeService = engine.getRuntimeService();
            Map<String,Object> variables=new HashMap<String,Object>();
            if(!StringUtils.isEmpty(activitiParamVO.getAssignee())){
                variables.put("assignee",activitiParamVO.getAssignee());
            }
            if(!StringUtils.isEmpty(activitiParamVO.getOrderid())){
                variables.put("orderid",activitiParamVO.getOrderid());
            }
            if(!StringUtils.isEmpty(activitiParamVO.getOwner())){
                variables.put("owner",activitiParamVO.getOwner());
            }
            if(!StringUtils.isEmpty(activitiParamVO.getTransition())){
                variables.put("transition",activitiParamVO.getTransition());
            }
            // 启动流程
            ProcessInstance pi= runtimeService.startProcessInstanceByKey(activitiParamVO.getProcessKey(),variables);


            instance.setInstanceID(pi.getId());

            result.setStatus(Status.SUCCESS);
            result.setData(instance);
            result.setMessage("查询成功");
        }
        catch (Exception ex) {
            log.error("调用流程启动startprocess方法出错，错误信息："+ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常");
        }
        return result;
    }
    @ApiOperation(value="执行工作流任务",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/workflow.do")
    @ResponseBody
    public Response doworkflow(@RequestBody ActivitiInstanceInfoVO instance) throws Exception {
        Response result=new Response();
       try {
           // 根据流程实例ID查询任务
           TaskService taskService = engine.getTaskService();

           Task task = taskService.createTaskQuery().processInstanceId(instance.getInstanceID()).singleResult();
           String nodeId=task.getTaskDefinitionKey();
           HashMap<String, List<String>> transitionMap=instance.getTransitionMap();
           if(transitionMap!=null){
               List<String> list= transitionMap.get(nodeId);
               //为空或不包含,则返回false
               if(list==null||!list.contains(instance.getTransition())){
                   result.setStatus(Status.FAILED);
                   result.setMessage("执行异常");

                   log.error(MessageFormat.format(
                           "ActivityController.doworkflow.error.transitionerror,nowNodeId:{0},instanceid:{1},trunDir:{2}"
                           ,nodeId,instance.getInstanceID(),instance.getTransition()));
                   return result;
               }
           }

           // 完成任务任务
           Map<String, Object> variables = new HashMap<String, Object>();
           variables.put("transition", instance.getTransition());// 流转transition条件
           if(!StringUtils.isEmpty(instance.getResult())){
               variables.put("result",instance.getResult());
           }
           taskService.complete(task.getId(), variables);
           result.setStatus(Status.SUCCESS);
           result.setMessage("执行成功");
           log.info(MessageFormat.format("ActivityController.doworkflow.sucess,instanceid:{0},trunDir:{1}",instance.getInstanceID(),instance.getTransition()));
           return result;
       }
       catch (Exception ex)
       {
           log.error(MessageFormat.format("ActivityController.doworkflow.error,instanceid:{0},trunDir:{1}",instance.getInstanceID(),instance.getTransition()));
           log.error("errorinfo:"+ex.getMessage(),ex);
           result.setStatus(Status.FAILED);
           result.setMessage("执行异常");
           return  result;
       }

    }
    /**
     * 查询当前节点信息。
     * @param instanceid
     * @return
     * @throws Exception
     */
    @ApiOperation(value="查询当前节点信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/findTaskTransition")
    @ResponseBody
    public ResponseResult<Object> findTaskTransition(@RequestParam("instanceid") String instanceid) throws Exception {
        ResponseResult<Object> result = new ResponseResult<Object>();
        try {
            Map<String, String> nodeMap = new HashMap<String, String>();
            // 根据流程实例ID查询任务
            TaskService taskService = engine.getTaskService();
            //查询当前节点
            Task task = taskService.createTaskQuery().processInstanceId(instanceid).singleResult();
            //Task task = taskService.createTaskQuery().processInstanceId(instance.getInstanceID()).singleResult();
            RuntimeService runtimeService = engine.getRuntimeService();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(instanceid)
                    .singleResult();
            //HistoricTaskInstance histask = findHistricTaskById(taskId, processInstance.getProcessInstanceId());
            //查询流程定义 。
            RepositoryService repositoryService = engine.getRepositoryService();
            HistoryService historyService = engine.getHistoryService();
            BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
            List<org.activiti.bpmn.model.Process> listp = bpmnModel.getProcesses();
            org.activiti.bpmn.model.Process process = listp.get(0);
            //当前节点流定义
            FlowNode sourceFlowElement = (FlowNode) process.getFlowElement(task.getTaskDefinitionKey());
            //Map<String, List<ExtensionAttribute>> ss= sourceFlowElement.getAttributes();
            List<SequenceFlow> list = sourceFlowElement.getOutgoingFlows();
            nodeMap.put("formkey",((UserTask) sourceFlowElement).getFormKey());
            String notename="";
            for (SequenceFlow sf : list) {
                sf.getConditionExpression();
                notename+=sf.getName()+",";
            }
            nodeMap.put("transitions",notename);
            //	找到当前任务的流程变量
            // List<HistoricVariableInstance> listVar = historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).list();
            //iteratorNextNodes(process, sourceFlowElement, nodeMap, listVar);
            result.setData(nodeMap);
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            log.error("执行工作流任务findNextTask方法出错，错误信息：" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常");
            return result;

        }
    }

    /**
     * 查询流程当前节点的下一步节点。用于流程提示时的提示。
     * @param instanceid
     * @return
     * @throws Exception
     */
    @ApiOperation(value="查询工作流任务",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/findNextTask")
    @ResponseBody
    public ResponseResult<Object> findNextTask(@RequestParam("instanceid") String instanceid) throws Exception {
        ResponseResult<Object> result = new ResponseResult<Object>();
        try {
            Map<String, org.activiti.bpmn.model.FlowNode> nodeMap = new HashMap<String, org.activiti.bpmn.model.FlowNode>();

            // 根据流程实例ID查询任务
            TaskService taskService = engine.getTaskService();
//查询当前节点
            Task task = taskService.createTaskQuery().processInstanceId(instanceid).singleResult();
            //Task task = taskService.createTaskQuery().processInstanceId(instance.getInstanceID()).singleResult();
            RuntimeService runtimeService = engine.getRuntimeService();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(instanceid)
                    .singleResult();
            //HistoricTaskInstance histask = findHistricTaskById(taskId, processInstance.getProcessInstanceId());
            //查询流程定义 。
            RepositoryService repositoryService = engine.getRepositoryService();
            HistoryService historyService = engine.getHistoryService();
            BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
            List<org.activiti.bpmn.model.Process> listp = bpmnModel.getProcesses();
            org.activiti.bpmn.model.Process process = listp.get(0);
            //当前节点流定义
            FlowNode sourceFlowElement = (FlowNode) process.getFlowElement(task.getTaskDefinitionKey());
            //	找到当前任务的流程变量
            List<HistoricVariableInstance> listVar = historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getId()).list();
            iteratorNextNodes(process, sourceFlowElement, nodeMap, listVar);
            result.setData(nodeMap);
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            log.error("执行工作流任务findNextTask方法出错，错误信息：" + ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常");
            return result;

        }
    }

    private void iteratorNextNodes(org.activiti.bpmn.model.Process process, FlowNode sourceFlowElement, Map<String,  FlowNode> nodeMap,List<HistoricVariableInstance> listVar)
            throws Exception {
        List<SequenceFlow> list = sourceFlowElement.getOutgoingFlows();
        for (SequenceFlow sf : list) {
            sourceFlowElement = ( FlowNode) process.getFlowElement( sf.getTargetRef());
            if(StringUtils.isNotEmpty(sf.getConditionExpression() )){
                ExpressionFactory factory = new ExpressionFactoryImpl();
                SimpleContext context = new SimpleContext();
                for(HistoricVariableInstance var :listVar){
                    context.setVariable(var.getVariableName(), factory.createValueExpression(var.getValue(), var.getValue().getClass()));
                }
                ValueExpression e = factory.createValueExpression(context, sf.getConditionExpression(), boolean.class);
                if((Boolean)e.getValue(context)){
                    nodeMap.put(sourceFlowElement.getId(), sourceFlowElement);
                    break;
                }
            }
            if (sourceFlowElement instanceof org.activiti.bpmn.model.UserTask) {
                nodeMap.put(sourceFlowElement.getId(), sourceFlowElement);
                break;
            }else if (sourceFlowElement instanceof org.activiti.bpmn.model.ExclusiveGateway) {
                iteratorNextNodes(process, sourceFlowElement, nodeMap,listVar);
            }
        }
    }




}

