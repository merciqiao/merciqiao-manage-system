package com.car.modules.workflow.jbpm.dao;

import com.car.modules.workflow.jbpm.entity.Jbpm4ConsignedTask;

public interface Jbpm4ConsignedTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Jbpm4ConsignedTask consignedTask);

    Jbpm4ConsignedTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Jbpm4ConsignedTask consignedTask);

    int updateByPrimaryKey(Jbpm4ConsignedTask consignedTask);
}