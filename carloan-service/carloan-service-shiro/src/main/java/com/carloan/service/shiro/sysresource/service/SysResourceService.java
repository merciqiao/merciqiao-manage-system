package com.carloan.service.shiro.sysresource.service;

import com.carloan.service.shiro.sysresource.dao.SysResourceDao;
import com.carloan.service.shiro.sysresource.dto.SysResourceDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: SysResourceService
 * @description: 定义  sys_resource 实现类
 * @author:  root
 */
@Service
public class SysResourceService implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Autowired
	private SysResourceDao dao;

	/**
     * @author root
     * @description: 分页查询 sys_resource列表
     * @date 2018-06-22 09:09:44
     * @param searchParams 条件
     * @return
     * @throws
     */ 
	public List<SysResourceDTO> searchSysResourceByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysResourceDTO> dataList =  dao.searchSysResourceByPaging(searchParams);
		return dataList;
	}
	/**
     * @author root
     * @description: 按条件查询sys_resource列表
     * @date 2018-06-22 09:09:44
     * @param searchParams 条件
     * @return
     * @throws
     */
	public List<SysResourceDTO> searchSysResource(Map<String,Object> searchParams) throws Exception {
	    List<SysResourceDTO> dataList = dao.searchSysResource(searchParams);
        return dataList;
    }
	/**
     * @author root
     * @description: 查询sys_resource对象
     * @date 2018-06-22 09:09:44
     * @param id
     * @return
     * @throws
     */ 
	public SysResourceDTO querySysResourceByPrimaryKey(String id) throws Exception {
		
		SysResourceDTO dto = dao.findSysResourceByPrimaryKey(id);
		
		if(dto == null) dto = new SysResourceDTO();
		
		return dto;
		
	}

	/**
     * @title: insertSysResource
     * @author root
     * @description: 新增 sys_resource对象
     * @date 2018-06-22 09:09:44
     * @param dto
     * @return
     * @throws
     */
	@SuppressWarnings("all")
	public Long insertSysResource(SysResourceDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		int count = dao.insertSysResource(paramMap);
		
		SysResourceDTO resultDto = (SysResourceDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
	/**
     * @title: updateSysResource
     * @author root
     * @description: 修改 sys_resource对象
     * @date 2018-06-22 09:09:44
     * @param paramMap
     * @return
     * @throws
     */
	public void updateSysResource(SysResourceDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		
		dao.updateSysResource(paramMap);
	}
	/**
     * @title: deleteSysResourceByPrimaryKey
     * @author root
     * @description: 删除 sys_resource,按主键
     * @date 2018-06-22 09:09:44
     * @param paramMap
     * @throws
     */ 
	public void deleteSysResourceByPrimaryKey(SysResourceDTO dto,String ids) throws Exception {
		if(StringUtils.isEmpty(ids)) throw new Exception("删除失败！传入的参数主键为null");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		paramMap.put("ids", ids);
		dao.deleteSysResourceByPrimaryKey(paramMap);
	}
	/**
	 * 查询shiro的权限, URL-角色
	 * @param dto
	 * @return
	 */
	public List<SysResourceDTO> selectShiroRolePermission(SysResourceDTO dto){

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.selectShiroRolePermission(paramMap);
	}

	/**
	 * 查询shiro的权限, URL-权限
	 * @param dto
	 * @return
	 */
	public List<SysResourceDTO> selectShiroUrlPermission(SysResourceDTO dto){

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.selectShiroUrlPermission(paramMap);
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
	/**
	 * 分页查询例子
	 * @param dto
	 * @return
	 */
	public PageInfo<SysResourceDTO> selectPageDemo(SysResourceDTO dto){

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		PageHelper.startPage(2, 3);
		List<SysResourceDTO> list= dao.selectShiroUrlPermissionByUserId(paramMap);
		PageInfo<SysResourceDTO> pageInfo = new PageInfo(list);
		return pageInfo;
	}
}

