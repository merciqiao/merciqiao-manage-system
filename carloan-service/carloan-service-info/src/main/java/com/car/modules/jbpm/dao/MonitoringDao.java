package com.car.modules.jbpm.dao;

import com.car.modules.jbpm.dto.MyTaskDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-06-28.
 */
public interface MonitoringDao {
    public List<MyTaskDTO> searchMonitorTodoByPaging(Map<String, Object> searchParams);
    public List<MyTaskDTO> searchMonitorToneByPaging(Map<String, Object> searchParams);
    public List<MyTaskDTO> searchMonitorEndByPaging(Map<String, Object> searchParams);
}
