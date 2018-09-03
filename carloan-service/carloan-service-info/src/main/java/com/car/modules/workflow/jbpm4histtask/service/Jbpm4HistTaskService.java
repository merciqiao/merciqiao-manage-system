
package com.car.modules.workflow.jbpm4histtask.service;

import com.car.modules.workflow.jbpm4histtask.dao.Jbpm4HistTaskDao;
import com.car.modules.workflow.jbpm4histtask.dto.Jbpm4HistTaskDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 /*
                           _ooOoo_
                          o8888888o
                          88" . "88
                          (| -_- |)
                          O\  =  /O
                       ____/`---'\____
                     .'  \\|     |//  `.
                    /  \\|||  :  |||//  \
                   /  _||||| -:- |||||-  \
                   |   | \\\  -  /// |   |
                   | \_|  ''\---/''  |   |
                   \  .-\__  `-`  ___/-. /
                 ___`. .'  /--.--\  `. . __
              ."" '<  `.___\_<|>_/___.'  >'"".
             | | :  `- \`.;`\ _ /`;.`/ - ` : | |
             \  \ `-.   \_ __\ /__ _/   .-` /  /
        ======`-.____`-.___\_____/___.-`____.-'======
                           `=---='
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                 佛祖保佑       永无BUG
 */

/**
 * @classname: Jbpm4HistTaskService
 * @description: 定义  jbpm4_hist_task 实现类
 * @author: root
 */
@Service
public class Jbpm4HistTaskService implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Logger logger = LoggerFactory.getLogger(Jbpm4HistTaskService.class);

    @Autowired
    private Jbpm4HistTaskDao dao;

    public List<Jbpm4HistTaskDTO> searchJbpm4HistTaskByPaging(Map<String, Object> searchParams) throws Exception {
        List<Jbpm4HistTaskDTO> dataList = dao.searchJbpm4HistTaskByPaging(searchParams);
        return dataList;
    }

    public List<Jbpm4HistTaskDTO> searchJbpm4HistTask(Jbpm4HistTaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        List<Jbpm4HistTaskDTO> dataList = dao.searchJbpm4HistTask(paramMap);
        return dataList;
    }

    public Jbpm4HistTaskDTO queryJbpm4HistTaskByPrimaryKey(String id) throws Exception {
        Jbpm4HistTaskDTO dto = dao.findJbpm4HistTaskByPrimaryKey(id);
        if (dto == null) dto = new Jbpm4HistTaskDTO();
        return dto;

    }

    @SuppressWarnings("all")
    @Transactional(rollbackFor = {Exception.class})
    public Boolean insertJbpm4HistTask(Jbpm4HistTaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int count = dao.insertJbpm4HistTask(paramMap);
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean updateJbpm4HistTask(Jbpm4HistTaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int i= dao.updateJbpm4HistTask(paramMap);
        if(i>0){
            return true;
        }
        else{
            return false;
        }

    }

    public Jbpm4HistTaskDTO queryLikeJbpm4HistTask(Jbpm4HistTaskDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        return dao.queryLikeJbpm4HistTask(paramMap);
    }
    public List<Jbpm4HistTaskDTO> searchHistTaskByOrdernum(String ordernum) throws Exception {
        List<Jbpm4HistTaskDTO> dataList = dao.searchHistTaskByOrdernum(ordernum);
        for (int i = 0; i < dataList.size(); i++) {
            StringBuilder describe = new StringBuilder();
            String userName1 = "";
            String userName2 = "";
            if (i > 0) {
                userName1=dataList.get(i-1).getAssignee();

            }
            userName2=dataList.get(i).getAssignee();
            describe.append(userName1 == null ? "" : userName1).append("-->").append(userName2 == null ? "" : userName2);
            dataList.get(i).setDescribe(describe.toString());
        }
        return dataList;
    }

    /**
     * 获取节点的历史处理人
     *
     * @param proInstanceId
     * @param activityName
     * @return
     */
    public String getHisUserOfActiveByProInstId(String proInstanceId, String activityName) {
        String userId = "-1";
        if (StringUtils.isEmpty(proInstanceId) || StringUtils.isEmpty(activityName)) {
            logger.error("参数异常:IllegalArgumentException;proInstanceId:{},activityName:{}", proInstanceId, activityName);
            return userId;
        }
        Jbpm4HistTaskDTO jbpm4HistTaskDTO = dao.getHisUserOfActiveByProInstId(proInstanceId, activityName);

        if (jbpm4HistTaskDTO != null && StringUtils.isNotEmpty(jbpm4HistTaskDTO.getAssignee())) {
            userId = jbpm4HistTaskDTO.getAssignee();
        }
        return userId;
    }

    /**
     * 更新任务处理人，sql并发控制派单池重复派单
     *
     * @param taskId
     * @param toUserId
     * @return
     */
    public int updateAssigneeByPrimaryKey(long taskId, String toUserId) {
        return dao.updateAssigneeByPrimaryKey(taskId, toUserId);
    }
}

