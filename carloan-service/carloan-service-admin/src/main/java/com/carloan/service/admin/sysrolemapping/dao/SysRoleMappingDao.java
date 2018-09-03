package com.carloan.service.admin.sysrolemapping.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.admin.sysrolemapping.dto.SysRoleMappingDTO;

public interface SysRoleMappingDao {
    public List<SysRoleMappingDTO> searchSysRoleMappingByPaging(Map<String, Object> searchParams) ;
    
    public List<SysRoleMappingDTO> searchSysRoleMapping(Map<String,Object> searchParams);

    public SysRoleMappingDTO findSysRoleMappingByPrimaryKey(String id);
    
    public int insertSysRoleMapping(Map<String, Object> paramMap);
    
    public void updateSysRoleMapping(Map<String, Object> paramMap);

    public SysRoleMappingDTO queryLikeSysRoleMapping(Map<String, Object> paramMap);

    public int deleteSysRoleMapping(String ids);

    
}
