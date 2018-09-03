
package com.carloan.service.admin.sysmenu.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysMenuParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysmenu.dto.SysMenuDTO;
import com.carloan.service.admin.sysmenu.dao.SysMenuDao;

/**
 * @classname: SysMenuService
 * @description: 定义  sys_menu 实现类
 * @author:  root
 */
@Service
public class SysMenuService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SysMenuDao dao;

	public List<SysMenuDTO> searchSysMenuByPaging(Map<String, Object> searchParams) throws Exception {
		List<SysMenuDTO> dataList = dao.searchSysMenuByPaging(searchParams);
		return dataList;
	}

	public List<SysMenuDTO> searchSysMenu(SysMenuParam dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		List<SysMenuDTO> dataList = dao.searchSysMenu(paramMap);
		return dataList;
	}

	public SysMenuDTO querySysMenuByPrimaryKey(String id) throws Exception {
		SysMenuDTO dto = dao.findSysMenuByPrimaryKey(id);
		if (dto == null) dto = new SysMenuDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysMenu(SysMenuDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysMenu(paramMap);
		SysMenuDTO resultDto = (SysMenuDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}

	@Transactional(rollbackFor = {Exception.class})
	public void updateSysMenu(SysMenuDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		dao.updateSysMenu(paramMap);
	}

	public SysMenuDTO queryLikeSysMenu(SysMenuDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysMenu(paramMap);
	}
	@Transactional(rollbackFor = {Exception.class})
	public void deleteSysMenu(String ids) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ids", ids);
		dao.deleteSysMenu(paramMap);
	}

}

