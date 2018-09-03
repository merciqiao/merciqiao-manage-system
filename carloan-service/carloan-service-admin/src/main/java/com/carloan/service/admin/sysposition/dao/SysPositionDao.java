package com.carloan.service.admin.sysposition.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.admin.sysposition.dto.SysPositionDTO;

public interface SysPositionDao {
    public List<SysPositionDTO> searchSysPositionByPaging(Map<String, Object> searchParams) ;
    
    public List<SysPositionDTO> searchSysPosition(Map<String,Object> searchParams);

    public SysPositionDTO findSysPositionByPrimaryKey(String id);
    
    public int insertSysPosition(Map<String, Object> paramMap);
    
    public void updateSysPosition(Map<String, Object> paramMap);

    public SysPositionDTO queryLikeSysPosition(Map<String, Object> paramMap);

    public void deleteSysPositionByPrimaryKey(Map<String, Object> paramMap);
    
}
