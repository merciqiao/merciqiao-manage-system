
package com.carloan.service.admin.sysrole.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysRoleParam;
import com.carloan.common.web.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysrole.dto.SysRoleDTO;
import com.carloan.service.admin.sysrole.dao.SysRoleDao;

/**
 * @classname: SysRoleService
 * @description: 定义  sys_role 实现类
 * @author: root
 */
@Service
public class SysRoleService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private SysRoleDao dao;

    public List<SysRoleDTO> searchSysRoleByPaging(Map<String, Object> searchParams) throws Exception {
        List<SysRoleDTO> dataList = dao.searchSysRoleByPaging(searchParams);
        return dataList;
    }

    @Page
    public Object searchSysRole(SysRoleParam dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        List<SysRoleDTO> dataList = dao.searchSysRole(paramMap);
        return dataList;
    }

    public SysRoleDTO querySysRoleByPrimaryKey(String id) throws Exception {
        SysRoleDTO dto = dao.findSysRoleByPrimaryKey(id);
        if (dto == null) dto = new SysRoleDTO();
        return dto;

    }

    @SuppressWarnings("all")
    @Transactional(rollbackFor = {Exception.class})
    public Long insertSysRole(SysRoleDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int count = dao.insertSysRole(paramMap);
        SysRoleDTO resultDto = (SysRoleDTO) paramMap.get("dto");
        Long keyId = resultDto.getId();
        return keyId;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateSysRole(SysRoleDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        dao.updateSysRole(paramMap);
    }

    public SysRoleDTO queryLikeSysRole(SysRoleDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        return dao.queryLikeSysRole(paramMap);
    }

    public boolean deleteSysRoleById(String id) throws Exception {
        int count = dao.deleteSysRoleById(id);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 根据userid查询所属角色集合
     * @param dto
     * @return
     */
    public List<SysRoleDTO> selectSysRoleByUserId(SysRoleDTO dto){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        return dao.selectSysRoleByUserId(paramMap);
    }
}

