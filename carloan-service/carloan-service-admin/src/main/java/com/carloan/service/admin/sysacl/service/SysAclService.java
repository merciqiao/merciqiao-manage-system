
package com.carloan.service.admin.sysacl.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysAclParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysacl.dto.SysAclDTO;
import com.carloan.service.admin.sysacl.dao.SysAclDao;

/**
 * @classname: SysAclService
 * @description: 定义  sys_acl 实现类
 * @author:  root
 */
@Service
public class SysAclService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysAclDao dao;

	public List<SysAclDTO> searchSysAclByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysAclDTO> dataList =  dao.searchSysAclByPaging(searchParams);
		return dataList;
	}
	public List<SysAclDTO> searchSysAcl(SysAclParam dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysAclDTO> dataList = dao.searchSysAcl(paramMap);
        return dataList;
    }
	public SysAclDTO querySysAclByPrimaryKey(String id) throws Exception {
		SysAclDTO dto = dao.findSysAclByPrimaryKey(id);
		if(dto == null) dto = new SysAclDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Boolean insertSysAcl(SysAclDTO dto) throws Exception {
		dao.deleteSysAclByRoleid(dto.getRoleId().toString());
		int count = dao.insertSysAcl(dto.getRoleId(),dto.getResourceids());
		return count>0;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysAcl(SysAclDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysAcl(paramMap);
		}

    public SysAclDTO queryLikeSysAcl(SysAclDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysAcl(paramMap);
		}
	@Transactional(rollbackFor = {Exception.class})
	public void deleteSysAcl(String ids)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("ids",ids);
		dao.deleteSysAcl(paramMap);
	}


}

