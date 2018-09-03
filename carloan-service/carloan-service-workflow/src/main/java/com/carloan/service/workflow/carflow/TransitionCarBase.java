package com.carloan.service.workflow.carflow;

import com.carloan.apimodel.activiti.dto.ActivitiInstanceInfoVO;
import com.carloan.apimodel.common.Response;
import com.carloan.feign.activity.ActivityFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 流转基类
 */
@Component
@Slf4j
public class TransitionCarBase {
    /**
     * 存储节点名称和有效transition
     */
    private HashMap<String, List<String>> transitionMap;
    @PostConstruct
    void  init(){
        transitionMap = new HashMap<>();
        //复议---start
        List<String> fuyiList= new ArrayList<>();
        fuyiList.add("同意");
        fuyiList.add("拒绝");
        transitionMap.put("fuyi",fuyiList);//节点id和transition的名称
        //复议---end

        //定价---start
        List<String> dingjiaList= new ArrayList<>();
        dingjiaList.add("同意");
        dingjiaList.add("拒绝");
        dingjiaList.add("回退");
        transitionMap.put("dingjia",dingjiaList);
        //定价---end

        //信审---start
        List<String> shenheList= new ArrayList<>();
        shenheList.add("回退补件");
        shenheList.add("审核拒绝");
        shenheList.add("审核同意");
        shenheList.add("疑似欺诈");
        transitionMap.put("shenhe",shenheList);

        List<String> fuheList= new ArrayList<>();
        fuheList.add("回退审核");
        fuheList.add("复核拒绝");
        fuheList.add("复核同意");
        fuheList.add("疑似欺诈");
        transitionMap.put("fuhe",fuheList);

        List<String> fanqizha1List= new ArrayList<>();
        fanqizha1List.add("非欺诈");
        fanqizha1List.add("回退审核");
        fanqizha1List.add("欺诈");
        transitionMap.put("fanqizha1",fanqizha1List);

        List<String> fanqizha2List= new ArrayList<>();
        fanqizha2List.add("非欺诈");
        fanqizha2List.add("回退复核");
        fanqizha2List.add("欺诈");
        transitionMap.put("fanqizha2",fanqizha2List);
        //信审---end

        //公共---start
        //客户补充资料
        List<String> bujianList= new ArrayList<>();
        bujianList.add("补件");
        transitionMap.put("bujian",bujianList);
        //定价---end
    }
    @Autowired
    ActivityFeign activityFeign;
    public Boolean doWorkFlow(String taskId,String turnDir){
        ActivitiInstanceInfoVO doActiveParamVo=new ActivitiInstanceInfoVO();
        doActiveParamVo.setInstanceID(taskId);
        doActiveParamVo.setTransition(turnDir);
        if(transitionMap==null){
            init();
        }
        doActiveParamVo.setTransitionMap(transitionMap);
        Response response= activityFeign.doworkflow(doActiveParamVo);
        if(Response.isSucess(response)){
            log.info(MessageFormat.format("doWorkFlow.sucess,taskId:{0},turnDir:{1}",taskId,turnDir));
            return true;
        }
        else {
            log.error(MessageFormat.format("doWorkFlow.error,taskId:{0},turnDir:{1}",taskId,turnDir));
            return false;
        }
    }
}
