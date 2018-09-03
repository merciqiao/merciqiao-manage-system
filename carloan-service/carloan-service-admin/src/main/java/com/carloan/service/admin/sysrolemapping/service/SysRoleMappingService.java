
package com.carloan.service.admin.sysrolemapping.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysRoleMappingParam;
import com.carloan.common.web.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysrolemapping.dto.SysRoleMappingDTO;
import com.carloan.service.admin.sysrolemapping.dao.SysRoleMappingDao;

/**
 * @classname: SysRoleMappingService
 * @description: 定义  sys_role_mapping 实现类
 * @author:  root
 */
@Service
public class SysRoleMappingService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysRoleMappingDao dao;

	public List<SysRoleMappingDTO> searchSysRoleMappingByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysRoleMappingDTO> dataList =  dao.searchSysRoleMappingByPaging(searchParams);
		return dataList;
	}
	@Page
	public Object searchSysRoleMapping(SysRoleMappingParam dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysRoleMappingDTO> dataList = dao.searchSysRoleMapping(paramMap);
        return dataList;
    }
	public SysRoleMappingDTO querySysRoleMappingByPrimaryKey(String id) throws Exception {
		SysRoleMappingDTO dto = dao.findSysRoleMappingByPrimaryKey(id);
		if(dto == null) dto = new SysRoleMappingDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysRoleMapping(SysRoleMappingDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysRoleMapping(paramMap);
		SysRoleMappingDTO resultDto = (SysRoleMappingDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysRoleMapping(SysRoleMappingDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysRoleMapping(paramMap);
		}

    public SysRoleMappingDTO queryLikeSysRoleMapping(SysRoleMappingDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysRoleMapping(paramMap);
		}
		public Boolean deleteSysRoleMapping(String ids)
		{
			int rel=dao.deleteSysRoleMapping(ids);
			if(rel>0) {
				return true;
			}
			else {
				return false;
			}
		}

}

