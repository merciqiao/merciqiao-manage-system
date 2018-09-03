package com.carloan.service.admin.sysuser.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.admin.sysuser.dto.SysUserDTO;

public interface SysUserDao {
    public List<SysUserDTO> searchSysUserByPaging(Map<String, Object> searchParams) ;
    
    public List<SysUserDTO> searchSysUser(Map<String,Object> searchParams);

    public SysUserDTO findSysUserByPrimaryKey(String id);
    
    public int insertSysUser(Map<String, Object> paramMap);
    
    public void updateSysUser(Map<String, Object> paramMap);
    public void deleteSysUserByPrimaryKey(Map<String, Object> paramMap);

    public SysUserDTO queryLikeSysUser(Map<String, Object> paramMap);

    
}
