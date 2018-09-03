
package com.carloan.service.admin.sysorg.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.service.admin.sysorg.dao.SysOrgDao;
import com.carloan.service.admin.sysorg.dto.SysOrgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @classname: SysOrgService
 * @description: 定义  sys_org 实现类
 * @author:  root
 */
@Service
public class SysOrgService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysOrgDao dao;

	public List<SysOrgDTO> searchSysOrgByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysOrgDTO> dataList =  dao.searchSysOrgByPaging(searchParams);
		return dataList;
	}
	public List<SysOrgDTO> searchSysOrg(SysOrgDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysOrgDTO> dataList = dao.searchSysOrg(paramMap);
        return dataList;
    }
	public SysOrgDTO querySysOrgByPrimaryKey(String id) throws Exception {
		SysOrgDTO dto = dao.findSysOrgByPrimaryKey(id);
		if(dto == null) dto = new SysOrgDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysOrg(SysOrgDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysOrg(paramMap);
		SysOrgDTO resultDto = (SysOrgDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysOrg(SysOrgDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysOrg(paramMap);
		}

    public SysOrgDTO queryLikeSysOrg(SysOrgDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysOrg(paramMap);
		}
		public boolean deleteOrgByID(String id) throws Exception
		{
			Integer rel = dao.deleteOrgByID(id);
			if(rel>0) {
				return false;
			}
			else {
				return false;
			}
		}

}

