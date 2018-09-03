package com.carloan.service.admin.sysacl.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.admin.sysacl.dto.SysAclDTO;
import org.apache.ibatis.annotations.Param;

public interface SysAclDao {
    public List<SysAclDTO> searchSysAclByPaging(Map<String, Object> searchParams);

    public List<SysAclDTO> searchSysAcl(Map<String, Object> searchParams);

    public SysAclDTO findSysAclByPrimaryKey(String id);

    public int insertSysAcl(@Param("roleId") long roleId, @Param("resourceIds") String[] resourceIds);

    public void updateSysAcl(Map<String, Object> paramMap);

    public void deleteSysAcl(Map<String, Object> paramMap);

    public int deleteSysAclByRoleid(String roleid);

    public SysAclDTO queryLikeSysAcl(Map<String, Object> paramMap);


}
