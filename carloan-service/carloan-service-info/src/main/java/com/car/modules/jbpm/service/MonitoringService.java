package com.car.modules.jbpm.service;

import com.car.modules.jbpm.dao.MonitoringDao;

import com.car.modules.jbpm.dto.MyTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-06-28.
 */
@Service("com.car.modules.jbpm.service.MonitoringService")
public class MonitoringService {
    private static final long serialVersionUID = 1L;

    @Autowired
    private MonitoringDao monitoringDao;
    public List<MyTaskDTO> searchMonitorTodoByPaging(Map<String,Object> searchParams)
    {
        List<MyTaskDTO> listMyTaskDTO= monitoringDao.searchMonitorTodoByPaging(searchParams);
        return  listMyTaskDTO;
    }
    public List<MyTaskDTO> searchMonitorToneByPaging(Map<String,Object> searchParams)
    {
        List<MyTaskDTO> listMyTaskDTO= monitoringDao.searchMonitorToneByPaging(searchParams);
        return  listMyTaskDTO;
    }
    public List<MyTaskDTO> searchMonitorEndByPaging(Map<String,Object> searchParams)
    {
        List<MyTaskDTO> listMyTaskDTO= monitoringDao.searchMonitorEndByPaging(searchParams);
        return  listMyTaskDTO;
    }
}
