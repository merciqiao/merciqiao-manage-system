package com.carloan.service.admin.sysrole.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.admin.sysrole.dto.SysRoleDTO;

public interface SysRoleDao {
    public List<SysRoleDTO> searchSysRoleByPaging(Map<String, Object> searchParams) ;
    
    public List<SysRoleDTO> searchSysRole(Map<String,Object> searchParams);

    public SysRoleDTO findSysRoleByPrimaryKey(String id);
    
    public int insertSysRole(Map<String, Object> paramMap);
    
    public void updateSysRole(Map<String, Object> paramMap);

    public SysRoleDTO queryLikeSysRole(Map<String, Object> paramMap);
    public int deleteSysRoleById(String id);

    /**
     * 根据userid查询所属角色集合
     * @param paramMap
     * @return
     */
    List<SysRoleDTO> selectSysRoleByUserId(Map<String, Object> paramMap);
}
