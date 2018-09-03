package com.car.modules.workflow.jbpm4histtask.dao;

import java.util.List;
import java.util.Map;

import com.car.modules.workflow.jbpm4histtask.dto.Jbpm4HistTaskDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Jbpm4HistTaskDao {
    public List<Jbpm4HistTaskDTO> searchJbpm4HistTaskByPaging(Map<String, Object> searchParams) ;
    
    public List<Jbpm4HistTaskDTO> searchJbpm4HistTask(Map<String, Object> searchParams);

    public Jbpm4HistTaskDTO findJbpm4HistTaskByPrimaryKey(String id);
    
    public int insertJbpm4HistTask(Map<String, Object> paramMap);
    
    public int updateJbpm4HistTask(Map<String, Object> paramMap);

    public Jbpm4HistTaskDTO queryLikeJbpm4HistTask(Map<String, Object> paramMap);
    public List<Jbpm4HistTaskDTO> searchHistTaskByOrdernum(String ordernum);

    /**
     * 获取节点的历史处理人
     * @param proInstanceId
     * @param activityName
     * @return
     */
    Jbpm4HistTaskDTO getHisUserOfActiveByProInstId(@Param("proInstanceId") String proInstanceId,@Param("activityName") String activityName);

    /**
     * 更新任务处理人，sql并发控制派单池重复派单
     *
     * @param taskId
     * @param toUserId
     * @return
     */
    int updateAssigneeByPrimaryKey(@Param("taskId") long taskId, @Param("toUserId") String toUserId);
}
