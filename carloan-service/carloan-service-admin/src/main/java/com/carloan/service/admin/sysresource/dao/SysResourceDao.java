package com.carloan.service.admin.sysresource.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.admin.sysresource.dto.SysResourceDTO;

public interface SysResourceDao {
    public List<SysResourceDTO> searchSysResourceByPaging(Map<String, Object> searchParams) ;
    
    public List<SysResourceDTO> searchSysResource(Map<String,Object> searchParams);

    public SysResourceDTO findSysResourceByPrimaryKey(String id);
    
    public int insertSysResource(Map<String, Object> paramMap);
    
    public void updateSysResource(Map<String, Object> paramMap);

    public SysResourceDTO queryLikeSysResource(Map<String, Object> paramMap);
    public int deleteResourceByID(String id);
    /**
     * 根据userid查询shiro的权限
     * @param paramMap
     * @return
     */
    public List<SysResourceDTO> selectShiroUrlPermissionByUserId(Map<String, Object> paramMap);
    
}
