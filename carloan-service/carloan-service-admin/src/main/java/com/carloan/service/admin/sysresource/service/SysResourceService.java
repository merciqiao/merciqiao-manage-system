
package com.carloan.service.admin.sysresource.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysResourceParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysresource.dto.SysResourceDTO;
import com.carloan.service.admin.sysresource.dao.SysResourceDao;

/**
 * @classname: SysResourceService
 * @description: 定义  sys_resource 实现类
 * @author: root
 */
@Service
public class SysResourceService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private SysResourceDao dao;

    public List<SysResourceDTO> searchSysResourceByPaging(Map<String, Object> searchParams) throws Exception {
        List<SysResourceDTO> dataList = dao.searchSysResourceByPaging(searchParams);
        return dataList;
    }

    public List<SysResourceDTO> searchSysResource(SysResourceParam dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        List<SysResourceDTO> dataList = dao.searchSysResource(paramMap);
        return dataList;
    }

    public SysResourceDTO querySysResourceByPrimaryKey(String id) throws Exception {
        SysResourceDTO dto = dao.findSysResourceByPrimaryKey(id);
        if (dto == null) dto = new SysResourceDTO();
        return dto;

    }

    @SuppressWarnings("all")
    @Transactional(rollbackFor = {Exception.class})
    public Long insertSysResource(SysResourceDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int count = dao.insertSysResource(paramMap);
        SysResourceDTO resultDto = (SysResourceDTO) paramMap.get("dto");
        Long keyId = resultDto.getId();
        return keyId;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateSysResource(SysResourceDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        dao.updateSysResource(paramMap);
    }

    public SysResourceDTO queryLikeSysResource(SysResourceDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        return dao.queryLikeSysResource(paramMap);
    }

    public boolean deleteResourceByID(String id) throws Exception {
        Integer rel = dao.deleteResourceByID(id);
        return rel > 0;
    }
    /**
     * 根据userid查询shiro的权限
     * @param dto
     * @return
     */
    public List<SysResourceDTO> selectShiroUrlPermissionByUserId(SysResourceDTO dto){

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        return dao.selectShiroUrlPermissionByUserId(paramMap);
    }
}

