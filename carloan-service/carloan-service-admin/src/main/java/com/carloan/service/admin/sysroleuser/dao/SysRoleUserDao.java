package com.carloan.service.admin.sysroleuser.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.admin.sysroleuser.dto.SysRoleUserDTO;

public interface SysRoleUserDao {
    public List<SysRoleUserDTO> searchSysRoleUserByPaging(Map<String, Object> searchParams) ;
    
    public List<SysRoleUserDTO> searchSysRoleUser(Map<String,Object> searchParams);

    public SysRoleUserDTO findSysRoleUserByPrimaryKey(String id);
    
    public int insertSysRoleUser(Map<String, Object> paramMap);
    
    public void updateSysRoleUser(Map<String, Object> paramMap);

    public SysRoleUserDTO queryLikeSysRoleUser(Map<String, Object> paramMap);

    public int  deleteSysRoleUserbyID(String id);

    
}
