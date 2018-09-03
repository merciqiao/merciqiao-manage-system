package com.carloan.service.master.sysconfig.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.master.sysconfig.dto.SysConfigDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface SysConfigDao {
    int insertSysConfig(Map<String, Object> paramMap);

    void updateSysConfig(Map<String, Object> paramMap);

    void deleteSysConfig(Map<String, Object> var1);

    List<SysConfigDTO> queryPage(Map<String, Object> searchParams);

    SysConfigDTO findSysConfigByPrimaryKey(String id);

    String getValueByCode(String code);
}
