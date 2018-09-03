package com.car.modules.jbpm.dao;

import com.car.modules.jbpm.dto.MyTaskDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-06-28.
 */
public interface MyTaskDao {
    public List<MyTaskDTO> searchCarMyTaskByPaging(Map<String,Object> searchParams);
    public List<MyTaskDTO> searchCaDonerMyTaskByPaging(Map<String,Object> searchParams);
    public List<MyTaskDTO> searchCarEndMyTaskByPaging(Map<String,Object> searchParams);
    public void updateCarStartEndTime(Map<String,Object> searchParams);
}
