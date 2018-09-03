package com.carloan.service.shiro.sysrole.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.carloan.service.shiro.sysrole.dto.SysRoleDTO;
import com.carloan.service.shiro.sysrole.dao.SysRoleDao;

/**
 * @classname: SysRoleService
 * @description: 定义  sys_role 实现类
 * @author:  root
 */
@Service
public class SysRoleService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private SysRoleDao dao;

	/**
     * @author root
     * @description: 分页查询 sys_role列表
     * @date 2018-06-22 02:10:07
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<SysRoleDTO> searchSysRoleByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysRoleDTO> dataList =  dao.searchSysRoleByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询sys_role列表
     * @date 2018-06-22 02:10:07
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<SysRoleDTO> searchSysRole(Map<String,Object> searchParams) throws Exception {
	    List<SysRoleDTO> dataList = dao.searchSysRole(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询sys_role对象
     * @date 2018-06-22 02:10:07
     * @param id
     * @return
     * @throws
     */ 
	public SysRoleDTO querySysRoleByPrimaryKey(String id) throws Exception {
		
		SysRoleDTO dto = dao.findSysRoleByPrimaryKey(id);
		
		if(dto == null) dto = new SysRoleDTO();
		
		return dto;
		
	}

	/**
     * @title: insertSysRole
     * @author root
     * @description: 新增 sys_role对象
     * @date 2018-06-22 02:10:07
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertSysRole(SysRoleDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertSysRole(paramMap);
		
		SysRoleDTO resultDto = (SysRoleDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateSysRole
     * @author root
     * @description: 修改 sys_role对象
     * @date 2018-06-22 02:10:07
     * @param paramMap
     * @return
     * @throws
     */
	public void updateSysRole(SysRoleDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateSysRole(paramMap);
	}
	/**
     * @title: deleteSysRoleByPrimaryKey
     * @author root
     * @description: 删除 sys_role,按主键
     * @date 2018-06-22 02:10:07
     * @param paramMap
     * @throws
     */ 
	public void deleteSysRoleByPrimaryKey(SysRoleDTO dto,String ids) throws Exception {
		if(StringUtils.isEmpty(ids)) throw new Exception("删除失败！传入的参数主键为null");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		paramMap.put("ids", ids);
		dao.deleteSysRoleByPrimaryKey(paramMap);
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

