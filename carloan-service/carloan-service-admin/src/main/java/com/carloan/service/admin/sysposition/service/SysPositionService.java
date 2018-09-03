
package com.carloan.service.admin.sysposition.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysPositionParam;
import com.carloan.common.web.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysposition.dto.SysPositionDTO;
import com.carloan.service.admin.sysposition.dao.SysPositionDao;

/**
 * @classname: SysPositionService
 * @description: 定义  sys_position 实现类
 * @author:  root
 */
@Service
public class SysPositionService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysPositionDao dao;

	public List<SysPositionDTO> searchSysPositionByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysPositionDTO> dataList =  dao.searchSysPositionByPaging(searchParams);
		return dataList;
	}
	@Page
	public Object searchSysPosition(SysPositionParam dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysPositionDTO> dataList = dao.searchSysPosition(paramMap);
        return dataList;
    }
	public SysPositionDTO querySysPositionByPrimaryKey(String id) throws Exception {
		SysPositionDTO dto = dao.findSysPositionByPrimaryKey(id);
		if(dto == null) dto = new SysPositionDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysPosition(SysPositionDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysPosition(paramMap);
		SysPositionDTO resultDto = (SysPositionDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysPosition(SysPositionDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysPosition(paramMap);
		}

    public SysPositionDTO queryLikeSysPosition(SysPositionDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysPosition(paramMap);
		}

	public void deleteSysPositionByPrimaryKey(String ids)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("ids",ids);
		dao.deleteSysPositionByPrimaryKey(paramMap);
	}

}

