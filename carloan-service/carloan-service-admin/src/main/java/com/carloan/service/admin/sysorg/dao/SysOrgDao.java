package com.carloan.service.admin.sysorg.dao;

import com.carloan.service.admin.sysorg.dto.SysOrgDTO;

import java.util.List;
import java.util.Map;


public interface SysOrgDao {
    public List<SysOrgDTO> searchSysOrgByPaging(Map<String, Object> searchParams) ;
    
    public List<SysOrgDTO> searchSysOrg(Map<String,Object> searchParams);

    public SysOrgDTO findSysOrgByPrimaryKey(String id);
    
    public int insertSysOrg(Map<String, Object> paramMap);
    
    public void updateSysOrg(Map<String, Object> paramMap);

    public SysOrgDTO queryLikeSysOrg(Map<String, Object> paramMap);

    public int deleteOrgByID(String id);

    
}
