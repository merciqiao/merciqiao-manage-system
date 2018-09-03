package com.car.modules.jbpm.service;

import com.car.modules.jbpm.dao.MyTaskDao;
import com.car.modules.jbpm.dto.MyTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-06-28.
 */
@Service("com.car.modules.jbpm.service.MyTaskService")
public class MyTaskService {
    private static final long serialVersionUID = 1L;

    @Autowired
    private MyTaskDao myTaskDao;
    public List<MyTaskDTO> searchCarMyTodoTaskByPaging(Map<String,Object> searchParams)
    {
        List<MyTaskDTO> listMyTaskDTO= myTaskDao.searchCarMyTaskByPaging(searchParams);
        return  listMyTaskDTO;
    }
    public List<MyTaskDTO> searchCaDonerMyTaskByPaging(Map<String,Object> searchParams)
    {
        List<MyTaskDTO> listMyTaskDTO= myTaskDao.searchCaDonerMyTaskByPaging(searchParams);
        return  listMyTaskDTO;
    }
    public List<MyTaskDTO> searchCarEndMyTaskByPaging(Map<String,Object> searchParams)
    {
        List<MyTaskDTO> listMyTaskDTO= myTaskDao.searchCarEndMyTaskByPaging(searchParams);
        return  listMyTaskDTO;
    }
    public void updateCarStartEndTime(Map<String,Object> searchParams)
    {
        myTaskDao.updateCarStartEndTime(searchParams);

    }
}
