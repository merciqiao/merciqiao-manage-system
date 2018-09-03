package com.car.modules.workflow.jbpm4task.dao;

import com.car.modules.workflow.jbpm4task.dto.Jbpm4TaskDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
@Repository
public interface Jbpm4TaskDao {
    public List<Jbpm4TaskDTO> searchJbpm4TaskByPaging(Map<String, Object> searchParams) ;
    
    public List<Jbpm4TaskDTO> searchJbpm4Task(Map<String, Object> searchParams);

    public Jbpm4TaskDTO findJbpm4TaskByPrimaryKey(String id);
    
    public int insertJbpm4Task(Map<String, Object> paramMap);
    
    public void updateJbpm4Task(Map<String, Object> paramMap);

    public Jbpm4TaskDTO queryLikeJbpm4Task(Map<String, Object> paramMap);

    public int deleteJbpm4TaskByID(Map<String, Object> paramMap);

    /**
     * 更新任务处理人，sql并发控制派单池重复派单
     *
     * @param taskId
     * @param toUserId
     * @param boolValue
     * @return
     */
    int updateAssigneeByPrimaryKey(@Param("taskId") long taskId, @Param("toUserId") String toUserId, @Param("boolValue") boolean boolValue);

    /**
     * 获取没有分配的task
     * @param params
     * @return
     */
    List<Map<String,Object>> listTaskOfNoAssignee(Map<String,Object> params);
}
