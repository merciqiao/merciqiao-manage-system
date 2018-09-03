package com.carloan.service.master.sysconfig.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.carloan.service.master.sysconfig.dto.SysConfigDTO;
import com.carloan.service.master.sysconfig.dao.SysConfigDao;

@Service
public class SysConfigService {
    @Autowired
    private SysConfigDao dao;

    @SuppressWarnings("all")
    @Transactional(rollbackFor = {Exception.class})
    public Long insertSysConfig(SysConfigDTO dto) throws Exception {
        dto.setValidateState("1");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        int count = dao.insertSysConfig(paramMap);
        SysConfigDTO resultDto = (SysConfigDTO) paramMap.get("dto");
        Long keyId = resultDto.getId();
        return keyId;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateSysConfig(SysConfigDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dto", dto);
        dao.updateSysConfig(paramMap);
    }

    public void deleteSysConfig(String ids) throws Exception {
        if (StringUtils.isEmpty(ids)) {
            throw new Exception("删除失败！传入的参数主键为null");
        } else {
            HashMap paramMap = new HashMap();
            paramMap.put("ids", ids);
            this.dao.deleteSysConfig(paramMap);
        }
    }

    public PageInfo<SysConfigDTO> queryPage(SysConfigDTO dto) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dto", dto);
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        List<SysConfigDTO> list = dao.queryPage(paramMap);
        PageInfo<SysConfigDTO> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public SysConfigDTO querySysConfigByPrimaryKey(String id) throws Exception {
        SysConfigDTO dto = dao.findSysConfigByPrimaryKey(id);
        if (dto == null) dto = new SysConfigDTO();
        return dto;

    }

    public String getValueByCode(String code) throws Exception {
        return dao.getValueByCode(code);
    }
}
